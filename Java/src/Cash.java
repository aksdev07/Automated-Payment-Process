class Cash extends Payment {
    private int cashAmount;

    public int getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    @Override
    public Boolean payAmount() {
        Boolean isPaid = false;
        if (this.getCashAmount() >= this.getDueAmount()) {
            isPaid = true;
        }
        return isPaid;
    }
}
