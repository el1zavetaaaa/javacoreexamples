package javacoreexample.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiInUse {
    public static void main(String[] args) {

        // method filter
        List<Integer> evenNumbers = Stream.of(1,2,3,4,5,6)
                .filter(x-> x%2==0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        //method peek
        List<String> peopleGreetings = Stream.of("Elena","Bob","Edward")
                .peek(x-> System.out.println("Hello, " + x + "!" ))
                .collect(Collectors.toList());

        //method generate
        ArrayList<String> programmingLanguagesList = new ArrayList<>();
        programmingLanguagesList.add("Java");
        programmingLanguagesList.add("Python");
        programmingLanguagesList.add("C++");

        Stream.generate(() ->{
            int value = (int) (Math.random()* programmingLanguagesList.size());
            return programmingLanguagesList.get(value);
        }).limit(5).forEach(System.out :: println);

        // method map
        List<Integer> castStringToInteger = Stream.of("24","548","24","45")
                .map(x-> Integer.valueOf(x)).collect(Collectors.toList());

        System.out.println(castStringToInteger);

        // method iterate
        Stream.iterate(3,x -> x*x).limit(2).forEach(System.out::println);
    }
}
