package triv.client.presenter;

import triv.client.TRIVPlaceManager;
import triv.client.view.CodeInputView;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class InputModule extends AbstractPresenterModule
{

	@Override
	protected void configure()
	{
		install(new DefaultModule(TRIVPlaceManager.class));
		
    // Presenters
    bindPresenter(InputPresenter.class, 
    		InputPresenter.InputView.class, 
    		CodeInputView.class, 
    		InputPresenter.InputProxy.class);		
	}

}
