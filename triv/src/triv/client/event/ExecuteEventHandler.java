package triv.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Interface for a class that wants to handle an ExecuteEvent.
 * 
 * Adapted from code at the GWT Platform guides:
 * http://code.google.com/p/gwt-platform/wiki/GettingStarted#Attaching_events_to_proxies
 * 
 * @author Graeme Clark
 *
 */
public interface ExecuteEventHandler extends EventHandler
{
  void onExecuteEvent(ExecuteEvent event);
}
