package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  import FunSets._

  test("contains with universal set") {
    assert(contains(x => true, 100))
  }

  test("contains with null set") {
    expectResult(false) {
      contains(x => false, 100)
    }

  }

  test("exists with universal set") {
    assert(exists(x => true, x => x > 100))
  }

  test("exists with null set") {
    expectResult(false) {
      exists(x => false, x => x > 100)
    }
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val emptySet: Set = x => false
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)

  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union: emptyset `union` s2 `union` s3 => s2 union s3 | verify element membership") {
    new TestSets {
      val s = union(union(s3, s2), emptySet)

      assert(contains(s, 3), "`result` should contain 3")
      assert(contains(s, 1) === false, "`result` should not contain 1")
    }
  }

  test("union: s1 `union` s2 `union` s3 => s1 union s2 union s3 | verify element membership") {
    new TestSets {
      val s123 = union(union(s3, s2), s1)

      assert(contains(s123, 3), "`result` should contain 3")
      assert(contains(s123, 2), "`result` should contain 2")
      assert(contains(s123, 1), "`result` should contain 1")

      assert(!contains(s123, 0), "`result` should not contain 1")
    }
  }

  test("union: s1 union s2 union s3 => all elements in s1+s2+s3") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect: s1 intersect s2 => empty set") {
    new TestSets {
      val s = intersect(s1, s2)
      assert(!contains(s, 1), "intersect should  result in empty set")
    }
  }

  test("intersect: s1 union s2 intersect s2 => s2 | verify nonexistent element") {
    new TestSets {
      val s = intersect(union(s1, s2), s2)
      assert(!contains(s, 0), "intersect should not nonexistent element in s1 union s2")
    }
  }

  test("intersect: s1 union s2 intersect s2 => {2} | verify element membership") {
    new TestSets {
      val s = intersect(union(s1, s2), s2)
      assert(contains(s, 2), "intersect should not contain 2")
    }
  }

  test("diff: s1 union s2 union s3 - emptyset => {1,2,3} | verify element membership") {
    new TestSets {
      val s123 = union(union(s1, s2), s3)
      val sDiff = diff(s123, emptySet)

      assert(contains(sDiff, 1), "should contain 1")
      assert(contains(sDiff, 2), "should contain 2")
      assert(contains(sDiff, 3), "should contain 3")
    }
  }

  test("diff: {s1 union s2 union s3} - {s2 union s3} => {1} | verify element membership") {
    new TestSets {
      val s123 = union(union(s1, s2), s3)
      val s23 = union(s2, s3)

      val sDiff = diff(s123, s23)

      assert(contains(sDiff, 1), "should contain 1")
      assert(!contains(sDiff, 2), "should not contain 2")
      assert(!contains(sDiff, 3), "should not contain 3")
    }
  }

  test("diff: {s1 union s2 union s3} - {s1 union s2 union s3} => {} | verify element membership") {
    new TestSets {
      val s123 = union(union(s1, s2), s3)
      val sDiff = diff(s123, s123)

      assert(!contains(sDiff, 1), "should not contain 1")
      assert(!contains(sDiff, 2), "should not contain 2")
      assert(!contains(sDiff, 3), "should not contain 3")
      assert(!contains(sDiff, 0), "should not contain 0")
    }
  }

  test("filter: {s1 `union` s3 `union` s2} with x `eq` 1 => {1}|verify filter membership") {
    new TestSets {
      val s123 = union(union(s1, s2), s3)
      val s_f = filter(s123, x => x == 1)

      assert(contains(s_f, 1), "should contain 1")
      assert(!contains(s_f, 0), "should not contain 1")
    }
  }

  test("filter: {s1 `union` s2 `union` s3 } with x `gt` 1 => {2,3}|verify filter membership") {
    new TestSets {
      val s123 = union(union(s1, s2), s3)
      val s_f = filter(s123, x => x > 1)

      assert(contains(s_f, 2), "should contain 2")
      assert(contains(s_f, 3), "should contain 3")
    }
  }

  test("filter: {s1 `union` s3 `union` s2} with  x>4  => {}|verify filter membership") {
    new TestSets {
      val s123 = union(union(s1, s2), s3)
      val s_f = filter(s123, x => x > 4)

      assert(!contains(s_f, 1), "should not contain 1")
      assert(!contains(s_f, 2), "should not contain 2")
      assert(!contains(s_f, 3), "should not contain 3")
      assert(!contains(s_f, 3), "should not contain 4")
    }
  }

  test("forall: {s1 `union` s3 `union` s2}  with different predicates|verify element membership") {
    new TestSets {

      val setUnion123 = union(union(s1, s2), s3)

      assert(forall(setUnion123, x => x > 0), "all elements should be greater than 0")
      assert(forall(setUnion123, x => x < 4), "all elements are less than 4")

      expectResult(false) { forall(setUnion123, x => x > 2) }
      expectResult(false) { forall(setUnion123, x => x > 3) }
    }
  }

  test("forall: {empty}  with different predicates|verify element membership") {
    new TestSets {

      assert(forall(emptySet, x => x > 0), "all elements should be greater than 0")
      assert(forall(emptySet, x => x < 4), "all elements are less than 4")

    }
  }

  test("exists: {empty}  with different predicates|verify element membership") {
    new TestSets {

      assert(!exists(emptySet, x => x > 0), "all elements should be greater than 0")
      assert(!exists(emptySet, x => x < 4), "all elements are less than 4")

    }
  }

  test("exits: {s1 `union` s3 `union` s2}  with different predicates|verify element membership") {
    new TestSets {
      val setUnion123 = union(union(s1, s2), s3)

      assert(exists(setUnion123, x => x > 0), "{1,2,3} must have  a element greater than 0")
      assert(forall(setUnion123, x => x < 4), "{1,2,3} must have  a element less than 04")

      expectResult(false) { exists(setUnion123, x => x > 3) }
      expectResult(true) { exists(setUnion123, x => x == 3) }
    }
  }
  
  test("map: {s1 `union` s3 `union` s2}  with x * x | verify element membership") {
    new TestSets {
      val setUnion123 = union(union(s1, s2), s3)
      val mappedSet = map(setUnion123, x => x*x)
      
      assert(contains(mappedSet, 1), "should not contain 1")
      assert(!contains(mappedSet, 2), "should not contain 2")
      assert(!contains(mappedSet, 3), "should not contain 3")
      assert(contains(mappedSet, 4), "should contain 4")
      assert(contains(mappedSet, 9), "should contain 9")
 
    }
  }
  
  test("map: {emptyset}  with x * x | verify element membership") {
    new TestSets {
      val mappedSet = map(emptySet, x => x*x)
      
      assert(!contains(mappedSet, 1), "should not contain 1")
      assert(!contains(mappedSet, 2), "should not contain 2")
      assert(!contains(mappedSet, 3), "should not contain 3")
      assert(!contains(mappedSet, 4), "should contain 4")
      assert(!contains(mappedSet, 9), "should contain 9")
 
    }
  }
}
