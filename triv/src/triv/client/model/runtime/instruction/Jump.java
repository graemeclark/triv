package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.*;

/**
 * Changes the code pointer to its parameter's value.
 * The parameter is retrieved using the CodeVectorType's
 * getter for int.
 * @author Graeme Clark
 *
 */
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
