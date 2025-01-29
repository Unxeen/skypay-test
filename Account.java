import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
public class Account implements AccountService{
    private int balance;
    private final ArrayList<Operation> transactions = new ArrayList<>();
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    // Deposit a certain amount into balance
    @Override
    public void deposit(int amount) {
        balance += amount;
        Date date = new Date();
        Operation transaction = new Operation(OperationType.DEPOSIT, amount, date, balance);
        transactions.add(transaction);
    }

    // Withdraw a certain amount from balance
    @Override
    public void withdraw(int amount) {
        balance -= amount;
        Date date = new Date();
        Operation transaction = new Operation(OperationType.WITHDRAWAL, amount, date, balance);
        transactions.add(transaction);
    }

    // Print history of the latest transactions
    @Override
    public void printStatement() {
        transactions.sort(Comparator.comparing(Operation::getDate).reversed());

        System.out.println("Date        ||  Amount    ||  Balance ");
        transactions.forEach(t -> {
            System.out.printf(
                    "%-10s  ||  %8d  ||  %8d  %n",
                    formatter.format(t.getDate()),
                    t.getType() == OperationType.WITHDRAWAL ? -t.getAmount() : t.getAmount(),
                    t.getBalance()
            );
        });
    }
}
