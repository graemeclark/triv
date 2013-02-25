package triv.client.model.runtime.types;

public interface Instruction
{  
  public void executeInstruction();
  public void setMachine(Machine m);
}