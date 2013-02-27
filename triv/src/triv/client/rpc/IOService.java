package triv.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */

@RemoteServiceRelativePath("io")
public interface IOService extends RemoteService
{
	List<String> populateParsers();
	List<String> populateLexers();
	List<String> populatePatterns();
}
