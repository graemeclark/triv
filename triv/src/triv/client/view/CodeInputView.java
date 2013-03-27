package triv.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import triv.client.model.compiler.IdentifierNotDeclaredException;
import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.compiler.SymbolNotFoundException;
import triv.client.presenter.InputPresenter;
import triv.client.presenter.NoSourceCodeException;
import triv.client.uihandler.InputUiHandlers;


/**
 * The view class for the InputPresenter.
 * Implements the view interface defined in InputPresenter
 * so it can be injected into it.
 * 
 * Links to the CodeInputView.ui.xml file which lays out
 * the UI widgets.
 * 
 * Adapted from the code in the GWTP guide at:
 * 
 * http://code.google.com/p/gwt-platform/wiki/GettingStarted
 * 
 * @author Graeme Clark
 *
 */
public class CodeInputView extends ViewWithUiHandlers<InputUiHandlers> implements InputPresenter.InputView
{
  interface Binder extends UiBinder<Widget, CodeInputView> { }
  private static final Binder binder = GWT.create(Binder.class);

  @UiField
  TextArea code;

  @UiField
  Button btnCompile;

  @UiField
  Button btnExecute;

  @UiField
  Label error;

  @Inject
  public CodeInputView()
  {
    super();
  }

  @Override
  public Widget asWidget()
  {
    return binder.createAndBindUi( this ) ;
  }

  /**
   * Disables the execute button on load.
   * @param event
   */
  @UiHandler("btnExecute")
  void onExecuteButtonLoad(AttachEvent event)
  {
    btnExecute.setEnabled(false);
  }

  /**
   * Triggers compilation by calling the compile method
   * in the InputPresenter.
   * Either displays the resulting code vector or
   * displays an exceptions error message.
   * 
   * @param event
   */
  @UiHandler("btnCompile")
  void onCompileButtonClick(ClickEvent event)
  {
    if (getUiHandlers() != null) {
      try {
        error.setText(getUiHandlers().compile(code.getText()).toString());
        btnExecute.setEnabled(true);
      }
      catch (SymbolNotFoundException e) {
        btnExecute.setEnabled(false);
        error.setText(e.getMessage());
      }
      catch (IllegalCharacterException e) {
        btnExecute.setEnabled(false);
        error.setText(e.getMessage());
      }
      catch (IdentifierNotDeclaredException e) {
        btnExecute.setEnabled(false);
        error.setText(e.getMessage());
      }
      catch (NoSourceCodeException e) {
        btnExecute.setEnabled(false);
        error.setText(e.getMessage());
      }
    }
  }

  /**
   * Calls the InputPresenter's execute method
   * on clicking the execute button.
   * 
   * @param event
   */
  @UiHandler("btnExecute")
  void onExecuteButtonClick(ClickEvent event)
  {
    if (getUiHandlers() != null) {
      getUiHandlers().execute();
    }
  }

}
