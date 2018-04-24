package Problem11_3;

public class CheckingAccount11_3 extends Account11_3 {

  double overdraftLimit;

  public CheckingAccount11_3() {
    super();
    overdraftLimit = 0;
  }

  public CheckingAccount11_3(double limit) {
    super();
    overdraftLimit = limit;
  }

  public CheckingAccount11_3(int identificationNumber, double initialBalance, double limit) {
    super(identificationNumber, initialBalance);
    overdraftLimit = limit;
  }

  /**
   * Withdraws money from the checking account, as long as there is money left in the account and/or
   * the amount withdrawn does not exceed the overdraft limit
   *
   * @param amount The amount of money to be withdrawn
   * @return The amount withdrawn, or as much of it as possible
   */
  @Override
  public double withdraw(double amount) {
    //There is less balance than money asked to be withdrawn
    if (this.getBalance() < amount) {
      //Case where there is more overdraft then amount asked for after balance
      if (overdraftLimit > amount - this.getBalance()) {
        this.overdraftLimit -= amount - this.getBalance();
        this.setBalance(0);
        return amount;
        //Case where there is not enough overdraft to cover the withdrawal
      } else {
        double toReturn = this.getBalance() + overdraftLimit;
        this.setBalance(0);
        overdraftLimit = 0;
        return toReturn;
      }
    }
    //Case when there is enough in the bank to withdraw the money without needing overdraft
    this.setBalance(this.getBalance() - amount);
    return amount;
  }
}
