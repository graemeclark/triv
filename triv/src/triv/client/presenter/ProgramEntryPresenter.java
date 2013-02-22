package triv.client.presenter;

import java.io.IOException;

import triv.client.view.ProgramEntry;
import triv.client.model.compiler.Compiler;
import triv.client.model.compiler.strategy.interfaces.ParserStrategy;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class ProgramEntryPresenter
{
	
	Compiler compiler = new Compiler();
	ProgramEntry entry = new ProgramEntry();
	
	public ImmutableSet<ClassInfo> getParsers()
	{
		
		ImmutableSet<ClassInfo> ci = null;
		ClassLoader c = this.getClass().getClassLoader();
		
		try {
			ClassPath cp = ClassPath.from(c);
			ci = cp.getTopLevelClasses("triv.client.model.compiler.strategy.lexer");
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
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if (parser != null) {
		  compiler.setParserStrategy(parser);
		}
		else {
			System.out.println("[ProgramEntryPresenter] No parser found.");
			System.exit(0);
		}
		
	}

}
