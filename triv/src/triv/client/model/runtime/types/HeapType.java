package triv.client.model.runtime.types;

public class HeapType
{
	
  Integer i;
  Boolean b;
	
  public HeapType(int n)
  {  	
    i = n;   
  }
	
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
	
  public int getInt()
  {  	
	  return i;	
  }
	
  public boolean getBool()
  { 	
	  return b;	
  }

}
