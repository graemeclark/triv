package triv.client.model.compiler;

/**
 * Exception to handle when the user enters an identifier
 * that has not been declared as a constant.
 * 
 * @author Graeme Clark
 *
 */
public class IdentifierNotDeclaredException extends Exception
{
	private static final long serialVersionUID = -2712731825312453745L;

	public IdentifierNotDeclaredException(String msg)
	{
		super(msg);
	}
}
