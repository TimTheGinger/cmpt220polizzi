package Problem10_5;

import java.util.Scanner;

public class PrimeFactors {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter a positive integer: ");
    long starttime = System.nanoTime();
    int scanned = scan.nextInt();

    int[] primesArray = primes(scanned);

    System.out.println(System.nanoTime() - starttime);

    for(int i = 0; i < primesArray.length; i++){
      System.out.print(primesArray[i] + " ");
    }
  }

  private static int[] primes(int val) {
    StackOfIntegers stackOfInts = new StackOfIntegers();


    int primeCheck = 2;

    while (val > primeCheck) {
      if (val % primeCheck == 0) {
        stackOfInts.push(primeCheck);
        val /= primeCheck;
      } else {
        primeCheck++;
      }
    }

    stackOfInts.push(val);

    int[] toReturn = new int[stackOfInts.getSize()];

    for (int i = 0; i < toReturn.length; i++) {
      toReturn[i] = stackOfInts.pop();
    }

    return toReturn;
  }
}
