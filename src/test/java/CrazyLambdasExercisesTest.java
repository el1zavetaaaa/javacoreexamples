import javacoreexample.crazylambdas.CrazyLambdasExercises;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrazyLambdasExercisesTest {

    @Test
    @Order(1)
    void helloSupplier() {
        Supplier<String> helloSupplier = CrazyLambdasExercises.helloSupplier();

        assertEquals("Hello", helloSupplier.get());
    }

    @Test
    @Order(2)
    void isEmptyPredicate() {
        Predicate<String> isEmptyPredicate = CrazyLambdasExercises.isEmptyPredicate();

        boolean nonEmptyStringResult = isEmptyPredicate.test("fasdfa");
        boolean emptyStringResult = isEmptyPredicate.test("");

        assertFalse(nonEmptyStringResult);
        assertTrue(emptyStringResult);
    }

    @Test
    @Order(3)
    void stringMultiplier() {
        BiFunction<String, Integer, String> stringMultiplier = CrazyLambdasExercises.stringMultiplier();

        String threeTimesHi = stringMultiplier.apply("Hi", 3);
        String twoTimesHello = stringMultiplier.apply("Hello", 2);

        assertEquals("HiHiHi", threeTimesHi);
        assertEquals("HelloHello", twoTimesHello);
    }

    @Test
    @Order(4)
    void toDollarStringFunction() {
        Function<BigDecimal, String> toDollarStringFunction = CrazyLambdasExercises.toDollarStringFunction();
        String tenDollarStr = toDollarStringFunction.apply(BigDecimal.TEN.setScale(2));

        assertEquals("$10.00", tenDollarStr);
    }

    @Test
    @Order(5)
    void lengthInRangePredicate() {
        Predicate<String> lengthInRangePredicate = CrazyLambdasExercises.lengthInRangePredicate(4, 10);

        boolean twoLetterStringResult = lengthInRangePredicate.test("Hi");
        boolean fourLetterStringResult = lengthInRangePredicate.test("Hola");
        boolean fiveLetterStringResult = lengthInRangePredicate.test("Amigo");
        boolean eightLetterStringResult = lengthInRangePredicate.test("Lalaland");
        boolean thirteenLetterStringResult = lengthInRangePredicate.test("Lambda rocks!");

        assertFalse(twoLetterStringResult);
        assertTrue(fourLetterStringResult);
        assertTrue(fiveLetterStringResult);
        assertTrue(eightLetterStringResult);
        assertFalse(thirteenLetterStringResult);
    }

    @Test
    @Order(6)
    void randomIntSupplier() {
        IntSupplier randomIntSupplier = CrazyLambdasExercises.randomIntSupplier();

        int firstValue = randomIntSupplier.getAsInt();
        int secondValue = randomIntSupplier.getAsInt();

        assertNotEquals(firstValue, secondValue);
    }


    @Test
    @Order(7)
    void boundedRandomIntSupplier() {
        IntUnaryOperator boundedRandomIntSupplier = CrazyLambdasExercises.boundedRandomIntSupplier();

        int randomIntLessThan10 = boundedRandomIntSupplier.applyAsInt(10);
        int randomIntLessThan100 = boundedRandomIntSupplier.applyAsInt(100);
        int randomIntLessThan1000 = boundedRandomIntSupplier.applyAsInt(1000);
        int randomIntLessThan10000 = boundedRandomIntSupplier.applyAsInt(1000);

        assertTrue(randomIntLessThan10 < 10);
        assertTrue(randomIntLessThan100 < 100);
        assertTrue(randomIntLessThan1000 < 1000);
        assertTrue(randomIntLessThan10000 < 10000);
    }

    @Test
    @Order(8)
    void intSquareOperation() {
        IntUnaryOperator squareOperation = CrazyLambdasExercises.intSquareOperation();

        int squareOfFour = squareOperation.applyAsInt(4);
        int squareOfZero = squareOperation.applyAsInt(0);

        assertEquals(16, squareOfFour);
        assertEquals(0, squareOfZero);
    }

    @Test
    @Order(9)
    void longSumOperation() {
        LongBinaryOperator sumOperation = CrazyLambdasExercises.longSumOperation();


        long sumOfSevenAndEight = sumOperation.applyAsLong(7, 8);
        long sumOfTenAndZero = sumOperation.applyAsLong(10, 0);
        long sumOfFiveAndMinusTen = sumOperation.applyAsLong(5, -10);

        assertEquals(15, sumOfSevenAndEight);
        assertEquals(10, sumOfTenAndZero);
        assertEquals(-5, sumOfFiveAndMinusTen);
    }

    @Test
    @Order(10)
    void stringToIntConverter() {
        ToIntFunction<String> stringToIntConverter = CrazyLambdasExercises.stringToIntConverter();

        int num = stringToIntConverter.applyAsInt("234");
        int negativeNum = stringToIntConverter.applyAsInt("-122");

        assertEquals(234, num);
        assertEquals(-122, negativeNum);
    }

    @Test
    @Order(11)
    void nMultiplyFunctionSupplier() {
        Supplier<IntUnaryOperator> fiveMultiplyFunctionSupplier = CrazyLambdasExercises.nMultiplyFunctionSupplier(5);

        IntUnaryOperator multiplyByFiveOperation = fiveMultiplyFunctionSupplier.get();
        int result = multiplyByFiveOperation.applyAsInt(11); // 11 * 5 = 55

        assertEquals(55, result);
    }

    @Test
    @Order(12)
    void composeWithTrimFunction() {
        UnaryOperator<Function<String, String>> composeWithTrimFunction = CrazyLambdasExercises.composeWithTrimFunction();
        Function<String, String> toLowerWithTrim = composeWithTrimFunction.apply(String::toLowerCase);
        Function<String, String> threeTimesRepeatWithTrim = composeWithTrimFunction.apply(s -> s.repeat(3));

        String hey = toLowerWithTrim.apply("  Hey ");
        String threeTimesHi = threeTimesRepeatWithTrim.apply("  Hi  ");

        assertEquals("hey", hey);
        assertEquals("HiHiHi", threeTimesHi);
    }

    @Test
    @Order(13)
    void runningThreadSupplier() throws InterruptedException {
        Queue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        Supplier<Thread> runningThreadSupplier = CrazyLambdasExercises.runningThreadSupplier(() -> concurrentLinkedQueue.add(25));

        // supplier does not create and start a thread before you call get()
        assertEquals(0, concurrentLinkedQueue.size());

        Thread runningThread = runningThreadSupplier.get(); // new thread has been started
        runningThread.join();

        assertEquals(1, concurrentLinkedQueue.size());
        assertEquals(25, concurrentLinkedQueue.element().intValue());
    }

    @Test
    @Order(14)
    void newThreadRunnableConsumer() throws InterruptedException {
        Consumer<Runnable> newThreadRunnableConsumer = CrazyLambdasExercises.newThreadRunnableConsumer();

        Queue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        newThreadRunnableConsumer.accept(() -> concurrentLinkedQueue.add(50));

        Thread.sleep(500); // don't do that in real code

        assertEquals(1, concurrentLinkedQueue.size());
        assertEquals(50, concurrentLinkedQueue.element().intValue());
    }

    @Test
    @Order(15)
    void runnableToThreadSupplierFunction() throws InterruptedException {
        Function<Runnable, Supplier<Thread>> runnableSupplierFunction = CrazyLambdasExercises.runnableToThreadSupplierFunction();
        Queue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        Supplier<Thread> threadSupplier = runnableSupplierFunction.apply(() -> concurrentLinkedQueue.add(200));

        assertEquals(0, concurrentLinkedQueue.size()); // supplier does not create and start a thread before you call get()

        Thread thread = threadSupplier.get();// new thread has been started
        thread.join();

        assertEquals(1, concurrentLinkedQueue.size());
        assertEquals(200, concurrentLinkedQueue.element().intValue());
    }

    @Test
    @Order(16)
    void functionToConditionalFunction() {
        BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> intFunctionToConditionalIntFunction
                = CrazyLambdasExercises.functionToConditionalFunction();

        IntUnaryOperator abs = intFunctionToConditionalIntFunction.apply(a -> -a, a -> a < 0);

        assertEquals(5, abs.applyAsInt(-5));
        assertEquals(0, abs.applyAsInt(0));
        assertEquals(5, abs.applyAsInt(5));
    }

    @Test
    @Order(17)
    void functionLoader() {
        BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader = CrazyLambdasExercises.functionLoader();
        Map<String, IntUnaryOperator> functionMap = new HashMap<>();
        functionMap.put("increment", x -> x + 1);
        functionMap.put("square", x -> x * x);

        IntUnaryOperator incrementFunction = functionLoader.apply(functionMap, "increment");
        IntUnaryOperator squareFunction = functionLoader.apply(functionMap, "square");
        IntUnaryOperator identityFunction = functionLoader.apply(functionMap, "none");

        assertEquals(5, incrementFunction.applyAsInt(4));
        assertEquals(9, squareFunction.applyAsInt(3));
        assertEquals(10, identityFunction.applyAsInt(10));
    }

    @Test
    @Order(18)
    void trickyWellDoneSupplier() {
        Supplier<Supplier<Supplier<String>>> wellDoneSupplier = CrazyLambdasExercises.trickyWellDoneSupplier();

        String wellDoneStr = wellDoneSupplier.get().get().get();

        assertEquals("WELL DONE!", wellDoneStr);
    }

}
