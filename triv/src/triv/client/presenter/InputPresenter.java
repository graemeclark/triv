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

import triv.client.event.ExecuteEvent;
import triv.client.model.compiler.Compiler;
import triv.client.model.compiler.IdentifierNotDeclaredException;
import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.compiler.SymbolNotFoundException;
import triv.client.model.runtime.types.CodeVectorType;
import triv.client.uihandler.InputUiHandlers;

/**
 * The presenter for the input view.
 * 
 * Responsible for communicating with the compiler after various requests from the view,
 * like the Step or Reset button presses.
 * 
 * Its Proxy listens for events on its behalf before initialisation.
 * 
 * The view and proxy are injected here by the InputModule class.
 * 
 * Adapted from code in the GWTP guide at:
 * 
 * http://code.google.com/p/gwt-platform/wiki/GettingStarted
 * 
 * @author Graeme Clark
 *
 */
public class InputPresenter extends
Presenter<InputPresenter.InputView, InputPresenter.InputProxy>
implements InputUiHandlers
{

  public interface InputView extends View, HasUiHandlers<InputUiHandlers> {}

  @ProxyCodeSplit
  @NameToken("in")
  public interface InputProxy extends ProxyPlace<InputPresenter> {}

  Compiler compiler = new Compiler();
  List<CodeVectorType> codeVector;

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
  public List<CodeVectorType> compile(String source)
      throws SymbolNotFoundException, IllegalCharacterException,
      IdentifierNotDeclaredException, NoSourceCodeException
      {
    if (source.equals("")) {
      throw new NoSourceCodeException("No source code input.");
    }
    codeVector = compiler.compile(source);
    return codeVector;
      }

  @Override
  public void execute()
  {
    ExecuteEvent.fire(this, codeVector);
  }

}
