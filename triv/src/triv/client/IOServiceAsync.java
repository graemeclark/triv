package triv.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IOServiceAsync
{
	
	void populateComboBox(String componentName, AsyncCallback<List<String>> callback);
	
	//void instantiateParser(String className, AsyncCallback<ParserStrategy> callback);
	
}