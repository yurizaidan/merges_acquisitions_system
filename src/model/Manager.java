package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Manager extends User {

    public Manager(String first_name, String last_name, int id, Department department) {
        super(first_name, last_name, id, department);
        this.employment_type="Manager";
    }


    public static void updateOrderStatus() {
        int count = 0;

        if (isEmpty() == true) {
            System.out.println("No orders were found. Please try again after placing a first order. ");
        }
        else {
            System.out.println("\nCurrent orders in the queue: ");
            for (int i = 0; i < Session.index; i++) {
                listOrdersByUser(i);
            }

            System.out.println("\nPlease inform id code to review order: ");
            int target = Input.readInt();

            for (int i = 0; i < Session.index; i++) {
                for (int j = 0; j < Session.users[i].index; j++) {
                    if (target == Session.users[i].orders[j].getId()) {
                        if (Session.users[i].orders[j].getOrder_total_price() > Session.users[i].orders[j].getDepartment().getOrder_max_price()) {
                            System.out.println("This order cannot be approved since it exceeds the order maximum price set by the source department. ");
                            break;
                        } else {
                            System.out.println(Session.users[i].orders[j].getOrderSummary());
                            System.out.println("Order details: ");
                            for (int z = 0; z < Session.users[i].orders[j].index; z++) {
                                System.out.println(Session.users[i].orders[j].inventory[z].getAssetSummary());
                            }

                            System.out.println("\nWould you like to approve the order above? Press 1 - Approve, 2 - Reprove, or 3 - Abort operation: ");
                            int option = Input.readInt();
                            if (option == 1) {
                                Session.users[i].orders[j].setOrder_status("approved");
                                System.out.println("This order has been approved successfully. ");
                                System.out.println("Please inform order sign-off date (MM/dd/yyyy): ");
                                String order_signoff_date = Input.readString();
                                Session.users[i].orders[j].setOrder_signoff_date(order_signoff_date);
                            } else if (option == 2) {
                                Session.users[i].orders[j].setOrder_status("reproved");
                                System.out.println("This order has been reproved.");
                            } else {
                                System.out.println("Operation aborted.");
                            }
                            count++;
                            break;
                        }
                    }
                }
            }
            if (count == 0) {
                System.out.println("No orders were found. Please try again with a different id code.");
            }
        }
    }

    /*public static void updateOrderStatus () {
        int target = -1;
        System.out.println("Please inform order code to update order status: ");
        int id = Input.readInt();

        for (int i = 0; i < User.orders.length; i++) {
            if (id == User.orders[i].getId()) {
                target = i;
                break;
            }
        }

        if (User.orders[target].getOrder_total_price() > User.orders[target].getDepartment().getOrder_max_price()) {
            System.out.println("This order cannot be approved since it exceeds the order maximum price set by the source department. ");
        }
        else {
            System.out.println(User.orders[target].getOrderSummary());

            System.out.println("\nWould you like to approve the order above? Press 1 - Approve, 2 - Reprove, or 3 - Abort operation: ");

            int option = Input.readInt();
            if (option==1){
                User.orders[target].setOrder_status("approved");
                System.out.println("This order has been approved successfully. ");
                System.out.println("Please inform order sign-off date (MM/dd/yyyy): ");
                String order_signoff_date = Input.readString();
                User.orders[target].setOrder_signoff_date(order_signoff_date);
            }
            else if (option==2){
                User.orders[target].setOrder_status("reproved");
                System.out.println("This order has been reproved.");
            }
            else {
                System.out.println("Operation aborted.");
            }
        }
    }




    public void showAssetsByOrder() {
        int target = -1;
        System.out.println("Please inform order code: ");
        int id = Input.readInt();

        for (int i = 0; i < orders.length; i++) {
            if (id == orders[i].getId()) {
                target = i;
                break;
            }
        }

        if (Order.index == 0) {
            System.out.println("There are no assets registered at the moment for this order. ");
        }
        else {
            System.out.println("\nAssets summary:");
            for (int i = 0; i < index; i++) {
                System.out.println(Order.inventory[target].getAssetSummary());
            }
        }
    }

     */
    //Searches orders by user
    public static void searchOrderByUser() {
        if (isEmpty() == true) {
            System.out.println("\nNo orders were found. Please try again after placing a first order. ");
        } else {
            int count = 0;
            Session.listUsers();

            System.out.println("\nPlease inform user id code to display orders applicable: ");
            int target = Input.readInt();

            for (int i = 0; i < Session.index; i++) {
                for (int j = 0; j < Session.users[i].index; j++) {
                    if (target == Session.users[i].orders[j].getUser().getId()) {
                        System.out.println(Session.users[i].orders[j].getOrderSummary());
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println("No orders were found. Please try again with a different id code.");
            }
        }
    }
    //Searches order by asset description
    public static void searchOrderByDescription() {
        int count = 0;

        if (isEmpty() == true) {
            System.out.println("No orders were found. Please try again after placing a first order. ");
        }
        else {
            System.out.println("\nPlease inform asset description to locate order: ");
            String target = Input.readString();

            for (int i = 0; i < Session.index; i++) {
                for (int j = 0; j < Session.users[i].index; j++) {
                    for (int k = 0;k<Session.users[i].orders[j].index;k++){
                        if (target.equals(Session.users[i].orders[j].inventory[k].getDescription())) {
                            System.out.println(Session.users[i].orders[j].getOrderSummary());
                            count++;
                            break;
                        }
                    }
                }
                if (count == 0){
                    System.out.println("No orders were found. Please try again with a different asset description.");
                }
            }
        }
    }
    //Searches orders by time window
    public static void searchOrdersByDate() throws ParseException {
        if (isEmpty() == true) {
            System.out.println("No orders were found. Please try again after placing a first order. ");
        } else {
            int count = 0;
            System.out.println("\nPlease inform start date (MM/dd/yyyy): ");
            String start_date = Input.readString();

            System.out.println("\nPlease inform end date (MM/dd/yyyy): ");
            String end_date = Input.readString();

            System.out.println("\nOrders found between [" + start_date + "] and [" + end_date + "] :");
            for (int i = 0; i < Session.index; i++) {
                for (int j = 0; j < Session.users[i].index; j++) {
                    if (compareDates(Session.users[i].orders[j].getOrder_arrival_date(), start_date, end_date) == true) {
                        System.out.println(Session.users[i].orders[j].getOrderSummary());
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.println("No orders were found. Please try again with a different time stamp.");
            }
        }
    }
    public static boolean compareDates (String required_date, String start_date, String end_date) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date sDate=sdf.parse(start_date);
        Date eDate=sdf.parse(end_date);
        Date date=sdf.parse(required_date);

        if (date.compareTo(sDate)>=0 && date.compareTo(eDate)<=0){
            return true;
        }
        else {
            return false;
        }
    }
    //Print orders by status
    public static void showOrderByStatus() {
        if (isEmpty() == true) {
            System.out.println("No orders were found. Please try again after placing a first order. ");
        }
        else {
            double open_orders = 0;
            double approved_orders = 0;
            double reproved_orders = 0;
            double count = 0;

            for (int i = 0; i < Session.index; i++) {
                for (int j = 0; j < Session.users[i].index; j++) {
                    if (Session.users[i].orders[j].getOrder_status() == "open") {
                        open_orders++;
                        count++;
                    }
                    if (Session.users[i].orders[j].getOrder_status() == "approved") {
                        approved_orders++;
                        count++;
                    }
                    if (Session.users[i].orders[j].getOrder_status() == "reproved") {
                        reproved_orders++;
                        count++;
                    }
                }
            }

            double percent_approved_orders=(approved_orders/count)*100;
            double percent_reproved_orders=(reproved_orders/count)*100;
            double percent_open_orders=(open_orders/count)*100;

            System.out.println("Total number of orders: "+count);
            System.out.println("\nPercentage of approved orders (%):");
            System.out.printf("%.2f",percent_approved_orders);

            System.out.println("\nPercentage of reproved orders (%):");
            System.out.printf("%.2f", percent_reproved_orders);

            System.out.println("\nPercentage of open orders (%):");
            System.out.printf("%.2f",percent_open_orders);
        }
    }
    //Shows orders within a time window provided by user
    public static void showLastThirtyDaysOrders() throws ParseException {
        if (isEmpty() == true) {
            System.out.println("No orders were found. Please try again after placing a first order. ");
        }
        else {
            int count = 0;
            Date today = new Date();
            Calendar cal = new GregorianCalendar();
            cal.setTime(today);
            cal.add(Calendar.DAY_OF_MONTH, -30);
            Date last_thirty_days = cal.getTime();

            for (int i = 0; i < Session.index; i++) {
                for (int j = 0; j < Session.users[i].index; j++) {
                    String target_date = Session.users[i].orders[j].getOrder_arrival_date();

                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    Date date = sdf.parse(target_date);

                    if (date.compareTo(last_thirty_days) >= 0) {
                        System.out.println(Session.users[i].orders[j].getOrderSummary());
                        count++;
                    }

                }
            }
            if (count == 0) {
                System.out.println("No orders were found. Please try again with a different time stamp.");
            }
        }
    }

    public static void showOrdersByDepartment() {
        if (isEmpty() == true) {
            System.out.println("No orders were found. Please try again after placing a first order. ");
        }
        else {
            double total_orders_engineering = 0;
            double total_orders_uiux = 0;
            double total_orders_marketing = 0;
            double total_orders_business_development = 0;
            double total_orders_business_fpa = 0;
            double total_orders_sales = 0;

            for (int i = 0; i < Session.index; i++) {
                for (int j = 0; j < Session.users[i].index; j++) {
                    if (Session.users[i].orders[j].department.getName().equals("Engineering")) {
                        total_orders_engineering+=Session.users[i].orders[j].getOrder_total_price();
                    }
                    if (Session.users[i].orders[j].department.getName().equals("UI/UX")) {
                        total_orders_uiux+=Session.users[i].orders[j].getOrder_total_price();
                    }
                    if (Session.users[i].orders[j].department.getName().equals("Marketing")) {
                        total_orders_marketing+=Session.users[i].orders[j].getOrder_total_price();
                    }
                    if (Session.users[i].orders[j].department.getName().equals("Business Development")) {
                        total_orders_business_development+=Session.users[i].orders[j].getOrder_total_price();
                    }
                    if (Session.users[i].orders[j].department.getName().equals("FP&A")) {
                        total_orders_business_fpa+=Session.users[i].orders[j].getOrder_total_price();
                    }
                    if (Session.users[i].orders[j].department.getName().equals("Sales")) {
                        total_orders_sales+=Session.users[i].orders[j].getOrder_total_price();
                    }
                }
            }
            System.out.println("\nTotal orders price for department 'Engineering' (BRL): R$ "+total_orders_engineering);
            System.out.println("\nTotal orders price for department 'UI/UX'(BRL): R$ "+total_orders_uiux);
            System.out.println("\nTotal orders price for department 'Marketing'(BRL): R$ "+total_orders_marketing);
            System.out.println("\nTotal orders price for department 'Business Development'(BRL): R$ "+total_orders_business_development);
            System.out.println("\nTotal orders price for department 'FP&A'(BRL): R$ "+total_orders_business_fpa);
            System.out.println("\nTotal orders price for department 'Sales'(BRL) R$ "+total_orders_sales);
        }
    }

    public static void searchLargestOpenOrder() {
        if (isEmpty() == true) {
            System.out.println("No orders were found. Please try again after placing a first order. ");
        } else {
            int temp_user_index = 0;
            int temp_order_index = 0;
            double temp_max_order_price = 0;

            for (int i = 0; i < Session.index; i++) {
                for (int j = 0; j < Session.users[i].index; j++) {
                    if (Session.users[i].orders[j].order_status.equals("open")) {
                        temp_max_order_price = Session.users[i].orders[j].getOrder_total_price();
                        break;
                    }
                }
            }
            for (int i = 0; i < Session.index; i++) {
                for (int j = 0; j < Session.users[i].index; j++) {
                    if (Session.users[i].orders[j].order_status.equals("open") && temp_max_order_price < Session.users[i].orders[j].getOrder_total_price()) {
                        temp_max_order_price = Session.users[i].orders[j].getOrder_total_price();
                        temp_user_index = i;
                        temp_order_index = j;
                    }
                }
            }
            System.out.println("\n The largest open order is: \n"+Session.users[temp_user_index].orders[temp_order_index].getOrderSummary());
        }
    }
}
