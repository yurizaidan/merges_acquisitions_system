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

public static void updateOrderStatus () {
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


    public static void showAssetsByOrder() {
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
                System.out.println(Order.inventory[target].assetSummary());
            }
        }
    }

    public static void removeOrderByCode() {
        int temp=-1;
        if (User.index == 0) {
            System.out.println("There are no orders registered at the moment. ");
        }
        else{
            listOrders();
            System.out.println("Please inform code to remove order...: ");
            int code=Input.readInt();

            for (int i=0;i<index;i++){
                if (code==orders[i].getId() || !orders[i].getUser().equals(Session.users[Session.active_user_index])){
                    System.out.println("This order cannot be deleted because it was requested by a different user. Please change active user in the current session to the order's requester user.");
                    break;
                }
                else if (code==orders[i].getId() || orders[i].getUser().equals(Session.users[Session.active_user_index])){
                    for (int j=i;j<index-1;j++){
                        orders[j]=orders[j+1];
                    }
                    orders[index-1]=null;
                    index--;
                    break;
                }
                else {
                    System.out.println("Order not found. Please try again. ");
                    break;
                }
            }
        }
    }

public static void searchOrderByUser() {
        Session.listUsers();

        if (Session.index == 0) {
            System.out.println("Please first enroll a new user in the system.");
        } else {
            int target = -1;
            System.out.println("Please inform employee's id code: ");
            int id = Input.readInt();

            for (int i = 0; i < Session.users.length; i++) {
                if (id == Session.users[i].getId()) {
                    target = i;
                    break;
                }
            }

            for (int i = 0; i < User.orders.length; i++) {
                if (User.orders[i].getUser().getId() == target) {
                    System.out.println(User.orders[target].getOrderSummary());
                }
            }
        }
    }

    public static void searchOrderByDescription(){
        if (User.index == 0) {
            System.out.println("\nThere are no orders registered at the moment. ");
        }
        else {
            System.out.println("\nPlease inform order description: ");
            String order_description = Input.readString();
            int target=-1;
            for (int i = 0; i < User.orders.length; i++){
                for (int j = 0;j <User.orders[j].getInventory().length;j++){
                    if (order_description.equals(User.orders[i].getInventory()[j].getDescription())){
                        target=i;
                    }
                }
            }
        }
    }

    public static void searchOrdersByDate() throws ParseException {
        if (User.index == 0) {
            System.out.println("\nThere are no orders registered at the moment. ");
        }
        else {
            System.out.println("\nPlease inform start date (MM/dd/yyyy): ");
            String start_date = Input.readString();

            System.out.println("\nPlease inform end date (MM/dd/yyyy): ");
            String end_date= Input.readString();

            System.out.println("\nOrders: ");
            for (int i = 0; i < User.orders.length; i++) {
                System.out.println("Orders found between ["+start_date+"] and ["+end_date+"] :");
                if (compareDates(User.orders[i].getOrder_arrival_date(),start_date, end_date)==true) {
                    System.out.println("|"+(i+1)+"| "+User.orders[i].getOrderSummary());
                }
            }
        }
    }
