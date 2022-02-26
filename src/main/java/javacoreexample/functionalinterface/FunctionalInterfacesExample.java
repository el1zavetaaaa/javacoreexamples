package javacoreexample.functionalinterface;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.*;

public class FunctionalInterfacesExample {
    public static void main(String[] args) {

        //Predicate

        Predicate<Integer> isOddNumber = x -> !(x%2==0);

        System.out.println(isOddNumber.test(3));
        System.out.println(isOddNumber.test(4));

        //Consumer

        Consumer<String> printMessage = x -> System.out.println("Hello, " + x + "!");

        printMessage.accept("Java");

        //Supplier

        ArrayList<String> namesOfProgrammingLanguages = new ArrayList<>();
        
        namesOfProgrammingLanguages.add("Java");
        namesOfProgrammingLanguages.add("C++");
        namesOfProgrammingLanguages.add("C#");
        namesOfProgrammingLanguages.add("Python");
        namesOfProgrammingLanguages.add(".Net");

        Supplier<String> randomNameOfProgrammingLanguage = () -> {
            int value = (int) (Math.random()*namesOfProgrammingLanguages.size());
            return namesOfProgrammingLanguages.get(value);
        };

        System.out.println(randomNameOfProgrammingLanguage.get());

        //Function

        Function<Integer,String> castIntegerToString = x -> String.valueOf(x);

        System.out.println(castIntegerToString.apply(566));

        //UnaryOperator

        System.out.println("Please enter an integer: ");
        Scanner in = new Scanner(System.in);
        int inputInteger = in.nextInt();
        UnaryOperator<Integer> multipleTable = x -> x * inputInteger;
        System.out.println(multipleTable.apply(3));
    }
}
