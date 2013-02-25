package triv.client.model.strategy.interfaces;

import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.compiler.Symbol;
import triv.client.model.compiler.SymbolNotFoundException;

public interface LexerStrategy
{
	
	public void initialise(String s) throws IllegalCharacterException;
	
	public Boolean have(String s) throws IllegalCharacterException;
	
	public void mustBe(String s) throws SymbolNotFoundException, IllegalCharacterException;
	
	public void setPatternStrategy(PatternStrategy p);
	
	public void nextSymbol() throws IllegalCharacterException;
	
	public void setCurrentSymbol(Symbol s);
	
	public Symbol getCurrentSymbol();
	
	public String  punctuator(Character c) throws IllegalCharacterException;
	
	public String  identifier();
	
	public Integer integer();
	
	public String  dQuote();

}
