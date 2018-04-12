//package Problem11_3;

public class CSAccountTester {
  public static void main(String[] args){
    Account11_3 account = new Account11_3(001,100);
    CheckingAccount11_3 cAccount = new CheckingAccount11_3(002,100,50);
    SavingsAccount11_3 sAccount = new SavingsAccount11_3(003, 100);

    System.out.println(account.toString());
    System.out.println("\n" + cAccount.toString());
    System.out.println("\n" + sAccount.toString());
  }
}
