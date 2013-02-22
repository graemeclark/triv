package triv;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import triv.client.model.compiler.Compiler;
import triv.client.model.strategy.lexer.TRIVLexerStrategy;
import triv.client.model.strategy.parser.TRIVParserStrategy;
import triv.client.model.strategy.pattern.TRIVPatternStrategy;

import org.junit.Test;

public class CompilerTest
{

	@Test
	public void test()
	{
		
		Compiler c = new Compiler();
		c.setParserStrategy(new TRIVParserStrategy());
		c.setLexerStrategy(new TRIVLexerStrategy());
		c.setPatternStrategy(new TRIVPatternStrategy());
			
		List<String> cv = c.compile("let x = 1 in let y = 2 in");
		List<String> expected = new ArrayList<String>();
		
		expected.add("loadInt");
		expected.add("1");
		expected.add("loadInt");
		expected.add("2");
		
		assertEquals(cv, expected);
		
	}

}
