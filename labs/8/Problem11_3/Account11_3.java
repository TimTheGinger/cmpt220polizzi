package Problem11_3;

import java.util.Date;

/**
 * A bank account object
 */
public class Account11_3 {

  private int id;
  private double balance, annualInterestRate;
  private Date dateCreated;

  /**
   * Instantiates a default bank account
   */
  public Account11_3() {
    id = 0;
    balance = 0;
    annualInterestRate = 0;
    dateCreated = new Date();
  }

  /**
   * Instantiates a bank account with a balance under an identification number
   *
   * @param identificationNumber The id of the bank account
   * @param initialBalance The amount of money in the bank account at time of initialization
   */
  public Account11_3(int identificationNumber, double initialBalance) {
    id = identificationNumber;
    balance = initialBalance;

    annualInterestRate = 0;
    dateCreated = new Date();
  }

  /**
   * Gets the ID of the bank account
   *
   * @return The integer ID of the bank account
   */
  public int getId() {
    int identity = id;
    return identity;
  }

  /**
   * Sets the ID of the bank account to something else and returns the old number
   *
   * @param newId The integer that the ID should be changed to
   * @return The old ID number
   */
  public int setId(int newId) {
    int identity = id;
    id = newId;

    return identity;
  }

  /**
   * Gets the balance of the bank account
   *
   * @return The double balance of the bank account
   */
  public double getBalance() {
    double bal = balance;
    return bal;
  }

  /**
   * Sets the balance of the bank account to the new balance and returns the old balance
   *
   * @param newBal The double the balance should be changed to
   * @return The old balance
   */
  public double setBalance(double newBal) {
    double bal = balance;
    balance = newBal;

    return bal;
  }

  /**
   * Gets the annual interest rate of the bank account
   *
   * @return The annual interest rate of the bank account
   */
  public double getAnnualInterestRate() {
    double air = annualInterestRate / 100;
    return air;
  }

  /**
   * Sets the annual interest rate of the bank account to the new interest rate and returns the old
   * interest rate
   *
   * @param newInterestRate The double the annual interest rate should be set to
   * @return The old interest rate
   */
  public double setAnnualInterestRate(double newInterestRate) {
    double air = annualInterestRate;
    annualInterestRate = newInterestRate;

    return air;
  }

  /**
   * Gets the date that the bank account was created on
   *
   * @return The date of the bank account's creation
   */
  public Date getDateCreated() {
    Date creationDate = dateCreated;
    return creationDate;
  }

  /**
   * Gets the monthly interest rate for the bank account
   *
   * @return The monthly interest rate
   */
  public double getMonthlyInterestRate() {
    double mir = annualInterestRate / 12;
    return mir / 100;
  }

  /**
   * Gets the amount of monthly interest for the bank account
   *
   * @return The amount of monthly interest the bank account accrues
   */
  public double getMonthtlyInterest() {
    return getAnnualInterestRate() * balance;
  }

  /**
   * Withdraws an amount of money from the bank account
   *
   * @param amount The amount of money to be withdrawn
   * @return The amount of money withdrawn or the remaining sum of money if the amount to be
   * withdrawn is greater than the current balance
   */
  public double withdraw(double amount) {
    if (balance - amount < 0) {
      return balance;
    }

    balance -= amount;
    return amount;
  }

  /**
   * Deposits an amount of money into the bank account
   *
   * @param amount The amount of money to be added to the bank account
   */
  public void deposit(double amount) {
    balance += amount;
  }

  /**
   * Returns a string representation of Account
   *
   * @return The string representation of Account
   */
  public String toString() {
    return "Account Number: " + id + "\nBalance: " + balance + "\nDate Created: " + dateCreated;
  }
}
