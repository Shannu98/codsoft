import java.util.Scanner;

class BankAccount{
    private String name;
    private String userName;
    private String password;
    private String accountNo;
    private float balance = 100000f;
    private int transactions = 0;
    private StringBuilder transactionHistory = new StringBuilder();

    public BankAccount(String name, String userName, String password, String accountNo) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.accountNo = accountNo;
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        try {
            float amount = sc.nextFloat();
            if (amount <= 0) {
                System.out.println("Invalid input. Enter a valid positive amount.");
            } else if (balance < amount) {
                System.out.println("Insufficient Balance");
            } else {
                balance -= amount;
                recordTransaction(-amount);
                System.out.println(String.format("%.2f Rs Withdrawn. Withdrawal successful", amount));
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Enter a valid number.");
        }
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        Scanner sc = new Scanner(System.in);
        try {
            float amount = sc.nextFloat();
            if (amount <= 0) {
                System.out.println("Invalid input. Enter a valid positive amount.");
            } else if (amount > 100000f) {
                System.out.println("Sorry, the deposit limit is 100,000.00 Rs");
            } else {
                balance += amount;
                recordTransaction(amount);
                System.out.println(String.format("%.2f Rs Deposited. Deposit successful", amount));
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Enter a valid number.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance + " Rs");
    }

    public void transHistory() {
        System.out.println("Transaction History:");
        if (transactions == 0) {
            System.out.println("Empty");
        } else {
            String[] transactions = transactionHistory.toString().split("\n");
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private void recordTransaction(float amount) {
        transactions++;
        String transaction = (amount >= 0) ? "Deposited" : "Withdrawn";
        String str = String.format("%.2f Rs %s\n", Math.abs(amount), transaction);
        transactionHistory.append(str);
    }
}

public class AtmInterface {

    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean validInput = false;
        Scanner sc = new Scanner(System.in);

        while (!validInput) {
            try {
                input = sc.nextInt();
                if (input >= 1 && input <= limit) {
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please choose a number between 1 and " + limit);
                    System.out.print("Enter Your Choice - ");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Enter a valid integer.");
                System.out.print("Enter Your Choice - ");
                sc.nextLine(); // Clear the input buffer
            }
        }
        return input;
    }

    public static void stylishWelcome() {
        System.out.println("*********************************************");
        System.out.println("               WELCOME TO ATM                ");
        System.out.println("*********************************************");
    }

    public static void main(String[] args) {
        stylishWelcome();

        BankAccount account = new BankAccount("Tommy", "tommy12345", "password", "1234567890");

        boolean isFinished = false;
        while (!isFinished) {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice - ");
            int choice = takeIntegerInput(5);

            switch (choice) {
                case 1:
                    account.withdraw();
                    break;
                case 2:
                    account.deposit();
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.transHistory();
                    break;
                case 5:
                    isFinished = true;
                    System.out.println("Exiting ATM. Thank You!");
                    break;
            }
        }
    }
}