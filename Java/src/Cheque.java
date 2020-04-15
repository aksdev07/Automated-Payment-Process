import java.util.Date;

class Cheque extends Payment {
    private String chequeNo;
    private int checkAmount;
    private Date dateOfIssue;


    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }


    public int getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(int checkAmount) {
        this.checkAmount = checkAmount;
    }


    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    @Override
    public Boolean payAmount() {
        Boolean isPaid = false;
        Date date = new Date(01012020);
        if (getDateOfIssue().compareTo(date) < 0) {
            if (getCheckAmount() >= this.getDueAmount()) {
                isPaid = true;
            }
        }
        return isPaid;
    }
}
