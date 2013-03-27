package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.*;

/**
 * Pushes a value at the stack address given by the parameter
 * on the code vector back onto the top of stack.
 * @author Graeme Clark
 *
 */
public class StackLoad implements Instruction
{
	Machine machine;
	Integer holdCodePointer, setCodePointer;

	@Override
	public void executeInstruction()
	{
		holdCodePointer = machine.getCurrentCodePointer() + 1;
		setCodePointer = machine.getParameter().getInt();
		
		machine.setCodePointer(setCodePointer);
		machine.execute();
		machine.setCodePointer(holdCodePointer);
	}

	@Override
	public void setMachine(Machine m)
	{
		machine = m;
	}

}
