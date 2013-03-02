package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.HeapType;
import triv.client.model.runtime.types.Instruction;
import triv.client.model.runtime.types.Machine;

public class Retract implements Instruction
{
	Machine machine;

	@Override
	public void executeInstruction()
	{
		HeapType val = machine.pop();
		machine.pop();
		machine.push(val);
	}

	@Override
	public void setMachine(Machine m)
	{
		machine = m;
	}

}
