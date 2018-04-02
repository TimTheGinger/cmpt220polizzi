package Problem11_3;

public class CSAccountTester {
  public static void main(String[] args){
    Account11_3 a = new Account11_3();

    a.deposit(100);
    System.out.println(a.withdraw(100));
  }
}
