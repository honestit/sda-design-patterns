package gof.decorator;

import java.math.BigDecimal;

public interface BankAccount {

    String getIBAN();

    void open(String firstName, String lastName, String pesel);

    BigDecimal close();

    BigDecimal withdraw(BigDecimal amount);

    BigDecimal deposit(BigDecimal amount);

    void transfer(BankAccount destination, BigDecimal amount);
}
