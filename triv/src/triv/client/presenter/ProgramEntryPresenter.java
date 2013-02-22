package triv.client.presenter;

import java.io.IOException;

import triv.client.model.compiler.Compiler;
import triv.client.model.strategy.interfaces.ParserStrategy;
import triv.client.view.ProgramEntry;

public class ProgramEntryPresenter
{
	
	public Compiler compiler = new Compiler();
	//ProgramEntry entry = new ProgramEntry();
	
	/*public ImmutableSet<ClassInfo> getParsers()
	{
		
		ImmutableSet<ClassInfo> ci = null;
		ClassLoader c = this.getClass().getClassLoader();
		
		try {
			ClassPath cp = ClassPath.from(c);
			ci = cp.getTopLevelClasses("triv.client.model.compiler.strategy.parser");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ci;
		
	}
	
	public void updateParser(String className)
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
		
		if (parser != null) {
		  compiler.setParserStrategy(parser);
		}
		else {
			System.out.println("[ProgramEntryPresenter] No parser found.");
			System.exit(0);
		}
		
	}*/

}
