package triv.client.module;

import triv.client.place.DefaultPlace;
import triv.client.place.NameTokens;
import triv.client.place.TRIVPlaceManager;
import triv.client.presenter.ExecutionPresenter;
import triv.client.presenter.InputPresenter;
import triv.client.view.CodeExecutionView;
import triv.client.view.CodeInputView;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

/**
 * Picks the default place, in this case the presenter with
 * the name tag 'in'.
 * 
 * Binds the presenters with the views by injecting the views and a proxy
 * into each presenter.
 * 
 * Adapted from GWTP guide at:
 * http://code.google.com/p/gwt-platform/wiki/GettingStarted
 * 
 * @author Graeme Clark
 *
 */
public class InputModule extends AbstractPresenterModule
{

  @Override
  protected void configure()
  {
    install(new DefaultModule(TRIVPlaceManager.class));
    bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.inPage);

    // Presenters
    bindPresenter(InputPresenter.class, InputPresenter.InputView.class, CodeInputView.class, InputPresenter.InputProxy.class);
    bindPresenter(ExecutionPresenter.class, ExecutionPresenter.ExecutionView.class, CodeExecutionView.class, ExecutionPresenter.ExecutionProxy.class);
  }
}