import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean condition = true;
        String ans ;
        try {
            while (condition) {
                Payment p = new Payment();
                Bill bill = new Bill();
                System.out.println(bill.processPayment(p));
                Thread.sleep(5000);
                System.out.println("DO YOU WANT TO GET MORE REPORTS ? (Y/N)");
                ans = sc.nextLine();
                if (ans.equalsIgnoreCase("y")) {
                    condition = true;
                } else if (ans.equalsIgnoreCase("n")) {
                    condition = false;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
