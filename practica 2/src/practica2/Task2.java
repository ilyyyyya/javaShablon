package practica2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human(25, "Harry", "Smith", LocalDate.of(2001, Month.FEBRUARY, 10), 90));
        humanList.add(new Human(45, "Jack", "Moore", LocalDate.of(1985, Month.MARCH, 12), 56));
        humanList.add(new Human(64, "Oliver ", "Martin", LocalDate.of(1948, Month.APRIL, 21), 78));
        humanList.add(new Human(13, "William", "Lee", LocalDate.of(2015, Month.JANUARY, 17), 50));

        Stream<Human> humanStream = humanList.stream();
        List<Integer> weightList = new ArrayList<>();
        weightList = humanStream.map(person -> person.getWeight()).collect(Collectors.toList());

        humanStream = humanList.stream();
        humanStream.filter(person->person.getWeight()%10 == 0)
                .sorted(Comparator.comparing(person -> person.getAW()))
                .sorted(Comparator.comparing(person -> person.getFirstName().charAt(1)))
                .forEach(person->person.print());

        Stream<Integer> weightStream = weightList.stream();
        Optional<Integer> comp = weightStream.reduce((a,b) -> a * b);
        System.out.println(comp.get());
    }
}
