package triv.client.model.runtime.instruction;

import triv.client.model.runtime.types.*;
/**
 * Pops twice from the stack and pushes the first value
 * back on. Used to remove declared constants from the stack.
 * @author Graeme Clark
 *
 */
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
