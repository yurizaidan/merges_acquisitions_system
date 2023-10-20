package model;

public class Session {
    public static int active_user_index;
    public static User users[]=new User[20];
    static int index=0;

    public static boolean addUser (User u){
        if (index > users.length)
            throw new ArrayIndexOutOfBoundsException("System has exceeded the amount of accounts created. Please remove an existing user and try again. ");
        else {
            users[index]=u;
            index++;
            return true;
        }
    }

    public static void listUsers () {
        if (index == 0) {
            System.out.println("There are no employees registered at the moment. ");
        }
        else {
            System.out.println("\nUser accounts:");
            for (int i = 0; i < index;i++){
                System.out.println("\nUser id: "+users[i].getId()+" | First name: "+users[i].getFirst_name()+" | Department: "+users[i].getDepartment().name+" | Role: "+users[i].getEmployment_type());
            }
        }
    }

    public static void changeUserSession (){
        listUsers();
        System.out.println("\nPlease inform the user id you would like to switch account: ");
        int code=Input.readInt();
        for (int i=0;i<index;i++){
            if (users[i].getId()==code){
                active_user_index=i;
                break;
            }
        }
    }
    public static void showActiveUser (){
        System.out.println("\n*** Disclaimer: You are currently logged in as:");
        System.out.println("User id code: "+users[active_user_index].getId()+" | First name: "+users[active_user_index].getFirst_name()+" | Department: "+users[active_user_index].getDepartment().name+" | Role: "+users[active_user_index].getEmployment_type());
    }

}
