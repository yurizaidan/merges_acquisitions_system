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
