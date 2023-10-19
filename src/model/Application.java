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
