package triv.client.model.compiler;

public class IdentifierNotDeclaredException extends Exception
{
	private static final long serialVersionUID = -2712731825312453745L;

	public IdentifierNotDeclaredException(String msg)
	{
		super(msg);
	}
}
