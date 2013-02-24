package triv.client.presenter;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

import triv.client.IOService;
import triv.client.IOServiceAsync;
import triv.client.model.compiler.Compiler;

public class InputPresenter extends
	Presenter<InputPresenter.InputView, InputPresenter.InputProxy>
  	implements InputUiHandlers
{
	
	public interface InputView extends View, HasUiHandlers<InputUiHandlers> {}
	
	@ProxyCodeSplit
  @NameToken("main")
  public interface InputProxy extends ProxyPlace<InputPresenter> {}
	
	IOServiceAsync ioService = (IOServiceAsync) GWT.create(IOService.class);
	Compiler compiler = new Compiler();
	
	@Inject
	public InputPresenter(EventBus eventBus, InputView view, InputProxy proxy)
	{
		super(eventBus, view, proxy);
		getView().setUiHandlers(this);
	}

	@Override
	protected void revealInParent()
	{
		RevealRootContentEvent.fire( this, this );		
	}
	
	@Override
	public List<String> compile(String source)
	{
		return compiler.compile(source);
	}

	@Override
	public void setParser(String name)
	{
		// TODO Auto-generated method stub	
	}

	@Override
	public void setLexer(String name)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPattern(String name)
	{
		// TODO Auto-generated method stub
		
	}

}
