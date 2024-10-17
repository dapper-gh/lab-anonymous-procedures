package labs.lambdas;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

interface CheckPerson {
  boolean test(Person p);
}

/**
 * JTLambdaExperiments.java
 *
 * A variety of experiments for working with lambdas, based on the
 * Java Tutorial on lambda expressions, available at
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 *
 * @author Samuel A. Rebelsky
 * @author David William Stroud
 * @author Sarah Deschamps
 */
public class JTLambdaExperiments {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run our experiments.
   */
  public static void main(String[] args) {
    ArrayList<Person> people = new ArrayList<Person>();
    people.add(
        new Person(
            "Sarah",
            IsoChronology.INSTANCE.date(2004, 6, 20),
            Person.Sex.MALE,
            "sarah@example.com"));
    people.add(
        new Person(
            "David",
            IsoChronology.INSTANCE.date(2005, 7, 15),
            Person.Sex.FEMALE, "david@example.com"));
    people.add(
        new Person(
            "Sam",
            IsoChronology.INSTANCE.date(1991, 8, 13),
            Person.Sex.MALE, "sam@example.com"));
    people.add(
        new Person(
            "Bob",
            IsoChronology.INSTANCE.date(2000, 9, 12),
            Person.Sex.MALE, "bob@example.com"));

    printPersons(
        people,
        new CheckPerson() {
          public boolean test(Person p) {
            return p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25;
          }
        });

    printPersons(
        people,
        (Person p) -> p.getGender() == Person.Sex.MALE
            && p.getAge() >= 18
            && p.getAge() <= 25);

    people
        .stream()
        .filter(
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25)
        .map(p -> p.getEmailAddress())
        .forEach(email -> System.out.println(email));
  } // main(String[])

  // +--------------------------------+------------------------------
  // | Methods from the Java Tutorial |
  // +--------------------------------+

  public static void printPersonsOlderThan(List<Person> roster, int age) {
    for (Person p : roster) {
      if (p.getAge() >= age) {
        p.printPerson();
      }
    }
  }

  public static void printPersonsWithinAgeRange(
      List<Person> roster, int low, int high) {
    for (Person p : roster) {
      if (low <= p.getAge() && p.getAge() < high) {
        p.printPerson();
      }
    }
  }

  public static void printPersons(
      List<Person> roster, CheckPerson tester) {
    for (Person p : roster) {
      if (tester.test(p)) {
        p.printPerson();
      }
    }
  }

  public static void printPersonsWithPredicate(
      List<Person> roster, Predicate<Person> tester) {
    for (Person p : roster) {
      if (tester.test(p)) {
        p.printPerson();
      }
    }
  }

  public static void processPersons(
      List<Person> roster,
      Predicate<Person> tester,
      Consumer<Person> block) {
    for (Person p : roster) {
      if (tester.test(p)) {
        block.accept(p);
      }
    }
  }

} // class JTLambdaExperiments
