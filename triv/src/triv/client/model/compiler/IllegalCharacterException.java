package triv.client.model.compiler;

/**
 * Exception to handle when the user enters a character
 * that is not legal in the defined language.
 * 
 * @author Graeme Clark
 *
 */
public class IllegalCharacterException extends Exception
{
	private static final long serialVersionUID = -1110958957118788829L;
	
	public IllegalCharacterException(String msg)
	{
		super(msg);
	}

}
