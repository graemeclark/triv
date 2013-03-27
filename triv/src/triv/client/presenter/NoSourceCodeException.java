package triv.client.presenter;

/**
 * Exception for when a user tries to compile an empty string.
 * 
 * @author Graeme Clark
 *
 */
public class NoSourceCodeException extends Exception
{
  private static final long serialVersionUID = 6633196116761626648L;

  public NoSourceCodeException(String msg)
  {
    super(msg);
  }

}
