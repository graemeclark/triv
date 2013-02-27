package triv.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

import com.google.inject.Inject;

import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import triv.client.presenter.ExecutionPresenter;
import triv.client.uihandler.ExecutionUiHandlers;

public class CodeExecutionView extends ViewWithUiHandlers<ExecutionUiHandlers> implements ExecutionPresenter.ExecutionView
{	
	interface Binder extends UiBinder<Widget, CodeExecutionView> { }
  private static final Binder binder = GWT.create(Binder.class);
	
	@Inject
	public CodeExecutionView()
	{
		super();
	}
	
	@Override
	public Widget asWidget()
	{
		return binder.createAndBindUi( this ) ;
	}
}