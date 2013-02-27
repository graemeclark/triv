package triv.client.presenter;

import java.util.List;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

import triv.client.model.runtime.machine.TRIVMachine;
import triv.client.model.runtime.types.CodeVectorType;
import triv.client.model.runtime.types.Machine;
import triv.client.uihandler.ExecutionUiHandlers;

public class ExecutionPresenter extends
	Presenter<ExecutionPresenter.ExecutionView, ExecutionPresenter.ExecutionProxy>
  	implements ExecutionUiHandlers
{
	
	public interface ExecutionView extends View, HasUiHandlers<ExecutionUiHandlers> {}
	
	@ProxyCodeSplit
	@NameToken("exe")
  public interface ExecutionProxy extends ProxyPlace<ExecutionPresenter> {}
	
	Machine machine = new TRIVMachine();
		
	@Inject
	public ExecutionPresenter(EventBus eventBus, ExecutionView view, ExecutionProxy proxy)
	{
		super(eventBus, view, proxy);
		getView().setUiHandlers(this);
	}

	@Override
	protected void revealInParent()
	{
		RevealRootContentEvent.fire( this, this );
	}
	
	public String step(List<CodeVectorType> codeVector)
	{
		machine.setCodeVector(codeVector);
		machine.execute();
		return machine.toString();
	}
	
}