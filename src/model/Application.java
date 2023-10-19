package model;

import java.text.ParseException;

public class Application {
    public void runApp() throws ParseException {
        Environment.loadEnvironment();
        int option;
        do {
            showMenu();
            option=Input.readInt();
            switch(option){
                case 0:
                    break;
                case 1:
                    User.createOrder();
                    break;
                case 2:
                    User.addAssetOrder();
                    break;
                case 3:
                    User.listOrders();
                    break;
                case 4:
                    User.removeOrderByCode();
                    break;
                case 5:
                    Manager.searchOrderByUser();
                    break;
                case 6:
                    Manager.searchOrderByDescription();
                    break;
                case 7:
                    Manager.updateOrderStatus();
                    break;
                case 8:
                    Manager.showOrderByStatus();
                    break;
                case 9:
                    Manager.showLastThirtyDaysOrders();
                    break;
                /*case 10:
                    Manager.showOrderByDepartment();
                    break;
                case 11:
                    Manager.showLargestOpenOder();
                    break;*/
                case 99:
                    Session.changeUserSession();
                    break;
                default:
                    System.out.println("Invalid entry! Please choose a valid menu option...\n:>");
                    break;
            }
        }
        while (option!=0);
    }
  
  public static void showMenu() {

        if (Session.users[Session.active_user_index] instanceof Manager) {
        Session.showActiveUser();
        System.out.println("\n[99] --------------------------- Change user session");

        System.out.println("\n\n      Merge & Acquisition Management System         \n\n");

        System.out.println("[01] ----------------------------------- Place order");
        System.out.println("[02] --------------------------- Add assets to order");
        System.out.println("[03] ----------------------------------- List orders");
        System.out.println("[04] ---------------------------------- Remove order");
        System.out.println("[05] --------------------- Search order by requester");
        System.out.println("[06] ------------- Search order by asset description");
        System.out.println("[07] ---------------------------------  Review order");
        System.out.println("[08] -------------------------- List order by status");
        System.out.println("[09] ---------------------- List last-30-days-orders");
        System.out.println("[10] --------- List orders total price by department");
        System.out.println("[11] -------- List details of the largest open order");
        System.out.println("\n\n[00] ----------------------------------- Exit system");
        }
        else {
            Session.showActiveUser();
            System.out.println("\n[99] --------------------------- Change user session");

            System.out.println("\n\n      Merge & Acquisition Management System         \n\n");

            System.out.println("[01] ----------------------------------- Place order");
            System.out.println("[02] --------------------------- Add assets to order");
            System.out.println("[03] ----------------------------------- List orders");
            System.out.println("[04] ---------------------------------- Remove order");
            System.out.println("\n\n[00] ----------------------------------- Exit system");
        }
    }
}
