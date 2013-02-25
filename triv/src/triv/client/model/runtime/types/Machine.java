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
}
