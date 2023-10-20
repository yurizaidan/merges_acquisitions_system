package model;

public class Order {
    protected User requester;
    protected Department department;
    protected String  order_arrival_date, order_signoff_date, order_status="open";
    protected int id;
    protected double order_total_price=0;
    protected static Asset inventory[] = new Asset[99];
    static int index=0;

    public Order (int id, String order_arrival_date, User requester, Department department){
        this.id=id;
        this.order_arrival_date=order_arrival_date;
        this.requester=requester;
        this.department=department;
        this.order_status="open";
    }
    public static boolean addAsset (Asset a){
        inventory[index]=a;
        index++;
        return true;
    }
    public static boolean addAsset(){
        if (index>inventory.length) throw new ArrayIndexOutOfBoundsException("The inventory capacity has been exceeded. Please remove an existing asset already added to the inventory and try again.");
        else {
            System.out.println("Asset enrollment action");
            System.out.println("\nPlease inform the following information requested...");

            System.out.println("\nAsset name: ");
            String name = Input.readString();
            System.out.println("\nAsset description: ");
            String description = Input.readString();
            System.out.println("\nAsset unit price (BRL): ");
            double asset_unit_price = Input.readDouble();
            System.out.println("\nAsset total amount: ");
            int asset_total_amount = Input.readInt();
            double asset_total_price=asset_total_amount*asset_unit_price;

            Asset a = new Asset(name, description, asset_unit_price, asset_total_amount, asset_total_price);
            Session.users[Session.active_user_index].orders[Session.users[Session.active_user_index].index].inventory[index]=a;
            //Adds total asset price to orders total price
            Session.users[Session.active_user_index].orders[Session.users[Session.active_user_index].index].order_total_price+=asset_total_price;
            index++;
            System.out.println("\nAsset has been successfully added to the inventory.");
            return true;
        }
    }


    public User getUser() {

        return requester;
    }

    public void setUser(User user) {

        this.requester = requester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Department getDepartment() {

        return department;
    }

    public void setDepartment(Department department) {

        this.department = department;
    }

    public String getOrder_arrival_date() {
        return order_arrival_date;
    }

    public void setOrder_arrival_date(String order_arrival_date) {
        this.order_arrival_date = order_arrival_date;
    }

    public String getOrder_signoff_date() {
        return order_signoff_date;
    }

    public void setOrder_signoff_date(String order_signoff_date) {
        this.order_signoff_date = order_signoff_date;
    }

    public String getOrder_status() {

        return order_status;
    }

    public void setOrder_status(String order_status) {

        this.order_status = order_status;
    }

    public double getOrder_total_price() {

        return order_total_price;
    }

    public void setOrder_total_price(double order_total_price) {

        this.order_total_price = order_total_price;
    }

    public static Asset[] getInventory() {

        return inventory;
    }

    public static void setInventory(Asset[] inventory) {

        Order.inventory = inventory;
    }

    public String getOrderSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nOrder Summary: ");
        sb.append("\nOrder id: "+this.getId());
        sb.append("\nOrder status: "+this.getOrder_status());
        sb.append("\nOrder arrival date (mm/dd/yyyy): "+this.getOrder_arrival_date());
        sb.append("\nOrder sign off (mm/dd/yyyy): "+this.getOrder_signoff_date());
        sb.append("\nOrder requester name: "+this.getUser().getFirst_name()+" "+this.getUser().getLast_name());
        sb.append("\nDepartment: "+this.department.name);
        sb.append("\nTotal order price (BRL): R$ "+this.order_total_price);

        return sb.toString();
    }
}
