import java.util.Date;

public class Operation {
    private OperationType type;
    private int amount;
    private Date date;
    private int balance;

    public Operation(OperationType type, int amount, Date  date, int balance) {
        this.amount = amount;
        this.date = date;
        this.balance = balance;
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }
}
