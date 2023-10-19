public static boolean addAsset (){
        if (index>inventory.length) throw new ArrayIndexOutOfBoundsException("The inventory capacity has been exceeded. Please remove an existing asset already added to the inventory and try again.");
        else {
            System.out.println("Asset enrollment action");
            System.out.println("\nPlease inform the following information requested...");

            System.out.println("Asset name: ");
            String name = Input.readString();
            System.out.println("Asset description: ");
            String description = Input.readString();
            System.out.println("Asset unit price (BRL): ");
            double asset_unit_price = Input.readDouble();
            System.out.println("Asset total amount: ");
            int asset_total_amount = Input.readInt();
            double asset_total_price=asset_total_amount*asset_unit_price;

            order_total_price+=asset_total_price;

            Asset a = new Asset(name, description, asset_unit_price, asset_total_amount, asset_total_price);
            inventory[index]=a;
            index++;
            System.out.println("Asset has been successfully added to the inventory.");
            return true;
        }
    }
