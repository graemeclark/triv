package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.*;

/**
 * Pushes its parameter onto the stack.
 * The parameter is retrieved using the CodeVectorType's
 * getter for booleans.
 * @author Graeme Clark
 *
 */
public class LoadBool implements Instruction
{
  Machine machine;

  public void executeInstruction()
  {  
    machine.push(new HeapType(machine.getParameter().getBool()));      
  }

  @Override
  public void setMachine(Machine m)
  {
    machine = m;
  }

}
