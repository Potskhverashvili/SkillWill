import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ---------------------- Task 1 - Convert Even Numbers to Strings  ------------------------
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 66, 78);
        printFirstTask(numbers);

        // -------------------------- Task 2 - Get Filtered Person Names ---------------------------
        List<Person> personList = List.of(
                new Person(18, "Alika"),
                new Person(22, "Anzori"),
                new Person(25, "Olivia"),
                new Person(19, "Liam"),
                new Person(30, "Achiko"),
                new Person(27, "Sophia"),
                new Person(21, "Mason"),
                new Person(24, "Isabella"),
                new Person(28, "Jacob"),
                new Person(20, "Emma")
        );
        printSecondTask(personList);
    }

    //-------------------------------------------------- Methods ------------------------------------------
    // ------------ Extract Even Numbers as Strings Method -------------
    static List<String> convertEvenNumbersToString(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).map(num -> "Even Num: " + num).toList();
    }

    // ------------ Filter Person Names Method ------------
    static List<String> getFilteredPersonNames(List<Person> personList) {
        return personList.stream()
                .filter(person -> person.getAge() > 20 && !person.getName().toLowerCase().startsWith("a"))
                .map(person -> person.getName())
                .toList();
    }

    // ---------------------------------------- Print Functions ---------------------------------------------
    static void printFirstTask(List<Integer> numbers) {
        System.out.println("---------------------- Task 1 ---------------------------------");
        List<String> evenNumbers = convertEvenNumbersToString(numbers);
        System.out.println(evenNumbers);
    }

    static void printSecondTask(List<Person> personList) {
        System.out.println("\n---------------------- Task 2 ---------------------------------");
        System.out.println("Names Before Filter:\n" + personList.stream().map(Person::getName).toList());
        System.out.println("\nNames after Filter:\n" + getFilteredPersonNames(personList));
    }
}