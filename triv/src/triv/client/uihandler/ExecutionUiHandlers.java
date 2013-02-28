package triv.client.uihandler;

import java.util.List;

import triv.client.event.ExecuteEvent;
import triv.client.model.runtime.types.CodeVectorType;

import com.gwtplatform.mvp.client.UiHandlers;

public interface ExecutionUiHandlers extends UiHandlers
{
	void onExecuteEvent(ExecuteEvent event);

	List<CodeVectorType> getCodeVector();
}
