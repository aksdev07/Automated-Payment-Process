class Credit  extends Payment{
    private int creditCardNo;
    private String cardType;
    private int creditCardAmount;

    public int getCrediCardNo() {
        return creditCardNo;
    }

    public void setCrediCardNo(int creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getCreditCardAmount() {
        return creditCardAmount;
    }

    public void setCreditCardAmount(int creditCardAmount) {
        this.creditCardAmount = creditCardAmount;
    }

    @Override
    public Boolean payAmount() {
        Boolean isPaid = false;
        double serviceTax = 0;
        try {
            switch (this.getCardType()) {
                case "silver": {
                    serviceTax = 0.02 * 10000;
                }
                break;
                case "gold": {
                    serviceTax = 0.02 * 50000;
                }
                break;
                case "platinum": {
                    serviceTax = 0.02 * 100000;
                }
                break;
            }
            if (this.getCreditCardAmount() < this.getDueAmount() + serviceTax) {
                isPaid = false;
            } else if (this.getCreditCardAmount() >= this.getDueAmount() + serviceTax) {
                this.setCreditCardAmount((int) (this.getCreditCardAmount() - (this.getDueAmount() + serviceTax)));
                isPaid = true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return isPaid;
    }
}
