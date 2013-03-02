package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.Instruction;
import triv.client.model.runtime.types.Machine;

public class Return implements Instruction
{
	Machine machine;

	@Override
	public void executeInstruction()
	{
		//machine.pop();		
	}

	@Override
	public void setMachine(Machine m)
	{
		machine = m;
	}

}
