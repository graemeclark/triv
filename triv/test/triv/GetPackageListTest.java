package triv;

import static org.junit.Assert.*;

import java.io.IOException;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class GetPackageListTest
{

	@org.junit.Test
	public void testLexerPackage()
	{
		
		ImmutableSet<ClassInfo> ci = null;
		ClassLoader c = this.getClass().getClassLoader();
		
		try {
			ClassPath cp = ClassPath.from(c);
			ci = cp.getTopLevelClasses("triv.client.model.strategy.lexer");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (ClassInfo info : ci)
			System.out.println(info.getName());

		assertEquals(ci.size(), 1);
		
	}
	
	@org.junit.Test
	public void testParserPackage()
	{
		
		ImmutableSet<ClassInfo> ci = null;
		ClassLoader c = this.getClass().getClassLoader();
		
		try {
			ClassPath cp = ClassPath.from(c);
			ci = cp.getTopLevelClasses("triv.client.model.strategy.parser");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (ClassInfo info : ci)
			System.out.println(info.getName());
		assertEquals(ci.size(), 1);
		
	}
	
	@org.junit.Test
	public void testPatternPackage()
	{
		
		ImmutableSet<ClassInfo> ci = null;
		ClassLoader c = this.getClass().getClassLoader();
		
		try {
			ClassPath cp = ClassPath.from(c);
			ci = cp.getTopLevelClasses("triv.client.model.strategy.pattern");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (ClassInfo info : ci)
			System.out.println(info.getName());
		assertEquals(ci.size(), 1);
		
	}

}
