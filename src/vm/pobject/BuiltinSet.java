package vm.pobject;

import java.util.Iterator;
import java.util.stream.Stream;

import util.Bool;

public class BuiltinSet extends PSet
{
  static abstract class BuiltinSetAdaptor
  {

    public abstract Iterator<PValue> generate(Number lowerBound, Number upperBound, Number step);

    @Override
    public String toString()
    {
      return "<builtin set>";
    }
  }

  public static class NaturalNumberAdaptor extends BuiltinSetAdaptor
  {

    @Override
    public Iterator<PValue> generate(Number lowerBound, Number upperBound, Number step)
    {
      final int _step = step == null ? Integer.valueOf(1) : step.intValue();

      return Stream.iterate(lowerBound.intValue(), n -> n <= upperBound.intValue(), n -> n + _step)
          .map(n -> (PValue) new PInteger(Long.valueOf(n)))
          .iterator();
    }

    @Override
    public String toString()
    {
      return "<builtin set (natural)>";
    }
  }

  public static class RealNumberAdaptor extends BuiltinSetAdaptor
  {

    @Override
    public Iterator<PValue> generate(Number lowerBound, Number upperBound, Number step)
    {
      final double _step = step == null ? Double.valueOf(0.1) : step.doubleValue();
      return Stream.iterate(lowerBound.doubleValue(), d -> d <= upperBound.doubleValue(), d -> d + _step)
          .map(d -> (PValue) new PReal(d))
          .iterator();
    }

    @Override
    public String toString()
    {
      return "<builtin set (real)>";
    }
  }

  private BuiltinSetAdaptor adaptor;

  public BuiltinSet(BuiltinSetAdaptor adaptor)
  {
    this.adaptor = adaptor;
  }

  @Override
  public Bool include(PValue value)
  {
    throw new RuntimeException("invalid operation");
  }

  @Override
  public PSet union(PSet anotherSet)
  {
    throw new RuntimeException("invalid operation");
  }

  @Override
  public PSet difference(PSet anotherSet)
  {
    throw new RuntimeException("invalid operation");
  }

  @Override
  public PSet intersect(PSet anotherSet)
  {
    throw new RuntimeException("invalid operation");
  }

  @Override
  public PSet exclusive(PSet anoterSet)
  {
    throw new RuntimeException("invalid operation");
  }

  /**
   * ドメインを限定する
   * 
   * @return
   */
  public PSet limitDomain(Number lowerBound, Number upperBound)
  {
    return PSet.fromIterator(this.adaptor.generate(lowerBound, upperBound, null));
  }

  /**
   * ドメインを限定する
   * 
   * @return
   */
  public PSet limitDomain(Number lowerBound, Number upperBound, Number step)
  {
    return PSet.fromIterator(this.adaptor.generate(lowerBound, upperBound, step));
  }

  @Override
  public String toString()
  {
    return adaptor.toString();
  }
}
