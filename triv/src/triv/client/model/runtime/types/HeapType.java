package triv.client.model.runtime.types;

/**
 * Composite type use to store either an integer
 * or boolean for storage on the machine's heap.
 * @author Graeme Clark
 *
 */
public class HeapType
{
	
  Integer i;
  Boolean b;
	
  /**
   * Instantiate the class with an integer.
   * @param n the integer
   */
  public HeapType(int n)
  {  	
    i = n;   
  }
	
  /**
   * Intantiate the class with a boolean.
   * @param bool the boolean.
   */
  public HeapType(boolean bool)
  {  	
    b = bool;    
  }
	
  public String toString()
  {  	
    if (i != null) {
      return i + "";
    }    
    else { 
	    return b + "";
    }
  }
  
  public Object getVal()
  { 	
  	if (i != null) {
  		return i;
  	}  	
    else { 
	    return b;
    }
  }
	
  /**
   * Return the integer stored in this class.
   * @return the integer i
   */
  public int getInt()
  {  	
	  return i;	
  }
	
  /**
   * Return the boolean stored in this class.
   * @return the boolean b
   */
  public boolean getBool()
  { 	
	  return b;	
  }

}
