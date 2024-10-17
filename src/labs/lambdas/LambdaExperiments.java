package labs.lambdas;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.io.PrintWriter;

/**
 * LambdaExperiments.java
 *
 * A variety of experiments for working with lambdas. 
 *
 * @author Samuel A. Rebelsky
 * @author David William Stroud
 * @author Sarah Deschamps
 */
public class LambdaExperiments {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run our experiments.
   */
  public static void main(String[] args) {
    String[] tmp =
      new String[] { "alpha", "bravo", "charlie", "delta", "echo",
                     "foxtrot", "golf", "hotel", "india",
                     "juliett", "kilo", "lima", "mike",
                     "november", "oscar", "papa", "quebec",
                     "romeo", "sierra", "tango", "uniform",
                     "victor", "whiskey", "xray", "yankee", "zulu" };
    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(tmp));
    
    ArrayList<String> longStrings = ListUtils.select(strings, s -> s.length() >= 5);

    PrintWriter pen = new PrintWriter(System.out, true);
    for (String s : longStrings) {
      pen.println(s);
    } // for

    ArrayList<String> vowelPairs = ListUtils.select(strings, s -> {
      String vowels = "aeiou";
      for (int i = 0; i < s.length() - 1; i++) {
        if (vowels.contains(Character.valueOf(s.charAt(i)).toString()) && vowels.contains(Character.valueOf(s.charAt(i + 1)).toString())) {
          return true;
        } // if
      } // for
      return false;
    });

    pen.println("-- vowels --");
    for (String s : vowelPairs) {
      pen.println(s);
    } // for

    ListUtils.remove(strings, s -> s.length() >= 5);
    ListUtils.remove(strings, s -> {
      String vowels = "aeiou";
      for (int i = 0; i < s.length() - 1; i++) {
        if (vowels.contains(Character.valueOf(s.charAt(i)).toString()) && vowels.contains(Character.valueOf(s.charAt(i + 1)).toString())) {
          return true;
        } // if
      } // for
      return false;
    });

    pen.println("-- removed --");
    for (String s : strings) {
      pen.println(s);
    } // for

    pen.println("Shortest: " + ListUtils.largest(strings, (s1, s2) -> s2.length() - s1.length()));
    pen.println("Longest: " + ListUtils.largest(strings, (s1, s2) -> s1.length() - s2.length()));
    pen.println("Highest ASCII Values: " + ListUtils.largest(strings, (s1, s2) -> s1.chars().sum() - s2.chars().sum()));
    pen.println("Smallest ASCII Values: " + ListUtils.largest(strings, (s1, s2) -> s2.chars().sum() - s1.chars().sum()));
  } // main(String[])

} // class LambdaExperiments
