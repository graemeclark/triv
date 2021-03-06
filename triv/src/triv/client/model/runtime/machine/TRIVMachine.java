package triv.client.model.runtime.machine;

import java.util.*;

import triv.client.model.runtime.types.CodeVectorType;
import triv.client.model.runtime.types.*;

public class TRIVMachine implements Machine
{	
  protected int codePointer, stackPointer, heapPointer;

  protected Processor               cpu;
  protected Stack <Integer>         stack;
  protected List  <CodeVectorType>  codeVector;
  protected List  <HeapType>		heap;
  protected HeapType                result;

  public TRIVMachine()
  {
    codePointer  = 0;
    stackPointer = 0;
    heapPointer  = 0;

    stack       = new Stack <Integer>();
    codeVector  = new ArrayList <CodeVectorType>();
    heap        = new ArrayList <HeapType>();
    result      = new HeapType(0);
    
    cpu = new TRIVProcessor();
  }

  public String toString()
  {
    return "\n" +
        "Code Vector: " + codeVector   + "\n" +
        "Stack:       " + stack        + "\n" +
        "Heap:        " + heap         + "\n" +
        "SP:          " + stackPointer + "\n" +
        "CP:          " + codePointer  + "\n" +
        "HP:          " + heapPointer  + "\n" +
        "Result:      " + result       + "\n" ;
  }

  @Override
  public void execute()
  {
    if (codePointer < codeVector.size()) {
      if (codeVector.get(codePointer).isInstruction()) {
        cpu.execute(codeVector.get(codePointer).getIns());
        codePointer++;
      }
    }
  }

  @Override
  public void addToCodePointer(int change)
  {
    codePointer = codePointer + change;
  }

  @Override
  public void setCodePointer(int cp)
  {
    codePointer = cp;
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
  public void setResult(HeapType h)
  {
    result = h;
  }
  
  @Override
  public void reset()
  {
    codePointer  = 0;
    stackPointer = 0;
    heapPointer  = 0;

    stack       = new Stack <Integer>();
    heap        = new ArrayList <HeapType>();
    result      = new HeapType(0);
  }

  @Override
  public List<CodeVectorType> getCodeVector()
  {
    return codeVector;
  }

  @Override
  public Integer getCurrentCodePointer()
  {
    return codePointer;
  }
  
  @Override
  public String getResult()
  {
    return result.toString();
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
