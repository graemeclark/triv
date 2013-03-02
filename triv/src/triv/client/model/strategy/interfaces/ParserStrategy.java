package triv.client.model.strategy.interfaces;

import java.util.List;

import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.compiler.SymbolNotFoundException;
import triv.client.model.runtime.types.CodeVectorType;
import triv.client.model.strategy.interfaces.LexerStrategy;

public interface ParserStrategy
{
	
	public List<CodeVectorType> parse(LexerStrategy l, String source)
			throws SymbolNotFoundException, IllegalCharacterException;
	
	public String expression()
			throws SymbolNotFoundException, IllegalCharacterException;

}
