package triv.client.model.compiler;

/**
 * A composite class used to store a value and type that will
 * later be accessed by the parser.
 * 
 * @author Graeme Clark
 *
 */
public class Symbol
{	
  String type;

  Integer i;
  String  s;
  Boolean b;

  /**
   * Initialise the class with the symbol's type and
   * value manually with a string for each.
   * 
   * @param string the Symbol's new value.
   * @param t the Symbol's new type.
   */
  public Symbol(String string, String t)
  {		
    s = string;
    type = t;		
  }

  /**
   * Initialise the class with an integer value,
   * automatically setting the type as 'numericLiteral'.
   * 
   * @param integer the Symbol's new integer value.
   */
  public Symbol(Integer integer)
  {		
    i = integer;
    type = "numericLiteral";		
  }

  /**
   * Initialise the Symbol with the value and type as
   * the same string.
   * 
   * @param string the Symbol's new value and type.
   */
  public Symbol(String string)
  {	
    s = string;
    type = string;		
  }

  /**
   * Initialise the Symbol with a boolean value,
   * automatically setting the type as 'boolLiteral'.
   * @param bool the Symbol's new boolean value.
   */
  public Symbol(Boolean bool)
  {		
    b = bool;
    type = "boolLiteral";
  }

  /**
   * Return the type of this Symbol.
   * 
   * @return the Symbol's type
   */
  public String getType()
  {		
    return type;		
  }

  /**
   * Return the value of this Symbol.
   * @return the Symbol's value
   */
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

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
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
