package triv.client.model.runtime.types;

/**
 * Defines the methods required by an instruction, which can
 * then be invoked by a machine.
 * 
 * @author Graeme Clark
 *
 */
public interface Instruction
{  
  /**
   * Defines what the instruction will do when called by a machine.
   */
  public void executeInstruction();
  
  /**
   * Sets an instance of a Machine to a new instance.
   * @param m the new instance of Machine.
   */
  public void setMachine(Machine m);
}