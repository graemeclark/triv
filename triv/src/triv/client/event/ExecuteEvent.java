package triv.client.event;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

import triv.client.model.runtime.types.CodeVectorType;

/**
 * Event fired by the input view when the button is pressed
 * to open the execution view.
 * 
 * Based on the custom event code from the GWT Platform guides:
 * http://code.google.com/p/gwt-platform/wiki/GettingStarted#Attaching_events_to_proxies
 * 
 * @author Graeme Clark
 *
 */
public class ExecuteEvent extends GwtEvent<ExecuteEventHandler>
{
  private static final Type<ExecuteEventHandler> TYPE = new Type<ExecuteEventHandler>();
  private static List<CodeVectorType> codeVector;

  public static Type<ExecuteEventHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<ExecuteEventHandler> getAssociatedType()
  {
    return getType();
  }

  @Override
  protected void dispatch(ExecuteEventHandler handler)
  {
    handler.onExecuteEvent(this);
  }

  public List<CodeVectorType> getCodeVector()
  {
    return codeVector;
  }

  public void setCodeVector(List<CodeVectorType> c)
  {
    codeVector = c;
  }

  public static void fire(HasHandlers source, List<CodeVectorType> c)
  {
    codeVector = c;
    source.fireEvent(new ExecuteEvent());
  }

}
