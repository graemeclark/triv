package triv.client.view;

import triv.client.injector.InputGinjector;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

public class ProgramEntry implements EntryPoint
{

	public final InputGinjector ginjector = GWT.create(InputGinjector.class);

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void onModuleLoad()
	{
		
		DelayedBindRegistry.bind(ginjector);    
    ginjector.getPlaceManager().revealCurrentPlace(); 

	}
}
