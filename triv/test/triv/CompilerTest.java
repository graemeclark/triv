package triv;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import triv.client.model.compiler.Compiler;
import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.compiler.SymbolNotFoundException;
import triv.client.model.runtime.instruction.LoadInt;
import triv.client.model.runtime.types.CodeVectorType;
import triv.client.model.strategy.lexer.TRIVLexerStrategy;
import triv.client.model.strategy.parser.TRIVParserStrategy;
import triv.client.model.strategy.pattern.TRIVPatternStrategy;

import org.junit.Test;

public class CompilerTest
{

	@Test
	public void test()
	{
	  List<CodeVectorType> cv = new ArrayList<CodeVectorType>();
	  Compiler c = new Compiler();
	  c.setParserStrategy(new TRIVParserStrategy());
	  c.setLexerStrategy(new TRIVLexerStrategy());
	  c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("3 + 2 in let y = 45");
    }
    catch (SymbolNotFoundException e) {
      e.printStackTrace();
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
		List<CodeVectorType> expected = new ArrayList<CodeVectorType>();
		
		expected.add(new CodeVectorType (new LoadInt()));
		expected.add(new CodeVectorType (1));
		expected.add(new CodeVectorType (new LoadInt()));
		expected.add(new CodeVectorType (2));
		
		System.out.println(cv);
		System.out.println(expected);
		
		assertEquals(cv, expected);
		
	}

}
