package triv.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import triv.client.IOService;
import triv.client.IOServiceAsync;
import triv.client.presenter.InputPresenter;
import triv.client.presenter.InputUiHandlers;

public class CodeInputView extends ViewWithUiHandlers<InputUiHandlers> implements InputPresenter.InputView
{
	private static final String PARSER = "parser";
	private static final String LEXER = "lexer";
	private static final String PATTERN = "pattern";
	
	List<String> parsers = new ArrayList<String>();
	List<String> lexers = new ArrayList<String>();
	List<String> patterns = new ArrayList<String>();
	
	IOServiceAsync ioService = (IOServiceAsync) GWT.create(IOService.class);
	
	interface Binder extends UiBinder<Widget, CodeInputView> { }
  private static final Binder binder = GWT.create(Binder.class);
    
  @UiField
	ListBox parser;
  
  @UiField
	ListBox lexer;
  
  @UiField
	ListBox pattern;
  
  @UiField
	TextArea code;
  
  @UiField
  Button btnCompile;
	
	@Inject
	public CodeInputView()
	{
		super();
		getComponents(PARSER);
		getComponents(LEXER);
		getComponents(PATTERN);
	}
	
	@UiHandler("btnCompile")
  void onCompileButtonClick(ClickEvent event) {
		if (getUiHandlers() != null) {
			Window.alert(getUiHandlers().compile(code.getText()).get(0));
    }
  }
	
	@UiHandler("parser")
  void onParserChange(ClickEvent event) {
		if (getUiHandlers() != null) {
			getUiHandlers().setParser(parser.getItemText(0));
    }
  }
	
	private void getComponents(String component)
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
	}

	@Override
	public Widget asWidget()
	{
		return binder.createAndBindUi( this ) ;
	}
	
}
