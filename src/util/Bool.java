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

  public static Bool isEmpty(String str)
  {
    if (str == null || str.isEmpty())
    {
      return TRUE;
    }
    return FALSE;
  }

  public static Bool isNull(Object obj)
  {
    return obj == null ? TRUE : FALSE;
  }

  public static Bool xor(boolean x, boolean y)
  {
    return Boolean.logicalXor(x, y) ? TRUE : FALSE;
  }

  public static Bool xor(Bool x, Bool y)
  {
    return xor(x.value, y.value);
  }

  private Bool(boolean value)
  {
    this.value = value;
  }

  public boolean value()
  {
    return this.value;
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

  public <T extends RuntimeException> void throwIfTrue(Supplier<T> erroSupplier)
  {
    if (value)
    {
      throw erroSupplier.get();
    }
  }

  public <T extends RuntimeException> void throwIfFalse(Supplier<T> erroSupplier)
  {
    if (!value)
    {
      throw erroSupplier.get();
    }
  }

  public Bool and(Bool anotherBool)
  {
    return this.value && anotherBool.value ? TRUE : FALSE;
  }

  public Bool or(Bool anotherBool)
  {
    return this.value || anotherBool.value ? TRUE : FALSE;
  }

  public Bool and(boolean anotherBool)
  {
    return this.value && anotherBool ? TRUE : FALSE;
  }

  public Bool or(boolean anotherBool)
  {
    return this.value || anotherBool ? TRUE : FALSE;
  }

  public Bool not()
  {
    return this.value ? FALSE : TRUE;
  }
}
