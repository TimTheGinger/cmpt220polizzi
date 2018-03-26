//package Problem10_3;

import java.util.*;

public class MyIntegerTester {

  public static void main(String[] args) {
    //get();
    evens();
    odds();
    primes();
    equality();
    parseChar();
    parseString();
  }

  private static void get() {
    MyInteger test = new MyInteger(1);

    System.out.println(test.getValue());
  }

  private static void evens() {
    MyInteger even = new MyInteger(222);
    MyInteger odd = new MyInteger(999);

    System.out.println(even.getValue() + " is even: " + even.isEven());
    System.out.println(odd.getValue() + " is even: " + odd.isEven());

    System.out.println(242 + " is even: " + MyInteger.isEven(242));
    System.out.println(191 + " is even: " + MyInteger.isEven(191));

    System.out.println("MyInteger even is even: " + MyInteger.isEven(even));
    System.out.println("MyInteger odd is even: " + MyInteger.isEven(odd));
  }

  private static void odds() {
    MyInteger even = new MyInteger(222);
    MyInteger odd = new MyInteger(999);

    System.out.println(even.getValue() + " is odd: " + even.isOdd());
    System.out.println(odd.getValue() + " is odd: " + odd.isOdd());

    System.out.println(242 + " is odd: " + MyInteger.isOdd(242));
    System.out.println(191 + " is odd: " + MyInteger.isOdd(191));

    System.out.println("MyInteger even is odd: " + MyInteger.isOdd(even));
    System.out.println("MyInteger odd is odd: " + MyInteger.isOdd(odd));
  }

  private static void primes() {
    MyInteger prime = new MyInteger(3);
    MyInteger notPrime = new MyInteger(4);

    System.out.println(prime.getValue() + " is prime: " + prime.isPrime());
    System.out.println(notPrime.getValue() + " is prime: " + notPrime.isPrime());

    System.out.println(5 + " is prime: " + MyInteger.isPrime(5));
    System.out.println(6 + " is prime: " + MyInteger.isPrime(6));

    System.out.println("MyInteger prime is prime: " + MyInteger.isPrime(prime));
    System.out.println("MyInteger not prime is prime: " + MyInteger.isPrime(notPrime));
  }

  private static void equality() {
    MyInteger myInt1 = new MyInteger(999);

    System.out.println("999 == myInt1: " + myInt1.equals(999));
    System.out.println("998 == myInt1: " + myInt1.equals(998));

    MyInteger myInt2 = new MyInteger(999);
    MyInteger myInt3 = new MyInteger(998);

    System.out.println("myInt2 == myInt1: " + myInt1.equals(myInt2));
    System.out.println("myInt3 == myInt1: " + myInt1.equals(myInt3));
  }

  private static void parseChar() {
    char[] charList = new char[3];
    charList[0] = '1';
    charList[1] = '2';
    charList[2] = '3';

    System.out.println(MyInteger.parseInt(charList));
  }

  private static void parseString() {
    String intStr = "123";

    System.out.println("\"123\" = " + MyInteger.parseInt(intStr));
  }

}
