package vm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Bool;
import vm.pobject.BuiltinSet;
import vm.pobject.BuiltinSet.NaturalNumberAdaptor;
import vm.pobject.BuiltinSet.RealNumberAdaptor;
import vm.pobject.PObject;
import vm.pobject.PSet;
import vm.pobject.PTuple;
import vm.pobject.PValue;
import vm.pobject.PVariable;

public class SymbolTable
{
  private SymbolTable outer;
  private Map<String, PObject> symbolTable;

  public SymbolTable()
  {
    this(null);
  }

  public SymbolTable(SymbolTable outer)
  {
    this.outer = outer;
    this.symbolTable = new HashMap<>();

    Bool.of(this.outer == null)
        .ifTrue(() -> {
          Bool.of(this.symbolTable.containsKey("N"))
              .ifFalse(() -> {
                this.symbolTable.put("N", new BuiltinSet(new NaturalNumberAdaptor()));
              });

          Bool.of(this.symbolTable.containsKey("R"))
              .ifFalse(() -> {
                this.symbolTable.put("R", new BuiltinSet(new RealNumberAdaptor()));
              });
        });
  }

  public void put(String name, PObject pObject)
  {
    this.symbolTable.put(name, pObject);

    // System.out.printf("> %s%n", pObject.toString());
  }

  public void putOuter(String name, PObject pObject)
  {
    if (this.outer != null)
    {
      this.outer.put(name, pObject);
    }
  }

  /**
   * シンボルテーブル から name を探し，応答する．自身のシンボルテーブルで見つからなかった場合，外側のスコープへ再帰的に探しに行く．
   * 
   * @param name
   * @return
   */
  public PObject get(String name)
  {
    if (this.symbolTable.containsKey(name))
    {
      return symbolTable.get(name);
    }
    if (this.outer != null)
    {
      return this.outer.get(name);
    }

    return null;
  }

  public PSet getAsSet(String name)
  {
    PObject pObject = this.get(name);
    if (pObject instanceof PSet pSet)
    {
      return pSet;
    }

    throw new ClassCastException(String.format("%s is not a set", name));
  }

  public PTuple getAsTuple(String name)
  {
    PObject pObject = this.get(name);
    if (pObject instanceof PTuple pTuple)
    {
      return pTuple;
    }

    throw new ClassCastException(String.format("%s is not a tuple", name));
  }

  public PVariable getAsVariable(String name)
  {
    PObject pObject = this.get(name);
    if (pObject instanceof PVariable pVariable)
    {
      return pVariable;
    }

    throw new ClassCastException(String.format("%s is not a variable", name));
  }

  public PValue getAsValue(String name)
  {
    PObject pObject = this.get(name);
    if (pObject instanceof PValue pValue)
    {
      return pValue;
    }

    throw new ClassCastException(String.format("%s is not a value", name));
  }

  public SymbolTable fork()
  {
    return new SymbolTable(this);
  }

  @Override
  public String toString()
  {
    StringBuffer aBuffer = new StringBuffer();
    List<String> symbols = new ArrayList<>(this.symbolTable.keySet());
    Collections.sort(symbols, (a, b) -> a.compareTo(b));

    for (String symbol : symbols)
    {
      if (symbol.startsWith("__"))
      {
        continue;
      }
      PObject pObject = this.get(symbol);
      aBuffer.append(symbol);
      aBuffer.append(": ");
      aBuffer.append(pObject.toString());
      aBuffer.append(System.lineSeparator());
    }

    return aBuffer.toString();
  }
}
