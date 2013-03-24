package triv.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
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

  List<String> codeVector;
  
  @UiField
  HorizontalPanel codePanel1;
  
  @UiField
  HorizontalPanel codePanel2;
  
  @UiField
  HorizontalPanel codePanel3;

  @UiField
  Label codePointer;

  @UiField
  Button btnStep;
  
  @UiField
  Button btnReset; 

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
      codeVector = getUiHandlers().init();
      this.populateCodeVectorPanel();
    }
  }

  @UiHandler("btnStep")
  void onExecuteButtonClick(ClickEvent event) {
    if (getUiHandlers() != null) {
      getUiHandlers().step();
      this.populateCodeVectorPanel();
    }
  }
  
  @UiHandler("btnReset")
  void onResetButtonClick(ClickEvent event) {
    if (getUiHandlers() != null) {
      getUiHandlers().reset();
      this.populateCodeVectorPanel();
    }
  }
  
  void populateCodeVectorPanel()
  {
  	String c = "";
    codePanel1.clear();
    codePanel2.clear();
    codePanel3.clear();
    
    for (int i = 0; i < codeVector.size(); i++) {
    	c = codeVector.get(i);

      HTML label = new HTML();
      label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      int cp = Integer.parseInt(codePointer.getText());
      
      if (cp == i) {
        label.setHTML("<span style=\"font-size: 16pt; color:red\">" + c + "</span>");
      }
      else {
        label.setHTML("<span style=\"font-size: 16pt;\">" + c + "</span>");
      }
      
      if (i > 16) {
        codePanel3.add(label);
        codePanel3.setCellWidth(label, Integer.toString(1000 / codeVector.size()));
      }
      else if (i > 8) {
        codePanel2.add(label);
        codePanel2.setCellWidth(label, Integer.toString(1000 / codeVector.size()));
      }
      else {
        codePanel1.add(label);
        codePanel1.setCellWidth(label, Integer.toString(1000 / codeVector.size()));
      }
    }
  }
}