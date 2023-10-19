public static void addAssetOrder() {
        if (Order.index > Order.inventory.length)
            throw new ArrayIndexOutOfBoundsException("Amount of assets has been exceeded by order. Please remove an existing asset and try again. ");
        else {
            Order.addAsset();
        }
    }
