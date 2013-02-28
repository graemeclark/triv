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
	
  public void execute()
  {
  	if (codePointer < codeVector.size()) {
	    codeVector.get(codePointer).getIns().executeInstruction();
	    codePointer++;
  	}
  	System.out.println(this);
  }
  
  public void setCodeVector(List<CodeVectorType> cv)
  {   
    codeVector = cv;
    for (CodeVectorType c : codeVector) {
    	if(c.isInstruction()) {
    		c.getIns().setMachine(this);
    	}
    }    
  }
  
  public void push(HeapType s)
  {	
  	heap.add(s);
  	heapPointer = heap.indexOf(s);
	  stack.push(heapPointer);
	  stackPointer = stack.indexOf(heapPointer);
  }
  
  public HeapType pop()
  {   
  	heapPointer = stack.pop();
	  return heap.get(heapPointer);	  
  }
  
  public CodeVectorType getParameter()
  {    
	  codePointer++;  
	  return codeVector.get(codePointer);	  
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
