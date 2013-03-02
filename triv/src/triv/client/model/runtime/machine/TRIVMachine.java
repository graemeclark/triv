package triv.client.model.runtime.machine;

import java.util.*;

import triv.client.model.runtime.types.CodeVectorType;
import triv.client.model.runtime.types.HeapType;
import triv.client.model.runtime.types.Machine;

public class TRIVMachine implements Machine
{	
  protected int codePointer, stackPointer, heapPointer;
  
  protected Stack <Integer>         stack;
  protected List  <CodeVectorType>  codeVector;
  protected List  <HeapType>				heap;
	
  public TRIVMachine()
  {
    
    codePointer  = 0;
    stackPointer = 0;
    heapPointer  = 0;
	
    stack       = new Stack <Integer>();
	  codeVector  = new ArrayList <CodeVectorType>();
	  heap        = new ArrayList <HeapType>();
		
  }
  
  public String toString()
  {
    return "\n" +
           "Code Vector: " + codeVector   + "\n" +
           "Stack:       " + stack        + "\n" +
           "Heap:        " + heap         + "\n" +
           "SP:          " + stackPointer + "\n" +
           "CP:          " + codePointer  + "\n" +
           "HP:          " + heapPointer  + "\n" ;
  }
	
  @Override
  public void execute()
  {
  	if (codePointer < codeVector.size()) {
  		if (codeVector.get(codePointer).isInstruction()) {
	      codeVector.get(codePointer).getIns().executeInstruction();
	      codePointer++;
  		}
  	}
  }
  
  @Override
  public void setCodePointer(int change)
  {
  	codePointer = codePointer + change;
  }
  
  @Override
  public void setCodeVector(List<CodeVectorType> cv)
  {   
    codeVector = cv;
    for (CodeVectorType c : codeVector) {
    	if(c.isInstruction()) {
    		c.getIns().setMachine(this);
    	}
    }    
  }
  
  @Override
  public void push(HeapType s)
  {	
  	heap.add(s);
  	heapPointer = heap.indexOf(s);
	  stack.push(heapPointer);
	  stackPointer = stack.indexOf(heapPointer);
  }
  
  @Override
  public HeapType pop()
  {   
  	heapPointer = stack.pop();
	  return heap.get(heapPointer);
  }
  
  @Override
  public CodeVectorType getParameter()
  {
	  codePointer++;
	  return codeVector.get(codePointer);
  }
  
	@Override
	public void jump(int index)
	{
		codePointer = index - 1;
	}
  
  @Override
  public String getStack()
  {
  	return stack.toString();
  }

	@Override
	public String getHeap()
	{
		return heap.toString();
	}

	@Override
	public String getStackPointer()
	{
		return Integer.toString(stackPointer);
	}

	@Override
	public String getHeapPointer()
	{
		return Integer.toString(heapPointer);
	}

	@Override
	public String getCodePointer()
	{
		return Integer.toString(codePointer);
	}

	@Override
	public String getCode()
	{
		return codeVector.toString();
	}
	
}
