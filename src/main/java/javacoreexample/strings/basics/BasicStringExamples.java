package javacoreexample.strings.basics;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class BasicStringExamples {
    public static void main(String[] args) {
        char[] chars = {'c', 'a', 't'};
        String str = new String(chars);
        System.out.println("\nString example: " + str);
        System.out.println("\nUnicode symbols: " + str.charAt(2) + " - " + str.codePointAt(2));
        System.out.println("\nString length: " + str.length());

        String str2 = "cat";
        System.out.println("\nCompare two strings using equals: " + str.equals(str2));

        String str3 = "CAT";
        System.out.println("Compare 2 strings using equals ignore case: " + str.equalsIgnoreCase(str3));


        System.out.println("\nReplace old character to a new one: " + str2.replace("a", "A"));

        String alex = String.valueOf(new Human("Alex"));
        System.out.println("\nMigrate objects to string value: " + alex);

        Integer integer = Integer.parseInt("45");
        System.out.println("Migrate a number into the string: " + integer);

        List<String> people = Arrays.asList("Person1", "Person2", "Person3");
        String peopleString = String.join(",", people);
        System.out.println("\nCollection of string to simple string: " + peopleString);

        String peopleArray = "Person1, Person2, Person3";
        String[] peopleArraySplit = peopleArray.split(",");
        System.out.print("Simple String to Collection of elements: ");
        for (String human : peopleArraySplit) {
            System.out.print(human);
        }

        String path = "D:\\Movies\\Futurama.mp4";
        int lastIndex = path.lastIndexOf('\\');
        String name = path.substring(lastIndex + 1);
        System.out.println("\n" + "\nGetting substring from String: " + name);

        String toLowerUpperCase = "String";
        System.out.println("\nString to lower case: "
                + toLowerUpperCase.toLowerCase(Locale.ROOT)
                + "\nString to upper case: " + toLowerUpperCase.toUpperCase());


        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("\nCapacity of empty string builder: " + stringBuilder.capacity());
        stringBuilder.append("Greetings");
        System.out.println("Length of string builder: " + stringBuilder.length());
        System.out.println("Return a substring from string builder: " + stringBuilder.substring(2, 4));
        System.out.println("Replace symbols in string builder: " + stringBuilder.replace(2, 4, "AA"));
        System.out.println("Change the order of symbols in string builder: " + stringBuilder.reverse());

    }
}
