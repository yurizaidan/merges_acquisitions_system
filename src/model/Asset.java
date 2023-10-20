package model;

public class Asset {
    protected String name, description;
    protected double asset_unit_price, asset_total_price;
    protected int amount;

    public Asset(String name, String description, double asset_unit_price, int amount, double asset_total_price) {
        this.name = name;
        this.description = description;
        this.asset_unit_price = asset_unit_price;
        this.amount = amount;
        this.asset_total_price = asset_total_price;

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public double getAsset_unit_price() {

        return asset_unit_price;
    }

    public void setAsset_unit_price(double asset_unit_price) {

        this.asset_unit_price = asset_unit_price;
    }

    public double getAsset_total_price() {

        return asset_total_price;
    }

    public void setAsset_total_price(double asset_total_price) {

        this.asset_total_price = asset_total_price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {

        this.amount = amount;
    }

    public StringBuilder getAssetSummary(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n   Asset summary: ");
        sb.append("\n   Name: "+this.getName());
        sb.append("\n   Description: "+this.getDescription());
        sb.append("\n   Unit price (BRL): R$ "+this.getAsset_unit_price());
        sb.append("\n   Amount: "+this.getAmount());
        sb.append("\n   Total asset price (BRL): R$"+(this.getAsset_unit_price()*this.getAmount()));

        return sb;
    }
}
