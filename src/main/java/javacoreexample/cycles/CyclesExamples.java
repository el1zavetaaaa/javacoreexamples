package javacoreexample.cycles;

import java.util.Scanner;

public class CyclesExamples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nextNumber;


        do {
            System.out.println("\nWhat do you want?\n1 - numbers in right order;" +
                    "\n2 - numbers in reverse order;" +
                    "\n3 - multiplication table; \n4 - sum; " +
                    "\n5 - exit.");
            nextNumber = sc.nextInt();
            switch (nextNumber) {
                case 1:
                    System.out.print("Numbers in right order: ");
                    for (int counter = 1; counter <= 5; counter++) {
                        System.out.print(counter + " ");
                    }
                    break;
                case 2:
                    System.out.print("\n" + "Numbers in reverse order: ");

                    for (int counter = 5; counter >= 1; counter--) {
                        System.out.print(counter + " ");
                    }
                    break;
                case 3:
                    System.out.print("\n" + "Multiplication table: ");

                    for (int counter = 1; counter <= 9; counter++) {
                        int sum = 3 * counter;
                        System.out.print("\n" + (3 + " * " + counter) + " = " + sum);
                    }
                    break;
                case 4:
                    Scanner scanner = new Scanner(System.in);


                    System.out.print("\n" + "Please, enter any number: ");
                    int getNumber = scanner.nextInt();
                    System.out.print("\n" + "Sum is: ");
                    int sum = 0;
                    for (int counter = 1; counter <= getNumber; counter++) {

                        sum = sum + counter;

                    }
                    System.out.print(sum);
                    break;
                case 5:
                    System.out.println("Have a good day");
                    break;
                default:
                    System.out.println("wrong choice");
            }

        }
        while (nextNumber != 5);
    }


}
