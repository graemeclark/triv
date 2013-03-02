package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.HeapType;
import triv.client.model.runtime.types.Instruction;
import triv.client.model.runtime.types.Machine;

public class LoadString implements Instruction
{
	Machine machine;

	@Override
	public void executeInstruction()
	{
		machine.push(new HeapType(machine.getParameter().getInt()));		
	}

	@Override
	public void setMachine(Machine m)
	{
		machine = m;		
	}

}
