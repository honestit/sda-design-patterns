package gof.decorator;

import gof.decorator.impl.AuditableBankAccount;
import gof.decorator.impl.LoggableBankAccount;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

public class DecoratorApp {

    public static void main(String[] args) throws IOException {
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

        AuditableBankAccount.asAuditable(new LoggableBankAccount(new InMemoryBankAccount()));
        new LoggableBankAccount(AuditableBankAccount.asAuditable(new InMemoryBankAccount()));
        BankAccount someSuspisiousAccount = AuditableBankAccount.asAuditable(new InMemoryBankAccount());
        someSuspisiousAccount.open("Groźny", "Przestępca", "000000000000");
        someSuspisiousAccount.deposit(BigDecimal.valueOf(1000));
        someSuspisiousAccount.withdraw(BigDecimal.valueOf(999));

        closeAccount(someSuspisiousAccount);

        PrintWriter writer = new PrintWriter(new FileWriter(new File("abc.txt")));
    }

    public static void closeAccount(BankAccount someBankAccount) {
        BigDecimal deposit = someBankAccount.close();
        System.out.println("Pozostało z konta " + someBankAccount.getIBAN() + ": " + deposit);

        if (someBankAccount instanceof AuditableBankAccount) {
            // AuditableBankAccount auditable = (AuditableBankAccount) someBankAccount;
            List<String> history = ((AuditableBankAccount) someBankAccount).getHistory();
            for (String audit : history) {
                System.out.println("===> " + audit);
            }
        }
    }
}
