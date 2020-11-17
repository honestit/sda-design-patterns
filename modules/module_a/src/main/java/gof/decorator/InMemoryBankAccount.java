package gof.decorator;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

public class InMemoryBankAccount implements BankAccount {

    private String IBAN;

    private String firstName;
    private String lastName;
    private String pesel;

    private BigDecimal amount = new BigDecimal("0.00");

    private boolean open = false;

    @Override
    public void open(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.open = true;
//        this.IBAN = Long.toHexString(new Random().nextLong()).toUpperCase();
        this.IBAN = UUID.randomUUID().toString();
    }

    @Override
    public String getIBAN() {
        return this.IBAN;
    }

    @Override
    public BigDecimal close() {
        requireOpen();
        this.open = false;
        return amount;
    }

    @Override
    public BigDecimal withdraw(BigDecimal amount) {
        requireOpen();
        if (amount.compareTo(this.amount) > 0) {
            throw new IllegalArgumentException("Kwota do wypłaty przewyższa stan konta");
        }
        this.amount = this.amount.subtract(amount);
        return amount;
    }

    @Override
    public BigDecimal deposit(BigDecimal amount) {
        requireOpen();
        this.amount = this.amount.add(amount);
        return this.amount;
    }

    @Override
    public void transfer(BankAccount destination, BigDecimal amount) {
        requireOpen();
        amount = withdraw(amount);
        destination.deposit(amount);
    }

    private void requireOpen() {
        if (!open) {
            throw new IllegalStateException("Konto nie zostało otwarte lub jest zamknięte");
        }
    }

    @Override
    public String toString() {
        return "InMemoryBankAccount{" +
                "IBAN='" + IBAN + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", amount=" + amount +
                ", open=" + open +
                '}';
    }
}
