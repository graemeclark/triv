package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.*;

/** 
 * Changes the code pointer to its parameter's value if
 * the value popped from the stack evaluates to false.
 * The parameter is retrieved using the CodeVectorType's
 * getter for int.
 * 
 * @author Graeme Clark
 *
 */
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
			machine.addToCodePointer(1);
		}
	}

	@Override
	public void setMachine(Machine m)
	{
		machine = m;		
	}

}
