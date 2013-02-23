package triv.server;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

import triv.client.IOService;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ClassRetriever extends RemoteServiceServlet implements IOService
{
	
	private String requiredComponent;

	@SuppressWarnings("unchecked")
	@Override
	public List<String> populateComboBox(String componentName)
	{
		
		requiredComponent = componentName;
			
		List<String> classNames = (List<String>) AccessController.doPrivileged(new PrivilegedAction() {

		  @Override
		  public Object run()
		  {

		  	List<String> classNames = new ArrayList<String>();
			  ClassLoader c = this.getClass().getClassLoader();
			  ImmutableSet<ClassInfo> classes = null;
			
			  try {
				  ClassPath cp = ClassPath.from(c);
				  classes = cp.getTopLevelClasses("triv.client.model.strategy." + requiredComponent);
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
			
			  if (classes != null) {
				  for (ClassInfo info : classes) {
					  classNames.add(info.getName());					
				  }
			  }
			  return classNames;
			  
		  }
		  
		});
		return classNames;
		
	}

	/*@Override
	public ParserStrategy instantiateParser(String className)
	{
		
		ParserStrategy parser = null;
		
		try {
			parser = (ParserStrategy) Class.forName(className).newInstance();
		}
		catch (InstantiationException e) {
			System.out.println(e);
		}
		catch (IllegalAccessException e) {
			System.out.println(e);
		}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return parser;
		
	}*/

}
