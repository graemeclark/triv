package triv;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import triv.client.model.compiler.Compiler;
import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.compiler.SymbolNotFoundException;
import triv.client.model.runtime.machine.TRIVMachine;
import triv.client.model.runtime.types.CodeVectorType;
import triv.client.model.runtime.types.Machine;
import triv.client.model.strategy.lexer.TRIVLexerStrategy;
import triv.client.model.strategy.parser.TRIVParserStrategy;
import triv.client.model.strategy.pattern.TRIVPatternStrategy;

public class ExecutionTest
{

	@Test
	public void test()
	{
		Compiler c = new Compiler();
		Machine m = new TRIVMachine();		
		List<CodeVectorType> cv = new ArrayList<CodeVectorType>();
		
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
    
    m.setCodeVector(cv);
    m.execute();
    System.out.println(m);
    m.execute();
    System.out.println(m);
    m.execute();
    System.out.println(m);
    m.execute();
    System.out.println(m);
    
		//fail("Not yet implemented");
	}

}
