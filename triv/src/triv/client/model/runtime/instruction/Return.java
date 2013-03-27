package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.*;

/**
 * Sets the machine's result field as the value
 * popped from the stack.
 * @author Graeme Clark
 *
 */
public class Return implements Instruction
{
	Machine machine;

	@Override
	public void executeInstruction()
	{
		machine.setResult(machine.pop());		
	}

	@Override
	public void setMachine(Machine m)
	{
		machine = m;
	}

}
