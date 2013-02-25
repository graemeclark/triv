package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.Instruction;
import triv.client.model.runtime.types.HeapType;
import triv.client.model.runtime.types.Machine;

public class LoadBool implements Instruction
{
	Machine machine;

	public void executeInstruction()
	{  
    machine.push(new HeapType(machine.getParameter().getBool()));      
	}

	@Override
	public void setMachine(Machine m)
	{
		machine = m;
	}
	
}
