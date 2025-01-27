package util;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class Cond<T, S>
{

  private Predicate<T> condition;
  private Supplier<S> action;

  private Cond<T, S> next = null;

  private Cond(Predicate<T> condition, Supplier<S> action)
  {
    this.condition = condition;
    this.action = action;
  }

  public static <T, S> Cond<T, S> when(T pattern, Supplier<S> supplier)
  {
    return when((t) -> t.equals(pattern), supplier);
  }

  public Cond<T, S> or(T pattern, Supplier<S> supplier)
  {
    return or((t) -> t.equals(pattern), supplier);
  }

  public static <T, S> Cond<T, S> when(Predicate<T> predicate, Supplier<S> action)
  {
    return new Cond<>(predicate, action);
  }

  public static <S> Cond<String, S> whenText(Predicate<String> predicate, Supplier<S> action)
  {
    return new Cond<>(predicate, action);
  }

  public Cond<T, S> or(Predicate<T> predicate, Supplier<S> action)
  {
    Cond<T, S> last = this;
    while (last.next != null)
    {
      last = last.next;
    }
    last.next = new Cond<>(predicate, action);

    return this;
  }

  public S get(T value, S orElse)
  {
    if (this.condition.test(value))
    {
      return this.action.get();
    }

    if (this.next != null)
    {
      return this.next.get(value, orElse);
    }

    return orElse;
  }
}
