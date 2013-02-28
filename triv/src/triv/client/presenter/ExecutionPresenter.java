package triv.client.presenter;

import java.util.List;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

import triv.client.event.ExecuteEvent;
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
	
	PlaceManager placeManager;
	Machine machine = new TRIVMachine();
	List<CodeVectorType> codeVector;
		
	@Inject
	public ExecutionPresenter(EventBus eventBus, ExecutionView view, ExecutionProxy proxy, PlaceManager places)
	{
		super(eventBus, view, proxy);
		this.placeManager = places;
		getView().setUiHandlers(this);
		prepareFromRequest(null);
	}

	@Override
	protected void revealInParent()
	{
		RevealRootContentEvent.fire( this, this );
	}
	
	@ProxyEvent
	@Override
	public void onExecuteEvent(ExecuteEvent event) {
	  PlaceRequest request = new PlaceRequest("exe");
	  placeManager.revealPlace(request);
	  codeVector = event.getCodeVector();
	}
	
	@Override
	public List<CodeVectorType> getCodeVector()
	{
		return codeVector;
	}
	
	public void init(List<CodeVectorType> codeVector)
	{
		machine.setCodeVector(codeVector);
	}
	
	public String step()
	{
		machine.execute();
		return machine.toString();
	}
	
}