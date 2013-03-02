package triv.client.model.compiler;

import java.util.Map;
import java.util.HashMap;

import triv.client.model.compiler.Symbol;

public class SymbolTable
{
	
	Map<String, Integer> table = new HashMap<String, Integer>();
	
	
	public void put(String key, Integer value)
	{
		
		table.put(key, value);
	
	}
	
	public Object get(String key)
	{
		
		return table.get(key);
		
	}
	
	public Integer lookup(Symbol symbol)
	{
		
		if (table.containsKey(symbol.getValue())) {
			return table.get(symbol.getValue());
		}
		else {
			return null;
		}
		
	}
	
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
