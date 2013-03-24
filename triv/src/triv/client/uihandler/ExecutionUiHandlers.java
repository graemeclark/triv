package triv.client.uihandler;

import java.util.List;

import triv.client.event.ExecuteEvent;

import com.gwtplatform.mvp.client.UiHandlers;

public interface ExecutionUiHandlers extends UiHandlers
{
  void onExecuteEvent(ExecuteEvent event);

  void step();

  List<String> init();

  void reset();
}
