package model;
import java.text.ParseException;


public class User {
    protected String first_name, last_name, employment_type;
    protected int id;
    protected Department department;
    protected static Order orders[]=new Order[99];
    static int index=0;

    public User (String first_name, String last_name, int id, Department department){
        this.first_name=first_name;
        this.last_name=last_name;
        this.id=id;
        this.department=department;
    }


public static boolean addOrder(Order o){
        if(index > orders.length)
            throw new ArrayIndexOutOfBoundsException("Amount of orders has been exceeded by user. Please remove an existing order and try again. ");
        else {
            orders[index] = o;
            index++;
            return true;
        }

public static boolean createOrder() throws ParseException {
        if (Session.users[Session.active_user_index].index> Session.users[Session.active_user_index].orders.length)
            throw new ArrayIndexOutOfBoundsException("Amount of orders has been exceeded by user. Please remove an existing order and try again. ");
        else {
            System.out.println("Order request action");
            System.out.println("\nPlease inform the following information requested...");

            System.out.println("Order id: ");
            int id=Input.readInt();

            System.out.println("Order arrival date (MM/dd/yyyy): ");
            String arrival_date = Input.readString();

            Order o = new Order (id, arrival_date, Session.users[Session.active_user_index],Session.users[Session.active_user_index].getDepartment());
            Session.users[Session.active_user_index].orders[index]=o;
            index++;
            return true;
        }
    }

public static void listOrders () {
        if (index == 0) {
            System.out.println("There are no orders registered at the moment. ");
        } else {
            System.out.println("\nOrders List: ");
            for (int i = 0; i < index;i++){
                System.out.println(orders[i].getOrderSummary());
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
                }
                else if (code==orders[i].getId() || orders[i].getUser().equals(Session.users[Session.active_user_index])){
                    for (int j=i;j<index-1;j++){
                        orders[j]=orders[j+1];
                    }
                    orders[index-1]=null;
                    index--;
                }
                else {
                    System.out.println("Order not found. Please try again. ");
                }
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
