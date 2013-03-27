package triv.client.uihandler;

import java.util.List;

import triv.client.event.ExecuteEvent;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * Defines the methods used by an execution presenter to manipulate
 * the machine upon being called by its view class.
 * 
 * Adapted from the GWTP guide at:
 * 
 * http://code.google.com/p/gwt-platform/wiki/GettingStarted#Delegate_some_actions_from_the_view_to_the_presenter
 * 
 * @author Graeme Clark
 *
 */
public interface ExecutionUiHandlers extends UiHandlers
{
  /**
   * Defines the action when an ExecuteEvent is fired.
   * The proxy calls the place manager to reveal
   * the execution presenter.
   * 
   * @param event the event fired.
   */
  void onExecuteEvent(ExecuteEvent event);

  /**
   * Makes the machine execute the next instruction
   * on its code vector.
   */
  void step();

  /**
   * Sets the editor to use an instance of a machine.
   * Creates a string list of each code vector element for
   * display.
   * 
   * @return the code vector as a list of strings.
   */
  List<String> init();

  /**
   * Makes the machine reset all of its fields.
   */
  void reset();
}
