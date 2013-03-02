package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.Instruction;
import triv.client.model.runtime.types.Machine;

public class JumpIfFalse implements Instruction
{
	Machine machine;

	@Override
	public void executeInstruction()
	{
		if (machine.pop().getBool() == false) {
			machine.jump(machine.getParameter().getInt());
		}
		else {
			machine.setCodePointer(1);
		}
	}

	@Override
	public void setMachine(Machine m)
	{
		machine = m;		
	}

}
