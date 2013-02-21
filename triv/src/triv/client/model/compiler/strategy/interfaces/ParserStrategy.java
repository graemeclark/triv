package triv.client.model.compiler.strategy.interfaces;

import triv.client.model.compiler.strategy.interfaces.LexerStrategy;
import triv.client.model.compiler.Symbol;

public interface ParserStrategy
{
	
	public void parse(LexerStrategy l, String source);
	
	public Symbol expression();

}
