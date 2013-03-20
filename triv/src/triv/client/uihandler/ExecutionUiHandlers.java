package triv.client.uihandler;

import triv.client.event.ExecuteEvent;

import com.gwtplatform.mvp.client.UiHandlers;

public interface ExecutionUiHandlers extends UiHandlers
{
  void onExecuteEvent(ExecuteEvent event);

  void step();

  void init();

  void reset();
}
