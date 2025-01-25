package util;

import java.util.function.Supplier;

public class Bool
{
  private boolean value;

  private static final Bool TRUE = new Bool(true);
  private static final Bool FALSE = new Bool(false);

  public static Bool of(boolean value)
  {
    return value ? TRUE : FALSE;
  }

  private Bool(boolean value)
  {
    this.value = value;
  }

  public <T> T ifTrue(Supplier<T> supplier)
  {
    if (value)
    {
      return supplier.get();
    }
    return null;
  }

  public <T> T ifTrueElse(Supplier<T> supplier, Supplier<T> orElse)
  {
    if (value)
    {
      return supplier.get();
    }
    return orElse.get();
  }

  public <T> T ifFalse(Supplier<T> supplier)
  {
    if (!value)
    {
      return supplier.get();
    }

    return null;
  }

  public <T> T ifFalse(Supplier<T> supplier, Supplier<T> orElse)
  {
    if (!value)
    {
      return supplier.get();
    }

    return orElse.get();
  }

  public void ifTrue(Runnable then)
  {
    if (value)
    {
      then.run();
    }
  }

  public void ifFalse(Runnable then)
  {
    if (!value)
    {
      then.run();
    }

  }
}
