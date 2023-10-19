public String getOrderSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nOrder Summary: ");
        sb.append("\nOrder id: "+this.getId());
        sb.append("\nOrder arrival date (mm/dd/yyyy): "+this.getOrder_arrival_date());
        sb.append("\nOrder sign off (mm/dd/yyyy): "+this.getOrder_signoff_date());
        sb.append("\nOrder requester name: "+this.getUser().getFirst_name()+" "+this.getUser().getLast_name());
        sb.append("\nDepartment: "+this.getDepartment().name);
        sb.append("\nTotal order price (BRL): R$ "+this.getOrder_total_price());

        return sb.toString();
    }
