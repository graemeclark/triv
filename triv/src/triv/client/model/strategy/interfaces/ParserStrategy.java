package triv.client.model.strategy.interfaces;

import java.util.List;

import triv.client.model.compiler.Symbol;
import triv.client.model.strategy.interfaces.LexerStrategy;

public interface ParserStrategy
{
	
	public List<String> parse(LexerStrategy l, String source);
	
	public Symbol expression();

}
