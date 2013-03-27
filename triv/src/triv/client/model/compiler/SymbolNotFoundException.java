package triv.client.model.compiler;

/**
 * Exception to handle when type of symbol is expected by the parser,
 * but is not found.
 * 
 * @author Graeme Clark
 *
 */
public class SymbolNotFoundException extends Exception
{
	private static final long serialVersionUID = 3916772185098494831L;
	
	public SymbolNotFoundException(String msg)
	{
		super(msg);
	}
}
