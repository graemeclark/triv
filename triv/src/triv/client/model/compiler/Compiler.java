package triv.client.model.compiler;

import java.util.List;

import triv.client.model.strategy.interfaces.*;

public class Compiler
{
	
	public ParserStrategy parser;
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
	
	public List<String> compile(String source)
	{
		
		return parser.parse(lex, source);
		
	}

}
