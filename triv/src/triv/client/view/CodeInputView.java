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

import triv.client.rpc.IOServiceAsync;
import triv.client.model.compiler.IdentifierNotDeclaredException;
import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.compiler.SymbolNotFoundException;
import triv.client.presenter.InputPresenter;
import triv.client.presenter.NoSourceCodeException;
import triv.client.rpc.IOService;
import triv.client.uihandler.InputUiHandlers;

public class CodeInputView extends ViewWithUiHandlers<InputUiHandlers> implements InputPresenter.InputView
{
	/*private static final String PARSER = "parser";
	private static final String LEXER = "lexer";
	private static final String PATTERN = "pattern";*/
	
	//List<String> parsers = new ArrayList<String>();
	//List<String> lexers = new ArrayList<String>();
	//List<String> patterns = new ArrayList<String>();
	
	IOServiceAsync ioService = (IOServiceAsync) GWT.create(IOService.class);
	
	interface Binder extends UiBinder<Widget, CodeInputView> { }
  private static final Binder binder = GWT.create(Binder.class);
    
  /*@UiField
	ListBox parser
  
  @UiField
	ListBox lexer;
  
  @UiField
	ListBox pattern;*/
  
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
	
	@UiHandler("btnExecute")
  void onExecuteButtonLoad(AttachEvent event)
	{
		btnExecute.setEnabled(false);
  }
	
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
	
	@UiHandler("btnExecute")
  void onExecuteButtonClick(ClickEvent event)
	{
		if (getUiHandlers() != null) {
			getUiHandlers().execute();
    }
  }
	
	/*@UiHandler("parser")
  void onParserChange(ClickEvent event) {
		if (getUiHandlers() != null) {
			getUiHandlers().setParser(parser.getItemText(0));
    }
  }*/
	
	/*private void getComponents(String component)
	{
		if (component.equals(PARSER)) {
		  ioService.populateParsers(new AsyncCallback<List<String>>() {
			  @Override
			  public void onSuccess(List<String> result) { initParsers(result); }
	      public void onFailure(Throwable caught) {}
	    });
		}
		else if (component.equals(LEXER)) {
		  ioService.populateLexers(new AsyncCallback<List<String>>() {
			  @Override
			  public void onSuccess(List<String> result) { initLexers(result); }
	      public void onFailure(Throwable caught) {}
	    });
		}
		else if (component.equals(PATTERN)) {
		  ioService.populatePatterns(new AsyncCallback<List<String>>() {
			  @Override
			  public void onSuccess(List<String> result) { initPatterns(result); }
	      public void onFailure(Throwable caught) {}
	    });
		}
	}

	private void initParsers(List<String> components)
	{
		for (String s : components)
			parser.addItem(s);
	}
	
	private void initLexers(List<String> components)
	{
		for (String s : components)
			lexer.addItem(s);
	}
	
	private void initPatterns(List<String> components)
	{
		for (String s : components)
			pattern.addItem(s);
	}*/
	
}
