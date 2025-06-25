import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transaction {

    private String type;
    private Double amount;
    private LocalDateTime timeStamp;

    public Transaction() {

    }

    public Transaction(String type, Double amount, LocalDateTime timeStamp) {
        this.type = type;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Transaction [amount=" + amount + ", timeStamp=" + timeStamp + ", type=" + type + "]";
    }

}

class Account {

    private int accountno;
    private String name;
    private String fname;
    private String aadhaar;
    private String phoneno;
    private double balance;
    private List<Transaction> trasaction = new ArrayList<>();

    public Account() {

    }

    public Account(int accountno, String name, String fname, String aadhaar, String phoneno, double balance) {
        this.accountno = accountno;
        this.name = name;
        this.fname = fname;
        this.aadhaar = aadhaar;
        this.phoneno = phoneno;
        this.balance = balance;
    }

    public int getAccountno() {
        return accountno;
    }

    public void setAccountno(int accountno) {
        this.accountno = accountno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTrasaction() {
        return trasaction;
    }

    public void setTrasaction(List<Transaction> trasaction) {
        this.trasaction = trasaction;
    }

    @Override
    public String toString() {
        return "Account [aadhaar=" + aadhaar + ", accountno=" + accountno + ", balance=" + balance + ", fname=" + fname
                + ", name=" + name + ", phoneno=" + phoneno + ", trasaction=" + trasaction + "]";
    }

}

public class Runner {

    private final static Scanner sc = new Scanner(System.in);
    private final static ArrayList<Account> allData = new ArrayList<Account>();
    private static int accountno = 1000;
    private static final double RATE = 4.5;

    public static void main(String[] args) {
        try {

            Runner bank = new Runner();

            while (true) {
                System.out.println("         welcome to uni bank ");
                System.out.println("****************************************************");
                System.out.println("         press 1  to add your account ");
                System.out.println("         press 2 for  deposit");
                System.out.println("         press 3  to check yor balance");
                System.out.println("         press 4 for withdrawal");
                System.out.println("         press 5 to check pervious transaction ");
                System.out.println("         prees 6 to calculate intreset ");
                System.out.println("         press 7 to exit ");
                System.out.println("****************************************************");

                int press = sc.nextInt();

                if (press == 1) {
                    bank.addAccount();
                }

                else if (press == 2) {
                    bank.deposit();

                } else if (press == 3)
                    bank.checkbalance();
                else if (press == 4) {
                    bank.withdraw();

                } else if (press == 5) {
                    bank.details();

                } else if (press == 6) {
                    bank.intrest();

                }

                else {
                    System.out.println("  ");
                    break;
                }

            }
        } catch (Exception e) {
            System.out.println("Something went wrong please try again later ");
        }

    }

    /**
     * withdraw- private funcation to withdraw
     */

    private void withdraw() {
        System.out.println("Enter the accoun*t number");
        int ac = sc.nextInt();
        boolean notfound = true;
        for (int j = 0; j < allData.size(); j++) {
            if (ac == allData.get(j).getAccountno()) {
                System.out.println("Enter the amount");
                double amount = sc.nextDouble();
                if (amount <= allData.get(j).getBalance()) {
                    double witdraw = allData.get(j).getBalance();
                    double real = witdraw - amount;
                    System.out.println("withdrawal success");
                    allData.get(j).setBalance(real);
                    double showamount = allData.get(j).getBalance();
                    System.out.println("your account balance is" + showamount);
                    notfound = false;

                }

            }

        }
        if (notfound) {
            System.out.println("Account not found ");
        }
    }

    /**
     * intrest- private funcation to calculate intrest
     */
    private void intrest() {
        System.out.println("Welcome to the Fix Deposit Section");
        System.out.println("Enter Amount you want to deplosit");
        double deposit_amount = sc.nextDouble();
        System.out.println("Enter No of years");
        int year = sc.nextInt();
        System.out.println("We provite a compunt interest at the Rate of " + RATE);

        double finalAmount = deposit_amount * (Math.pow((1 + RATE / 100), year));
        System.out.println("The compound interest for the given principle amount, rate and time is " + finalAmount);
    }

    private void details() {
        System.out.println("Enter the account number to check  ");
        int d = sc.nextInt();
        boolean notfound = true;

        for (int k = 0; k < allData.size(); k++) {
            if (d == allData.get(k).getAccountno()) {
                System.out.println(allData.get(k));
                notfound = false;
            }

        }
        if (notfound) {
            System.out.println("Account not found ");
        }

    }

    /**
     * checkbalance - private funcation to checkbalance
     */

    private void checkbalance() {

        System.out.println("Enter the account number to check balance ");
        int temccAountaNumber = sc.nextInt();
        boolean notfound = true;

        for (int k = 0; k < allData.size(); k++) {
            if (temccAountaNumber == allData.get(k).getAccountno()) {
                double ckbal = allData.get(k).getBalance();
                System.out.println(ckbal);
                notfound = false;

            }

        }
        if (notfound) {
            System.out.println("Account not found");
        }

    }

    /**
     * deposit- private funcation to deposit money
     */

    private void deposit() {
        System.out.println("Enter the acccount number ");
        int acctno = sc.nextInt();
        boolean notfound = true;

        for (int counter = 0; counter < allData.size(); counter++) {

            if (acctno == allData.get(counter).getAccountno()) {
                Account ac = allData.get(counter);
                Double tempbalance = ac.getBalance();
                System.out.println("Enter the ammount ");

                Double demobalance = sc.nextDouble();
                double bal = tempbalance + demobalance;
                allData.get(counter).setBalance(bal);
                allData.get(counter).getTrasaction().add(new Transaction("CREDIT", demobalance, LocalDateTime.now()));
                System.out.println("Money added ");
                notfound = false;
            }

        }
        if (notfound) {
            System.out.println("account not found ");
        }
    }

    /**
     * addAccount- private funcation to add a new account
     */
    private void addAccount() {
        Account a = new Account();

        System.out.println("    Enter the  name ");
        String name = null;
        while (true) {
            name = sc.next();
            if (!name.matches("^[a-zA-z\\s]*$")) {
                System.out.println("Enter valid name ");
            } else {
                break;

            }
        }
        System.out.println("    Enter the father name  ");
        String fname = null;

        while (true) {
            fname = sc.next();
            // Rejex Validations for name
            if (!fname.matches("^[a-zA-z\\s]*$")) {

                System.out.println("Enter valid father name ");
            } else {
                break;
            }
        }

        System.out.println("    Enter the aadhaar number ");
        String aadhaar = null;
        while (true) {
            aadhaar = sc.next();
            if (!aadhaar.matches("^[0-9\\s]*$")) {
                System.out.println("Enter valid aadhaar number  ");
            } else {
                break;

            }
        }

        System.out.println("    Enter the phone number ");
        String phoneno = null;
        while (true) {
            phoneno = sc.next();
            if (!phoneno.matches("^[0-9\\s]*$")) {

                System.out.println("Enter valid phone number  ");
            } else {
                break;

            }
        }
        Double accountbal = 0.00;
        a.setAadhaar(aadhaar);
        a.setFname(fname);
        a.setName(name);
        a.setPhoneno(phoneno);
        a.setAccountno(accountno);
        System.out.println("your account added ");
        System.out.println("your account balance is " + (accountbal));
        System.out.println("your account number is " + (accountno));
        allData.add(a);
        accountno++;
    }

}
