package atm;

import java.io.Serializable;

public class Credentials implements Serializable{
    private String id; // Key Field
    private String pin;
    private int balance;

    public Credentials(String id, String pin) {
        this.id = id;
        this.pin = pin;
        this.balance = 0;
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
    
    
}
