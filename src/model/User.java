package model;
import java.text.ParseException;

public class User {
    protected String first_name, last_name, employment_type;
    protected int id;
    protected Department department;
    protected static Order orders[]=new Order[50];
    protected int index=0;

    public User (String first_name, String last_name, int id, Department department){
        this.first_name=first_name;
        this.last_name=last_name;
        this.id=id;
        this.department=department;
    }
    public static boolean addOrder (Order o){
        if (Session.users[Session.active_user_index].index> Session.users[Session.active_user_index].orders.length)
            throw new ArrayIndexOutOfBoundsException("Amount of orders has been exceeded by user. Please remove an existing order and try again. ");
        else {
            Session.users[Session.active_user_index].orders[Session.users[Session.active_user_index].index]=o;
            Session.users[Session.active_user_index].index++;
            return true;
        }
    }
    public static boolean createOrder() throws ParseException {
        if (Session.users[Session.active_user_index].index> Session.users[Session.active_user_index].orders.length)
            throw new ArrayIndexOutOfBoundsException("Amount of orders has been exceeded by user. Please remove an existing order and try again. ");
        else {
            System.out.println("Order request action");
            System.out.println("\nPlease inform the following information requested.");

            System.out.println("\nOrder id: ");
            int id=Input.readInt();

            System.out.println("\nOrder arrival date (MM/dd/yyyy): ");
            String arrival_date = Input.readString();

            Order o = new Order (id, arrival_date, Session.users[Session.active_user_index],Session.users[Session.active_user_index].getDepartment());
            Session.users[Session.active_user_index].orders[Session.users[Session.active_user_index].index]=o;

            System.out.println("\nThis order has been successfully created. ");

            int option=0;

            do {
                System.out.println("\nWould you like to add assets to this order? Yes - 1, or No - 2 ...");
                option = Input.readInt();
                switch(option) {
                    case 1:
                        Order.addAsset();
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Choose a valid option...\n:>");
                        break;
                }
            }
            while (option==1);


            Session.users[Session.active_user_index].index++;
            return true;
        }
    }

    //Checks if array of orders is empty for each user
    public static boolean isEmpty(){
        boolean flag = true;
        for (int i=0;i<Session.index;i++){
            if (Session.users[i].index!=0){
                flag = false;
            }
        }
        return flag;
    }
    //Prints orders
    public static void listOrders() {
        if (isEmpty() == true) {
            System.out.println("No orders were found. Please try again after placing a first order. ");
        }
        else {
            for (int i=0;i<Session.index;i++){
                listOrdersByUser(i);
            }
        }
    }
    //Prints orders by user
    public static void listOrdersByUser(int i) {

        for (int j=0;j<Session.users[i].index;j++) {
            if (Session.users[i].orders[j] != null) {
                System.out.println(Session.users[i].orders[j].getOrderSummary());
            }
        }
    }

    //Removes order from array based on order id
    public static void removeOrderByCode() {
        int count=0;

        if (isEmpty() == true) {
            System.out.println("No orders were found. Please try again after placing a first order. ");
        }
        else {
            for (int i = 0; i < Session.index; i++) {
                listOrdersByUser(i);
            }

            System.out.println("\nPlease inform id code to remove order: ");
            int target = Input.readInt();

            for (int i = 0; i < Session.index; i++) {
                for (int j = 0; j < Session.users[i].index; j++) {
                    if (target == Session.users[i].orders[j].getId()){
                        count++;
                    }
                    if (target == Session.users[i].orders[j].getId() && Session.users[i].orders[j].getUser() != Session.users[Session.active_user_index]) {
                        System.out.println("This order cannot be deleted because it was requested by a different user. Please switch active user in the current session to the order's requester user.");
                        break;
                    }
                    else if (target == Session.users[i].orders[j].getId() && Session.users[i].orders[j].getUser() == Session.users[Session.active_user_index]) {
                        for (int z = i; z < Session.users[i].index - 1; z++) {
                            Session.users[i].orders[j] = Session.users[i].orders[j + 1];
                        }
                        Session.users[i].orders[Session.users[i].index - 1] = null;
                        Session.users[i].index--;
                        System.out.println("Order has been removed from the system successfully. ");
                    }
                }
            }
            if (count == 0){
                System.out.println("No orders were found. Please try again with a different id code.");
            }
        }
    }

    public String getFirst_name() {

        return first_name;
    }

    public void setFirst_name(String first_name) {

        this.first_name = first_name;
    }

    public String getLast_name() {

        return last_name;
    }

    public void setLast_name(String last_name) {

        this.last_name = last_name;
    }

    public String getEmployment_type() {

        return employment_type;
    }

    public void setEmployment_type(String employment_type) {

        this.employment_type = employment_type;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public static Order[] getOrders() {

        return orders;
    }

    public static void setOrders(Order[] orders) {

        User.orders = orders;
    }

    public Department getDepartment() {

        return department;
    }

    public void setDepartment(Department department) {

        this.department = department;
    }

}
