package triv.client.model.runtime.types;

import java.util.List;

public interface Machine
{
	public String toString();
	public void execute();
	public void setCodeVector(List<CodeVectorType> cv);
	public void push(HeapType s);
	public HeapType pop();
	public CodeVectorType getParameter();
	public void jump(int index);
	public Integer getCurrentCodePointer();
	void setCodePointer(int change);
	public List<CodeVectorType> getCodeVector();
	void addToCodePointer(int cp);
	void setResult(HeapType h);
	
	public String getStack();
	public String getHeap();
	public String getStackPointer();
	public String getHeapPointer();
	public String getCodePointer();
	public String getCode();
	public String getResult();
	
}
