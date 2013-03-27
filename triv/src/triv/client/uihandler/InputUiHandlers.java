package triv.client.uihandler;

import java.util.List;

import triv.client.model.compiler.IdentifierNotDeclaredException;
import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.compiler.SymbolNotFoundException;
import triv.client.model.runtime.types.CodeVectorType;
import triv.client.presenter.NoSourceCodeException;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * Defines the methods used by an input presenter to manipulate
 * the compiler upon being called by its view class.
 * 
 * Adapted from the GWTP guide at:
 * 
 * http://code.google.com/p/gwt-platform/wiki/GettingStarted#Delegate_some_actions_from_the_view_to_the_presenter
 * 
 * @author Graeme Clark
 *
 */
public interface InputUiHandlers extends UiHandlers
{
  /**
   * Triggers the compilation of the source code from
   * the view class.
   * 
   * @param source the user's source code.
   * @return the code vector from the compiler.
   * @throws SymbolNotFoundException
   * @throws IllegalCharacterException
   * @throws IdentifierNotDeclaredException
   * @throws NoSourceCodeException
   */
  List<CodeVectorType> compile(String source)
      throws SymbolNotFoundException, IllegalCharacterException, IdentifierNotDeclaredException, NoSourceCodeException;
  
  /**
   * Fire an ExecuteEvent when the ExecutionPresenter needs
   * to be displayed.
   */
  void execute();
}
