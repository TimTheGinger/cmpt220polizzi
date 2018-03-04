//package problem9_7;

public class AccountTester {

  public static void main(String[] args) {
    Account account1122 = new Account(1122,20000);

    account1122.setAnnualInterestRate(4.5);

    account1122.withdraw(2500);
    account1122.deposit(3000);

    System.out.println(account1122.getBalance());
    System.out.println(account1122.getMonthtlyInterest());
    System.out.println(account1122.getDateCreated().toString());
  }

}
