public static boolean addOrder(Order o){
        if(index > orders.length)
            throw new ArrayIndexOutOfBoundsException("Amount of orders has been exceeded by user. Please remove an existing order and try again. ");
        else {
            orders[index] = o;
            index++;
            return true;
        }
