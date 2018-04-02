package Problem11_3;

import java.util.Date;

public class Account {
  private int accountNumber;
  private double balance, annualInterestRate;
  private Date dateCreated;


  public Account(){
    accountNumber = 0;
    balance = 0;
    annualInterestRate = 0;
    dateCreated = null;
  }

  public Account(double startBalance, double startInterest){
    accountNumber = 0;
    balance = startBalance;
    annualInterestRate = startInterest;
    dateCreated = null;
  }

  public void deposit(double amount){
    balance += amount;
  }

  public double withdraw(double amount){
    return balance -= amount;
  }
}
