package javacoreexample.strings.basics;

import java.util.Scanner;

public class UsageOfScanner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the name:");
        String nameAndLastName = scanner.nextLine();
        int spaceIndex = nameAndLastName.indexOf(' ');
        System.out.println("Name: " + nameAndLastName.substring(0,spaceIndex));
        System.out.println("Surname:" + nameAndLastName.substring(spaceIndex));
    }

}
