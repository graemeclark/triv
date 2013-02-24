package triv.client.model.compiler;

import java.util.List;

import com.google.gwt.user.client.Window;

import triv.client.model.strategy.interfaces.*;
import triv.client.model.strategy.lexer.TRIVLexerStrategy;
import triv.client.model.strategy.parser.TRIVParserStrategy;
import triv.client.model.strategy.pattern.TRIVPatternStrategy;

public class Compiler
{
	
	public ParserStrategy parser;
	private LexerStrategy lex;
	
	public Compiler()
	{	
		//setParserStrategy(new TRIVParserStrategy());
		setLexerStrategy(new TRIVLexerStrategy());
		setPatternStrategy(new TRIVPatternStrategy());		
	}
	
	public void setParserStrategy(ParserStrategy p)
	{
		
		parser = p;
		Window.alert(parser.toString());
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
