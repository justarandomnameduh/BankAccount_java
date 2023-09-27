import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully added: $" + amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Successfully withdrawn: $" + amount);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid amount");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your account number: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid account number. Please provide a valid account number consisting of digits.");
            System.exit(0);
        }
        int accountNumber = scanner.nextInt();
      
        scanner.nextLine(); 
        System.out.print("Enter your account holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.print("Enter your initial balance: $");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid initial balance. Please provide a valid initial balance as a numeric value.");
            System.exit(0);
        }
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);

        boolean quit = false;
        while (!quit) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit funds");
            System.out.println("2. Withdraw funds");
            System.out.println("3. Check your balance");
    
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    double balance = account.checkBalance();
                    System.out.println("Your current balance: $" + balance);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
        scanner.close();
    }
}
