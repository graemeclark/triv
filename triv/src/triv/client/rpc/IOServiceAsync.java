package triv.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IOServiceAsync
{
	void populateParsers(AsyncCallback<List<String>> callback);
	void populateLexers(AsyncCallback<List<String>> callback);
	void populatePatterns(AsyncCallback<List<String>> callback);
}
