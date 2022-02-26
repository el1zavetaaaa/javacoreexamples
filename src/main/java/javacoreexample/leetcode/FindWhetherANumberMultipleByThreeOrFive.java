package javacoreexample.leetcode;

import java.util.Scanner;

/** Given a number n, for each integer in the range from
 * 1 to n inclusive, print one value per line as follows:
 * If n is a multiple of both 3 and 5, print FizzBuzz.
 * If n is a multiple of 3 (but not 5), print Fizz.
 * If n is a multiple of 5 (but not 3), print Buzz.
 * If n is not a multiple of 3 or 5, print the value of integer.
 */

public class FindWhetherANumberMultipleByThreeOrFive {
    public static void main(String[] args) {
        System.out.println("Please, enter the last number of massive.");
        Scanner in = new Scanner(System.in);
        int inputNumber = in.nextInt();
        for(int i =1; i <= inputNumber; i++){
            if (i%3 ==0 & i%5 ==0)
                System.out.println("FizzBuzz");
            else if (i%5 ==0)
                System.out.println("Buzz");
            else if (i%3 ==0)
                System.out.println("Fizz");
            else
                System.out.println(i);
        }
    }
}
