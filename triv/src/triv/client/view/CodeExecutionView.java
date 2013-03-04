package triv.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import com.google.inject.Inject;

import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import triv.client.model.runtime.types.Machine;
import triv.client.presenter.ExecutionPresenter;
import triv.client.uihandler.ExecutionUiHandlers;

public class CodeExecutionView
  extends ViewWithUiHandlers<ExecutionUiHandlers>
  implements ExecutionPresenter.ExecutionView
{	
	interface Binder extends UiBinder<Widget, CodeExecutionView> { }
  private static final Binder binder = GWT.create(Binder.class);
  public interface EditorDriver extends SimpleBeanEditorDriver<Machine, CodeExecutionView> { }
	
  @UiField
	Label code;
  
	@UiField
	Label codePointer;
  
	@UiField
	Button btnStep;
	
	@UiField
	Label stack;
	
	@UiField
	Label stackPointer;
	
	@UiField
	Label heap;
	
	@UiField
	Label heapPointer;
	
	@UiField
	Label result;
	
	@Inject
	public CodeExecutionView()
	{
		super();
	}
	
	@Override
	public SimpleBeanEditorDriver<Machine, ?> createEditorDriver()
	{
	  EditorDriver driver = GWT.create(EditorDriver.class);
	  driver.initialize(this);
	  return driver;
	}
	
	@Override
	public Widget asWidget()
	{
		return binder.createAndBindUi(this);
	}
	
	@UiHandler("btnStep")
  void onCodeLoad(AttachEvent event) {
		if (getUiHandlers() != null) {
			getUiHandlers().init();
    }
  }
	
	@UiHandler("btnStep")
  void onExecuteButtonClick(ClickEvent event) {
		if (getUiHandlers() != null) {
			getUiHandlers().step();
    }
  }
}