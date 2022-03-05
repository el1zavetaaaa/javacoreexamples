package javacoreexample.streamapi;

import javacoreexample.streamapi.model.Account;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class CrazyStreamsExercises {

    static List<Account> accounts = new ArrayList<>();


    public static void main(String[] args) {

        accounts.add(new Account(1, "Account 1", "Account Last Name 1", 5000,
                "February", "male", "account1@gmail.com", 2003));
        accounts.add(new Account(3, "Account 3", "Account Last Name 3", 10_000,
                "April", "male", "account3@gmail.com", 1991));
        accounts.add(new Account(2, "Account 2", "Account Last Name 1", 6000,
                "March", "female", "account2@ukr.net", 2003));

        // Find an account with user's birthday month - March.
        List<Account> accountsWithMarchBirthdayMonth = accounts.stream()
                .filter(a -> a.getBirthdayMonth().equalsIgnoreCase("March"))
                .collect(toList());

        System.out.println("Accounts with user's birthday in March:");
        System.out.println(accountsWithMarchBirthdayMonth);

        // Divide accounts into 2 groups female and male.
        Map<Boolean, List<Account>> accountOfMaleAndFemale = accounts.stream()
                .collect(Collectors.partitioningBy(a -> a.getSex().equals("female")));

        System.out.println("\nDivision of accounts into 2 groups female and male.");
        System.out.println(accountOfMaleAndFemale);

        // Grouping accounts by their email domain.
        Map<String, List<Account>> groupingAccountsByEmailDomain = accounts.stream()
                .collect(Collectors.groupingBy(a -> a.getEmail().split("@")[1]));

        System.out.println("\nGrouping accounts by their email domain.");
        System.out.println(groupingAccountsByEmailDomain);

        // Get number of letters in first and last names.
        int getNumberOfLettersInFirstAndLastNames = accounts.stream()
                .mapToInt(a -> a.getFirstName().length())
                .sum();

        System.out.println("\nGet sum of number of letters in first and last names.");
        System.out.println(getNumberOfLettersInFirstAndLastNames);

        // Calculate total balance.
        Integer totalBalance = accounts.stream()
                .reduce(0, (partialBalanceResult, account) -> partialBalanceResult + account.getBalance(), Integer::sum);

        System.out.println("\nCalculate total balance.");
        System.out.println(totalBalance);

        // Sort accounts by name.
        List<Account> sortedListOfAccounts = accounts.stream()
                .sorted(Comparator.comparing(Account::getFirstName))
                .collect(toList());

        System.out.println("\nSort accounts by name.");
        System.out.println(sortedListOfAccounts);

        // Checks if there is at least one account with provided email domain.
        boolean checkWhetherThereIsAnyAccountWithSuchEmailDomain = accounts.stream()
                .anyMatch(a -> a.getEmail().split("@")[1].equals("gmail.com"));

        System.out.println("\nCheck whether there is any account with e-mail domain @gmail.com.");
        System.out.println(checkWhetherThereIsAnyAccountWithSuchEmailDomain);

        // Get balance by email.
        Integer getBalanceByEmail = null;
        try {
            getBalanceByEmail = accounts.stream()
                    .filter(a -> a.getEmail().equals("account1@gmail.com"))
                    .findAny()
                    .map(Account::getBalance)
                    .orElseThrow(() -> new Exception("There is no account with such email"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nThe balance of Account 1 is " + getBalanceByEmail);

        // Collect Accounts to Map by Id.
        Map<Integer, Account> collectAccountsById = accounts.stream()
                .collect(Collectors.toMap(Account::getId, identity()));

        System.out.println("\nCollect accounts to Map by Id.");
        System.out.println(collectAccountsById);

        /*
         * Filter accounts by the year when an account was created. Collects account balances by its emails into a {@link Map}.
         * The key is {@link Account#email} and the value is {@link Account#balance}
         */

        Map<String, Integer> filterTheAccountByTheYearOfCreationAndCollectThemToMapWIthEmailAsAKeyAndBalanceAsAValue =
                accounts.stream()
                        .filter(a -> a.getYearOfCreation() == 2003)
                        .collect(Collectors.toMap(Account::getEmail, Account::getBalance));

        System.out.println("\n1.Filter an Account by the Year of Creation." +
                "\n2.Collect Accounts to map with Email - as a Key and Balance - as a Value.");
        System.out.println(filterTheAccountByTheYearOfCreationAndCollectThemToMapWIthEmailAsAKeyAndBalanceAsAValue);

        /*
         * Returns a {@link Map} where key is {@link Account#lastName} and values is a {@link Set} that contains first names
         * of all accounts with a specific last name.
         */

        Map<String, Set<String>> getMapOfLastNamesAndSetOfFirstNamesOfAccounts = accounts.stream()
                .collect(groupingBy(Account::getLastName, mapping(Account::getFirstName, toSet())));

        System.out.println("\nCollect Accounts to Map where:" +
                "\n Key - LastName of Account;" +
                "\n Value - a Set of First Names of Accounts, according to Accounts' Last Name.");
        System.out.println(getMapOfLastNamesAndSetOfFirstNamesOfAccounts);

        /*
         * Returns a {@link Map} where key is a letter {@link Character}, and value is a number of its occurrences in
         * {@link Account#firstName}.
         */

        Map<Character, Long> getCharacterFrequencyInFirstName = accounts.stream()
                .map(Account::getFirstName)
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(groupingBy(identity(), counting()));

        System.out.println("\nGet Character Frequency in First Name of all Accounts.");
        System.out.println(getCharacterFrequencyInFirstName);


        /*
         * Returns a {@link Map} where key is a letter {@link Character}, and value is a number of its occurrences ignoring
         * case, in all {@link Account#firstName} and {@link Account#lastName} that are equal or longer than nameLengthBound.
         * Inside the map, all letters should be stored in lower case.
         *
         * @return a map where key is a letter and value is its count ignoring case in all first and last names
         */

        Map<Character, Long> getCharacterFrequencyIgnoreCaseInFirstAndLastNames = accounts.stream()
                .flatMap(a -> Stream.of(a.getFirstName(), a.getLastName()))
                .map(String::toLowerCase)
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(groupingBy(identity(), counting()));

        System.out.println("\nGet Character Frequency Ignore Case In First And Last Names of All Accounts.");
        System.out.println(getCharacterFrequencyIgnoreCaseInFirstAndLastNames);

    }

}
