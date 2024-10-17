package labs.lambdas;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ListUtils.java
 *
 * A variety of utilities for working with lists, developed as an
 * experiment in working with anonymous procedures.
 *
 * @author Samuel A. Rebelsky
 * @author David William Stroud
 * @author Sarah Deschamps
 */
public class ListUtils {

  /**
   * Select all the elements of vals for which pred holds.
   */
   public static <T> ArrayList<T> select(List<T> vals, Predicate<T> pred) {
    ArrayList<T> out = new ArrayList<>();
    for (T val : vals) {
      if (pred.test(val)) {
        out.add(val);
      } // if
    } // for
    return out;
  } // <T> select(List<T>, Predicate<T>)

  /**
   * Remove all the elements of vals for which pred holds.
   */
  public static <T> void remove(List<T> vals, Predicate<T> pred) {
    int i = 0;
    while (i < vals.size()) {
      if (pred.test(vals.get(i))) {
        vals.remove(i);
      } else {
        i++;
      } // if-else
    } // while
  } // remove(List<T>, Predicate<T>

  /**
   * Find the "largest" (most extreme) value of vals.
   */
  public static <T> T largest(List<T> vals, Comparator<T> compare) {
    T max = null;
    for (T val : vals) {
      if (max == null || compare.compare(max, val) < 0) {
        max = val;
      } // if
    } // for
    return max;
  } // largest(List<T>, Comparator<T>)

  /**
   * Everyone knows what map does, right?
   */
  public static <T,R> ArrayList<R> map(Function<T,R> fun, List<T> vals) {
    return null;
  } // map(Function<T,R>, List<T>) 

} // class ListUtils
