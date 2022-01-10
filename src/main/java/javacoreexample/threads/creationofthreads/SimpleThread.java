package javacoreexample.threads.creationofthreads;

import java.util.Scanner;

import static javacoreexample.threads.creationofthreads.RunThreadUsingInheritance.startRunThreadUsingInheritance;

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
                    startThreadsUsingInterfaceRunnable();
                    break;
                case (3):
                    shouldBreak = true;
                    System.out.println("Thank you for your attention!");
                    break;
            }
            if (shouldBreak) break;
        }
    }

    public static int counter;

    public static void startThreadsUsingInterfaceRunnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    counter = 0;
                    for (int i = 0; i < 10; i++) {
                        counter = counter + 1;
                        System.out.println(Thread.currentThread().getName() + ":" + counter);
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
