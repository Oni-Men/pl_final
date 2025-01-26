package vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import vm.pobject.PInteger;
import vm.pobject.PSet;
import vm.pobject.PString;
import vm.pobject.PValue;

public class PSetTest
{

  @Test
  void testValueEquality()
  {
    PValue aValue01 = new PInteger(1);
    PValue aValue02 = new PInteger(1);
    PValue aValue03 = new PInteger(2);

    assertTrue(aValue01.equals(aValue02));
    assertFalse(aValue01.equals(aValue03));

    PValue aValue04 = new PString("xyz");
    PValue aValue05 = new PString("xyz");
    PValue aValue06 = new PString("xxx");

    assertTrue(aValue04.equals(aValue05));
    assertFalse(aValue04.equals(aValue06));
  }

  @Test
  void testInclude()
  {
    PValue value1 = new PInteger(1);
    PValue value2 = new PInteger(2);
    PValue anotherValue1 = new PInteger(1);

    PSet aSet = new PSet(value1, value2);

    assertTrue(aSet.include(value1).value());
    assertTrue(aSet.include(value2).value());
    assertTrue(aSet.include(anotherValue1).value());
  }

  @ParameterizedTest
  @MethodSource("equalsTestCaseProvider")
  void testSetEquals(PSet firstSet, PSet secondSet, boolean expected)
  {
    boolean result = firstSet.equals(secondSet);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @MethodSource("unionTestCaseProvider")
  void testSetUnion(PSet firstSet, PSet secondSet, PSet expected)
  {
    PSet result = firstSet.union(secondSet);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @MethodSource("differenceTestCaseProvider")
  void testSetDiffrence(PSet firstSet, PSet secondSet, PSet expected)
  {
    PSet result = firstSet.difference(secondSet);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @MethodSource("intersectTestCaseProvider")
  void testSetIntersect(PSet firstSet, PSet secondSet, PSet expected)
  {
    PSet result = firstSet.intersect(secondSet);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @MethodSource("exclusiveTestCaseProvider")
  void testSetExclusive(PSet firstSet, PSet secondSet, PSet expected)
  {
    PSet result = firstSet.exclusive(secondSet);
    assertEquals(expected, result);
  }

  static Stream<Arguments> equalsTestCaseProvider()
  {
    return Stream.of(
        arguments(
            fromIntegres(4, 5, 6),
            fromIntegres(5, 6, 4),
            true),
        arguments(
            fromIntegres(1, 2, 3),
            fromIntegres(2, 3, 4),
            false),
        arguments(
            fromStrings("apple", "banana", "persimmon"),
            fromStrings("banana", "apple", "persimmon"),
            true),
        arguments(
            fromStrings("X", "Y", "Z"),
            fromStrings("A", "B", "C"),
            false));
  }

  static Stream<Arguments> unionTestCaseProvider()
  {
    return Stream.of(
        arguments(
            fromIntegres(1, 2, 3),
            fromIntegres(3, 4, 5),
            fromIntegres(1, 2, 3, 4, 5)),
        arguments(
            fromIntegres(1, 2),
            fromIntegres(5, 6),
            fromIntegres(1, 2, 5, 6)),
        arguments(
            fromIntegres(),
            fromIntegres(1, 2, 3),
            fromIntegres(1, 2, 3)),
        arguments(
            fromIntegres(7, 8, 9),
            fromIntegres(),
            fromIntegres(7, 8, 9)),
        arguments(
            fromIntegres(),
            fromIntegres(),
            fromIntegres()));
  }

  static Stream<Arguments> differenceTestCaseProvider()
  {
    return Stream.of(
        arguments(
            fromIntegres(1, 2, 3, 4, 5),
            fromIntegres(3, 4, 5),
            fromIntegres(1, 2)),
        arguments(
            fromIntegres(1, 3, 5, 7, 9),
            fromIntegres(2, 3, 5, 7),
            fromIntegres(1, 9)),
        arguments(
            fromIntegres(2, 3, 5, 7),
            fromIntegres(1, 3, 5, 7, 9),
            fromIntegres(2)),
        arguments(
            fromIntegres(),
            fromIntegres(1, 2, 3),
            fromIntegres()),
        arguments(
            fromIntegres(5, 6, 7),
            fromIntegres(),
            fromIntegres(5, 6, 7)),
        arguments(
            fromIntegres(),
            fromIntegres(),
            fromIntegres()));
  }

  static Stream<Arguments> intersectTestCaseProvider()
  {
    return Stream.of(
        arguments(
            fromIntegres(1, 3, 5, 7, 9),
            fromIntegres(2, 3, 5, 7),
            fromIntegres(3, 5, 7)),
        arguments(
            fromIntegres(1, 2, 3),
            fromIntegres(),
            fromIntegres()),
        arguments(
            fromIntegres(),
            fromIntegres(1, 2, 3),
            fromIntegres()),
        arguments(
            fromIntegres(),
            fromIntegres(),
            fromIntegres()));
  }

  static Stream<Arguments> exclusiveTestCaseProvider()
  {
    return Stream.of(
        arguments(
            fromIntegres(1, 3, 5, 7, 9),
            fromIntegres(2, 3, 5, 7),
            fromIntegres(1, 2, 9)),
        arguments(
            fromIntegres(2, 4, 6),
            fromIntegres(1, 3, 5),
            fromIntegres(1, 2, 3, 4, 5, 6)),
        arguments(
            fromIntegres(1, 2, 3),
            fromIntegres(1, 2, 3),
            fromIntegres()),
        arguments(
            fromIntegres(5, 6, 7),
            fromIntegres(),
            fromIntegres(5, 6, 7)),
        arguments(
            fromIntegres(),
            fromIntegres(5, 6, 7),
            fromIntegres(5, 6, 7)),
        arguments(
            fromIntegres(),
            fromIntegres(),
            fromIntegres())

    );
  }

  static PSet fromIntegres(Integer... values)
  {
    PValue[] pValues = new PValue[values.length];
    for (int i = 0; i < pValues.length; i++)
    {
      pValues[i] = new PInteger(values[i]);
    }
    return new PSet(pValues);
  }

  static PSet fromStrings(String... values)
  {
    PValue[] pValues = new PValue[values.length];
    for (int i = 0; i < pValues.length; i++)
    {
      pValues[i] = new PString(values[i]);
    }
    return new PSet(pValues);
  }
}
