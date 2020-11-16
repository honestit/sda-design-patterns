package gof.decorator.impl;

import gof.decorator.BankAccount;

import java.math.BigDecimal;

public class LoggableBankAccount implements BankAccount {

    private BankAccount decorated;

    public LoggableBankAccount(BankAccount decorated) {
        this.decorated = decorated;
    }

    @Override
    public void open(String firstName, String lastName, String pesel) {
        System.out.println("[LOG] Otwarto konto dla: " + firstName + " " + lastName + " (pesel: "  + pesel + ")");
        decorated.open(firstName, lastName, pesel);
        System.out.println("[LOG] Przydzielony IBAN: " + decorated.getIBAN());
    }

    @Override
    public String getIBAN() {
        return decorated.getIBAN();
    }

    @Override
    public BigDecimal close() {
        System.out.println("[LOG] Zamknięto konto " + decorated.getIBAN());
        return decorated.close();
    }

    @Override
    public BigDecimal withdraw(BigDecimal amount) {
        System.out.println("[LOG] Wypłata z konta " + decorated.getIBAN() + " kwoty " + amount);
        return decorated.withdraw(amount);
    }

    @Override
    public BigDecimal deposit(BigDecimal amount) {
        System.out.println("{LOG] Wpłata na konto " + decorated.getIBAN() + " kwoty " + amount);
        return decorated.deposit(amount);
    }

    @Override
    public void transfer(BankAccount destination, BigDecimal amount) {
        System.out.println("{LOG] Przelew z konta " + decorated.getIBAN() + " na konto "
                + destination.getIBAN() + " kwoty " + amount);
        decorated.transfer(destination, amount);
    }
}
