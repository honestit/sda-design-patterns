package gof.decorator;

import gof.decorator.impl.LoggableBankAccount;

import java.math.BigDecimal;

public class DecoratorApp {

    public static void main(String[] args) {
        BankAccount account1 = new InMemoryBankAccount();
        account1.open("Jan", "kowalski", "22222222222");

        account1.deposit(BigDecimal.valueOf(1500));
        account1.withdraw(BigDecimal.valueOf(500));

        BankAccount account2 = new InMemoryBankAccount();
        account2.open("Tomasz", "Wójt", "66666666666");

        account1.transfer(account2, BigDecimal.valueOf(750));

        closeAccount(account1);
        closeAccount(account2);

        BankAccount loggableAccount = new LoggableBankAccount(new InMemoryBankAccount());

        loggableAccount.open("a", "b", "c");
        loggableAccount.deposit(BigDecimal.valueOf(20_000_000L));

        BankAccount doubleLoggedAccount = new LoggableBankAccount(new LoggableBankAccount(new InMemoryBankAccount()));
        doubleLoggedAccount.open("0", "1", "2");

        closeAccount(doubleLoggedAccount);
    }

    public static void closeAccount(BankAccount someBankAccount) {
        BigDecimal deposit = someBankAccount.close();
        System.out.println("Pozostało z konta " + someBankAccount.getIBAN() + ": " + deposit);
    }
}
