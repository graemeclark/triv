package triv.client.presenter;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import triv.client.IOService;
import triv.client.IOServiceAsync;

public class ProgramEntryPresenter
{
	
	IOServiceAsync ioService = (IOServiceAsync) GWT.create(IOService.class);
	
	public void getComponents(String component)
	{
				
		ioService.populateComboBox(component, new AsyncCallback<List<String>>() {
			@Override
			public void onSuccess(List<String> result)
			{
				handleComponents(result);
			}
	    public void onFailure(Throwable caught)
	    {
	    	
	    }
	  });
		
	}
	
	private void handleComponents(List<String> parsers)
	{
		
    //entry.parsers = parsers;
	
	}

}
