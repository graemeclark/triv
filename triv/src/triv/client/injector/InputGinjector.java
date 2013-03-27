package triv.client.injector;

import triv.client.module.InputModule;
import triv.client.presenter.ExecutionPresenter;
import triv.client.presenter.InputPresenter;

import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

/** Interface to define which module is used to inject presenters
 * and views.
 * 
 *  Adapted from GWTP code at:
 *  http://code.google.com/p/gwt-platform/wiki/GettingStarted
 *  
 * @author Graeme Clark
 *
 */
@GinModules({ InputModule.class })
public interface InputGinjector extends Ginjector
{
  PlaceManager getPlaceManager();
  EventBus getEventBus();

  AsyncProvider<InputPresenter> getMainPagePresenter();
  AsyncProvider<ExecutionPresenter> getExePagePresenter();
}
