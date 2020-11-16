package gof.decorator.impl;

import gof.decorator.BankAccount;

import java.math.BigDecimal;

public class AuditableBankAccount implements BankAccount {

    public static BankAccount asAuditable(BankAccount toAudit) {
        return new AuditableBankAccount(toAudit);
    }

    private BankAccount decorated;

    private AuditableBankAccount(BankAccount bankAccount) {
        this.decorated = bankAccount;
    }

    @Override
    public String getIBAN() {
        return decorated.getIBAN();
    }

    @Override
    public void open(String firstName, String lastName, String pesel) {
        decorated.open(firstName, lastName, pesel);
    }

    @Override
    public BigDecimal close() {
        BigDecimal amount = decorated.close();
        return amount;
    }

    @Override
    public BigDecimal withdraw(BigDecimal amount) {
        BigDecimal money = decorated.withdraw(amount);
        return money;
    }

    @Override
    public BigDecimal deposit(BigDecimal amount) {
        BigDecimal money = decorated.deposit(amount);
        return money;
    }

    @Override
    public void transfer(BankAccount destination, BigDecimal amount) {
        decorated.transfer(destination, amount);
    }

}
