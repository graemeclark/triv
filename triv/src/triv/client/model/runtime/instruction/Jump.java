package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.Instruction;
import triv.client.model.runtime.types.Machine;

public class Jump implements Instruction
{
	Machine machine;

	@Override
	public void executeInstruction()
	{
		machine.jump(machine.getParameter().getInt());		
	}

	@Override
	public void setMachine(Machine m)
	{
		machine = m;		
	}

}
