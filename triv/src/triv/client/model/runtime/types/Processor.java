package triv.client.model.runtime.types;

/**
 * Executes an instruction given to it, usually by a machine instance.
 * @author Graeme Clark
 *
 */
public interface Processor
{
  
  /**
   * Execute a given instruction.
   * @param i the instruction to execute.
   */
  public void execute(Instruction i);
}
