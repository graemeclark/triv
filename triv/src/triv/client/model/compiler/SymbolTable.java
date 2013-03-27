package triv.client.model.compiler;

import java.util.Map;
import java.util.HashMap;

import triv.client.model.compiler.Symbol;


/**
 * A class containing a HashMap to be used to store
 * an identifier along with the address of its assigned
 * value.
 * 
 * @author Graeme Clark
 *
 */
public class SymbolTable
{

  Map<String, Integer> table = new HashMap<String, Integer>();


  /**
   * Put an identifier and address onto the symbol table
   * by calling the Hashmap put method.
   * 
   * @param key the identifier to be assigned a value.
   * @param value the address of the value.
   */
  public void put(String key, Integer value)
  {
    table.put(key, value);
  }

  /**
   * Checks if an identifier already has an assigned
   * value.
   * 
   * @param symbol the identifier to be checked for value.
   * @return the value of the constant, or null.
   */
  public Integer lookup(Symbol symbol)
  {
    if (table.containsKey(symbol.getValue())) {
      return table.get(symbol.getValue());
    }
    else {
      return null;
    }
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString()
  {
    String output = "";

    for (String name: table.keySet()){

      String key = name.toString();
      String value = table.get(name).toString();  
      output = output + key + " = " + value + "\n";
    }
    return output;
  }
}
