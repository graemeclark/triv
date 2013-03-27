package triv.client.model.runtime.types;

import java.util.List;

/**
 * Defines the specification of a machine.
 * 
 * @author Graeme Clark
 *
 */
public interface Machine
{

  public String toString();
  
  /**
   * Execute the next instruction on the code vector
   */
  public void execute();
  
  /**
   * Set the machine's code vector.
   * @param cv the new code vector.
   */
  public void setCodeVector(List<CodeVectorType> cv);
  
  /**
   * Put the parameter into the heap and put the address
   * of it onto the stack.
   * @param s the value to be put onto the heap.
   */
  public void push(HeapType s);
  
  /**
   * Return the heap value at the address at the top of the
   * stack.
   * @return
   */
  public HeapType pop();
  
  /**
   * Return the next element from the code vector
   */
  public CodeVectorType getParameter();
  
  /**
   * Change the code pointer to the index passed in.
   * @param index the new code pointer.
   */
  public void jump(int index);
  
  /** Return the code pointer.
   * @return
   */
  public Integer getCurrentCodePointer();
  
  /**
   * Change the code pointer by giving how much to
   * change it by.
   * @param change
   */
  void setCodePointer(int change);
  
  /**
   * Return the code vector.
   * @return code vector
   */
  public List<CodeVectorType> getCodeVector();
  
  /** Add to the code pointer.
   * @param cp the number to add to the code pointer
   */
  void addToCodePointer(int cp);
  
  /**
   * Populate the result field.
   * @param h the heap type from which the result will be taken
   */
  void setResult(HeapType h);
  
  /**
   * Reset every field to the default.
   */
  void reset();

  String getResult();

  String getStack();

  String getHeap();

  String getStackPointer();

  String getHeapPointer();

  String getCodePointer();

  String getCode();
}
