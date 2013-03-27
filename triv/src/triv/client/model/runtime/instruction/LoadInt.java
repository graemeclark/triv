package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.*;

/**
 * Pushes its parameter onto the stack.
 * The parameter is retrieved using the CodeVectorType's
 * getter for integers.
 * @author Graeme Clark
 *
 */
public class LoadInt implements Instruction
{
  Machine machine;

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
