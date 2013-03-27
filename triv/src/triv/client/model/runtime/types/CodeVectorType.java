package triv.client.model.runtime.types;

/**
 * Composite class to store either an instruction, boolean
 * or integer to represent instructions and parameters.
 * @author Graeme Clark
 *
 */
public class CodeVectorType
{
  Instruction ins;
  Integer i;
  Boolean b;
	
  /**
   * Instantiate the class with an instruction.
   * @param i the instruction to set.
   */
  public CodeVectorType(Instruction i)
  {  
	  ins = i;		
  }
	
  /**
   * Instantiate the class with an integer.
   * @param n the integer to set.
   */
  public CodeVectorType(int n)
  {	  
	  i = n;		
  }
	
  /**
   * Instantiate the class with a boolean.
   * @param bool the boolean to set.
   */
  public CodeVectorType(boolean bool)
  {	  
	  b = bool;		
  }
	
  public String toString()
  {	  
    if (ins != null)
      return ins.getClass().getName().substring(
      		ins.getClass().getName().lastIndexOf(".") + 1);
  
    else if (i != null)
      return i.toString();
  
    else
      return b.toString();  
  }
  
  /**
   * Check if the instruction has been populated.
   * @return the class has been instantiated with an instruction.
   */
  public boolean isInstruction()
  {    
    return ins != null;   
  }
  
  /**
   * Check if the integer has been populated.
   * @return the class has been instantiated with an integer.
   */
  public boolean isInt()
  {    
    return i != null;   
  }
  
  /**
   * Check if the boolean has been populated.
   * @return the class has been instantiated with a boolean.
   */
  public boolean isBool()
  {    
    return b != null;   
  }
	
  /**
   * Return the instruction held by this class.
   * @return the instruction
   */
  public Instruction getIns()
  { 
	  return ins;		
  }
	
  /**
   * Return the integer held by this class.
   * @return the integer
   */
  public int getInt()
  {  
	  return i;		
  }
	
  /**
   * Return the instruction held by this class.
   * @return the boolean
   */
  public boolean getBool()
  {	  
	  return b;		
  }

}
