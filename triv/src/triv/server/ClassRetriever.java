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
	@SuppressWarnings("unchecked")
	@Override
	public List<String> populateParsers()
	{					
		List<String> classNames = (List<String>) AccessController.doPrivileged(new PrivilegedAction() {

		  @Override
		  public Object run()
		  {
		  	List<String> classNames = new ArrayList<String>();
			  ClassLoader c = this.getClass().getClassLoader();
			  ImmutableSet<ClassInfo> classes = null;
			
			  try {
				  ClassPath cp = ClassPath.from(c);
				  classes = cp.getTopLevelClasses("triv.client.model.strategy.parser");
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> populateLexers()
	{					
		List<String> classNames = (List<String>) AccessController.doPrivileged(new PrivilegedAction() {

		  @Override
		  public Object run()
		  {
		  	List<String> classNames = new ArrayList<String>();
			  ClassLoader c = this.getClass().getClassLoader();
			  ImmutableSet<ClassInfo> classes = null;
			
			  try {
				  ClassPath cp = ClassPath.from(c);
				  classes = cp.getTopLevelClasses("triv.client.model.strategy.lexer");
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> populatePatterns()
	{					
		List<String> classNames = (List<String>) AccessController.doPrivileged(new PrivilegedAction() {

		  @Override
		  public Object run()
		  {
		  	List<String> classNames = new ArrayList<String>();
			  ClassLoader c = this.getClass().getClassLoader();
			  ImmutableSet<ClassInfo> classes = null;
			
			  try {
				  ClassPath cp = ClassPath.from(c);
				  classes = cp.getTopLevelClasses("triv.client.model.strategy.pattern");
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
}
