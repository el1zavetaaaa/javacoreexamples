package javacoreexample.threads.creationofthreads;

import java.util.Scanner;

import static javacoreexample.threads.creationofthreads.RunThreadUsingInheritance.startRunThreadUsingInheritance;
import static javacoreexample.threads.creationofthreads.RunThreadUsingInterfaceRunnable.startRunThreadUsingInterfaceRunnable;

public class SimpleThread {
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. run Thread using inheritance of class Thread.");
            System.out.println("2. run Thread using interface Runnable.");
            System.out.println("3. exit.");
            System.out.print("Please, enter the number:");
            int number;
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
            boolean shouldBreak = false;

            switch (number) {

                case (1):
                    startRunThreadUsingInheritance();
                    break;
                case (2):
                    startRunThreadUsingInterfaceRunnable();
                    break;
                case (3):
                    shouldBreak = true;
                    System.out.println("Thank you for your attention!");
                    break;
            }
            if (shouldBreak) break;
        }
    }

}
