package triv.client.model.compiler;

public class SymbolNotFoundException extends Exception
{
	private static final long serialVersionUID = 3916772185098494831L;
	
	public SymbolNotFoundException(String msg)
	{
		super(msg);
	}
}
