package triv.client.model.strategy.interfaces;

import triv.client.model.compiler.*;

/**
 * An interface for the lexical analysis functionality
 * used by a parser.
 * @author Graeme Clark
 *
 */
public interface LexerStrategy
{

  /**
   * Set the source string, set the pattern strategy and
   * kick off analysis by calling nextSymbol here.
   * @param s the source code.
   * @throws IllegalCharacterException
   */
  public void initialise(String s) throws IllegalCharacterException;

  /**
   * A soft check on the last symbol produced.
   * Returns true if the symbol type matches s. Otherwise, false.
   * 
   * Used by a parser.
   * @param s the type to compare the next symbol to.
   * @return comparison of s and the last symbol.
   * @throws IllegalCharacterException
   */
  public Boolean have(String s) throws IllegalCharacterException;

  /**
   * A hard check on the type of the symbol last produced by the lexer.
   * Throws exception if the type of the symbol is not s.
   * Used by a parser.
   * @param s the type to compare the next symbol to.
   * @throws SymbolNotFoundException
   * @throws IllegalCharacterException
   */
  public void mustBe(String s) throws SymbolNotFoundException, IllegalCharacterException;

  /**
   * Set the class' PatternStrategy to p.
   * @param p the new pattern strategy.
   */
  public void setPatternStrategy(PatternStrategy p);

  /**
   * Get the lexer to produce the next symbol from the
   * source code. Call the setCurrentSymbol method here
   * to set the symbol after it has been made. The method
   * should use the patternStrategy's methods to check
   * for different types of symbol, then deal with them
   * accordingly.
   * @throws IllegalCharacterException
   */
  public void nextSymbol() throws IllegalCharacterException;

  /**
   * Set the currentSymbol field.
   * @param s the new symbol
   */
  public void setCurrentSymbol(Symbol s);

  /**
   * Return the current symbol.
   * @return the current symbol.
   */
  public Symbol getCurrentSymbol();

  /**
   * Deal with individual characters not covered by any
   * of the regular expressions in the PatternStrategy.
   * @param c
   * @return
   * @throws IllegalCharacterException
   */
  public String punctuator(Character c) throws IllegalCharacterException;

  /**
   * Check if the next character in the source code concatenated
   * with the character c is equal to the string s.
   * 
   * Use this to check for operators that use two characters.
   * @param c the character sliced from the source.
   * @param s the expected string.
   * @return the value to be set as the next symbol's value.
   */
  public String tryNext(Character c, String s);
  
  /**
   * Get the value of the match of the regular expression for double quotes.
   * Gets the match of the double quote matcher from the PatternStrategy.
   * @return the matching string.
   */
  public String dQuote();

  /**
   * Get the value of the match of the regular expression for identifiers.
   * Gets the match of the identifier matcher from the PatternStrategy.
   * @return the matching string.
   */
  public String identifier();
  
  /**
   * Get the value of the match of the regular expression for integers.
   * Gets the match of the integer matcher from the PatternStrategy.
   * @return the matching string.
   */
  public Integer integer();
}
