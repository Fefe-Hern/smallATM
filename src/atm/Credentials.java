package atm;

import java.io.Serializable;

/**
 * Node for typical bank-like accounts.
 */
public class Credentials implements Serializable{
    private String id; // Key Field
    private String pin;
    private int balance;

    public Credentials(String id, String pin) {
        this.id = id;
        this.pin = pin;
        this.balance = 0;
    }
    
    private Credentials(String id, String pin, int balance) {
        this.id = id;
        this.pin = pin;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Credentials{" + "id=" + id + ", pin=" + pin + ", balance=" + balance + '}';
    }

    public String getId() {
        return id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public Credentials deepCopy() {
        return new Credentials(this.id, this.pin, this.balance);
    }
}
