import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Bill extends Credit {
    private Scanner sc = new Scanner(System.in);
    private Scanner sc1 = new Scanner(System.in);
    private int cashAmount;
    private int creditAmount;
    private String cardType;
    private int chequeAmount;
    private String checqueDOI;
    private int chequeNo;
    private Cash cash = new Cash();
    private Credit credit = new Credit();
    private Cheque cheque = new Cheque();
    private String message = new String();
    private String paymentType = new String();

    public String processPayment(Payment obj) {
        try {
            System.out.println("Enter the Due amount");
            int a = sc.nextInt();
            obj.setDueAmount(a);
            System.out.println("Enter the mode of Payment (cash/cheque/credit)");
            paymentType = sc1.nextLine();
            switch (paymentType) {
                case "cash": {
                    cash.setDueAmount(obj.getDueAmount());
                    System.out.println("Enter the Cash Amount");
                    cashAmount = sc.nextInt();
                    cash.setCashAmount(cashAmount);
                    if (cash.payAmount()) {
                        message = "Payment done successfully via " + paymentType;
                    } else {
                        message = "Payment not done and your due amount is " + cash.getDueAmount();
                    }
                }
                break;
                case "credit": {
                    credit.setDueAmount(obj.getDueAmount());
                    System.out.println("Enter the Card Type");
                    cardType = sc1.nextLine();
                    credit.setCardType(cardType);
                    System.out.println("Enter the Credit Amount");
                    creditAmount = sc.nextInt();
                    credit.setCreditCardAmount(creditAmount);
                    if (credit.payAmount()) {
                        message = "Payment done successfully via creditCard. Remaining amount in your " + credit.getCardType() + " card is " + credit.getCreditCardAmount();
                    } else {
                        message = "Payment not done and your due amount is " + cash.getDueAmount();
                    }
                }
                break;
                case "cheque": {

                    System.out.println("Enter the Cheque No.");
                    chequeNo = sc.nextInt();
                    cheque.setCheckAmount(chequeNo);
                    System.out.println("Enter the Cheque Amount");
                    chequeAmount = sc.nextInt();
                    cheque.setCheckAmount(chequeAmount);
                    System.out.println("Enter the Date of Issue (dd/mm/yy)");
                    checqueDOI = sc.next();
                    SimpleDateFormat date = new SimpleDateFormat("dd/mm/yyyy");
                    Date date1 = date.parse(checqueDOI);
                    cheque.setDateOfIssue(date1);
                    if (cheque.payAmount()) {
                        message = "Payment done successfully via " + paymentType + " having Cheque No. = " + cheque.getChequeNo() + "with cheque amount " + cheque.getCheckAmount();
                    } else {
                        message = "Payment not done and your due amount is " + obj.getDueAmount();
                    }
                }
                break;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return message;
    }
}