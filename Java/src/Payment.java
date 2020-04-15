class Payment {
    public void setDueAmount(int dueAmount) {
        this.dueAmount = dueAmount;
    }

    public int getDueAmount() {
        return dueAmount;
    }

    public Boolean payAmount() {
        Boolean isPaid = false;
        if (this.getDueAmount() == 0) {
            isPaid = true;
        }
        return isPaid;
    }

    private int dueAmount;

}
