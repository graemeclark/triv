package triv.client.model.compiler;

public class Symbol
{	
	String type;
	
	Integer i;
	String  s;
	Boolean b;
	
	public Symbol(String string, String t)
	{		
		s = string;
		type = t;		
	}
	
	public Symbol(Integer integer)
	{		
		i = integer;
		type = "numericLiteral";		
	}
	
	public Symbol(String string)
	{	
		s = string;
		type = string;		
	}
	
	public Symbol(Boolean bool)
	{		
		b = bool;
		type = "boolLiteral";		
	}
	
	public String getType()
	{		
		return type;		
	}
	
	public String getValue()
	{	
		if (i != null)
			return i.toString();
		if (s != null)
			return s;
		if (b != null)
			return b.toString();
		else return ""; 		
	}
	
	public String toString()
	{	
		if (i != null)
			return i + "\t" + type;
		if (s != null)
			return s + "\t" + type;
		if (b != null)
			return b + "\t" + type;
		else return "";	
	}

}
