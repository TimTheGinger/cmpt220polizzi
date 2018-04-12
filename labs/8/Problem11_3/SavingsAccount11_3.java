//package Problem11_3;

public class SavingsAccount11_3 extends Account11_3 {

  public SavingsAccount11_3() {
    super();
  }

  public SavingsAccount11_3(int identificationNumber, double initialBalance) {
    super(identificationNumber, initialBalance);
  }

  /**
   * Withdraws an amount of money from the bank account
   *
   * @param amount The amount of money to be withdrawn
   * @return The amount of money withdrawn or the remaining sum of money if the amount to be
   * withdrawn is greater than the current balance
   */
  @Override
  public double withdraw(double amount) {
    if (this.getBalance() - amount < 0) {
      return this.getBalance();
    }

    this.setBalance(this.getBalance() - amount);
    return amount;
  }
}
