package triv.client.injector;

//import com.google.gwt.core.client.AsyncProvider;
import triv.client.module.InputModule;
import triv.client.presenter.ExecutionPresenter;
import triv.client.presenter.InputPresenter;

import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

@GinModules({ InputModule.class })
public interface InputGinjector extends Ginjector
{
  PlaceManager getPlaceManager();
  EventBus getEventBus();

  AsyncProvider<InputPresenter> getMainPagePresenter();
  AsyncProvider<ExecutionPresenter> getExePagePresenter();
}
