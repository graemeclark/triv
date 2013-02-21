package triv.client.model.compiler;

import triv.client.model.compiler.strategy.interfaces.*;

public class Compiler
{
	
	private ParserStrategy parser;
	private LexerStrategy lex;
	
	public void setParserStrategy(ParserStrategy p)
	{
		
		parser = p;
		
	}
	
	public void setLexerStrategy(LexerStrategy l)
	{
		
		lex = l;
		
	}
	
	public void setPatternStrategy(PatternStrategy p)
	{
		
		lex.setPatternStrategy(p);
		
	}
	
	public void compile(String source)
	{
		
		parser.parse(lex, source);
		
	}

}
