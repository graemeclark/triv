package triv.client.model.runtime.types;

public class CodeVectorType
{
  Instruction ins;
  Integer i;
  Boolean b;
	
  public CodeVectorType(Instruction i)
  {  
	  ins = i;		
  }
	
  public CodeVectorType(int n)
  {	  
	  i = n;		
  }
	
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
  
  public boolean isInstruction()
  {    
    return ins != null;   
  }
  
  public boolean isInt()
  {    
    return i != null;   
  }
  
  public boolean isBool()
  {    
    return b != null;   
  }
	
  public Instruction getIns()
  {  
	  return ins;		
  }
	
  public int getInt()
  {  
	  return i;		
  }
	
  public boolean getBool()
  {	  
	  return b;		
  }

}
