package triv.client.model.runtime.instruction;

import java.util.EmptyStackException;

import triv.client.model.runtime.types.HeapType;
import triv.client.model.runtime.types.Instruction;
import triv.client.model.runtime.types.Machine;

public class AddOp implements Instruction
{
  Machine machine;

  @Override
  public void executeInstruction()
  { 	
    int e1 = 0;
    int e2 = 0;
    
    try {    	
      e1 = machine.pop().getInt();
      e2 = machine.pop().getInt();     
    }    
    catch (EmptyStackException e) {   	
      System.out.println("Can't pop from the stack... nothing there.");     
    }   
    machine.push(new HeapType(e1 + e2));    
  }

	@Override
	public void setMachine(Machine m)
	{
		machine = m;		
	}
	
}
