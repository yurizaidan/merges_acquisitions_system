package model;

public class Department {
    protected String name;
    protected int order_max_price;

    public Department (String name, int order_max_price){
        this.name=name;
        this.order_max_price=order_max_price;
    }

    public int getOrder_max_price() {
        return order_max_price;
    }

    public void setOrder_max_price(int order_max_price) {

        this.order_max_price = order_max_price;
    }

    public String getName() {
        return name;
    }
}
