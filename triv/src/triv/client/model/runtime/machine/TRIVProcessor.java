package triv.client.model.runtime.machine;

import triv.client.model.runtime.types.*;

public class TRIVProcessor implements Processor
{
  @Override
  public void execute(Instruction i)
  {
    i.executeInstruction();
  }

}