package triv.client.model.runtime.instruction;

import java.util.EmptyStackException;

import triv.client.model.runtime.types.*;

/**
 * Pops two elements from the stack, compares them, and pushes
 * the result back on.
 * 
 * @author Graeme Clark
 *
 */
public class EqualOp implements Instruction
{	
	Machine machine;

  @Override
  public void executeInstruction()
  {
  	
  	Object e1 = null;
  	Object e2 = null;
  	
    try {    	
      e1 = machine.pop().getVal();
      e2 = machine.pop().getVal();      
    }
    
    catch (EmptyStackException e) {    	
      System.out.println("Can't pop from the stack... nothing there.");      
    }
    
    machine.push(new HeapType(e1 == e2));
    
  }

	@Override
	public void setMachine(Machine m)
	{
		machine = m;	
	}

}
