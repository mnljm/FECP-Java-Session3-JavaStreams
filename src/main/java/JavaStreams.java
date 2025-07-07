import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaStreams {

    public static class Person{
        private String name;
        private int age;

        Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName(){ return this.name; }
        public int getAge(){ return this.age; }
        public String toString(){
            return (this.name + " - " + this.age);
        }


    }

    public static void main(String[] args){

        //============== ACTIVITY 1 =================
        List<Integer> num = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> isOdd = n -> n % 2 != 0;

        List<Integer> oddResult = num.stream()
                .filter(isOdd)
                .toList();

        System.out.println("[Activity 1] Odd numbers: " + oddResult);

        //============== ACTIVITY 2 =================

        List<String> names = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian");
        Predicate<String> startsWithA = s -> s.startsWith("A");

        List<String> startsWithAResult = names.stream()
                .filter(startsWithA)
                .toList();

        System.out.println("[Activity 2] Names starting with A: " + startsWithAResult);


        //============== ACTIVITY 3 =================
        List<Integer> num2 = Arrays.asList(1,2,3,4,5);

        List<Integer> squared = num2.stream()
                .map(n -> n*n)
                .toList();

        System.out.println("[Activity 3] Squared numbers: " + squared);

        //============== ACTIVITY 4 =================

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> greaterThanFive = n -> n > 5;
        Predicate<Integer> isGreaterThanFiveAndIsEven = greaterThanFive.and(isEven);

        List<Integer> combinedResult = num.stream()
                .filter(isGreaterThanFiveAndIsEven)
                .toList();

        System.out.println("[Activity 4] Even and > 5: " + combinedResult);

        //============== ACTIVITY 5 =================

        List<Person> people = Arrays.asList(new Person("Nicholo", 24), new Person("Andric", 25), new Person("Cade", 23), new Person("Paolo", 25));


        List<Person> peopleByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .toList();

        List<Person> peopleAlphabetically = people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .toList();

        List<Person> reversePeopleByAge = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .toList();

        System.out.println("[Activity 5] \nSorted by age (ascending): "
        + peopleByAge + "\nSorted by name: " + peopleAlphabetically + "\nSorted by age (descending): " + reversePeopleByAge);









    }


}
