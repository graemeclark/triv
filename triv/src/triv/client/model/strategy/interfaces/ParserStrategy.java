package triv.client.model.strategy.interfaces;

import java.util.List;

import triv.client.model.compiler.*;

import triv.client.model.strategy.interfaces.LexerStrategy;
import triv.client.model.runtime.types.CodeVectorType;

/**
 * @author Graeme Clark
 *
 */
public interface ParserStrategy
{

  /**
   * Trigger the parsing process using the lexical analyser and
   * source string given.
   * @param l the lexical analyser.
   * @param source
   * @return the code vector produced by parsing.
   * @throws SymbolNotFoundException
   * @throws IllegalCharacterException
   * @throws IdentifierNotDeclaredException
   */
  public List<CodeVectorType> parse(LexerStrategy l, String source)
      throws SymbolNotFoundException, IllegalCharacterException, IdentifierNotDeclaredException;

  /**
   * Check for each of the possible symbols that can constitute an expression
   * in the language, and then decide what to do with each in all cases.
   * @return the type of the last expression found.
   * @throws SymbolNotFoundException
   * @throws IllegalCharacterException
   * @throws IdentifierNotDeclaredException
   */
  public String expression()
      throws SymbolNotFoundException, IllegalCharacterException, IdentifierNotDeclaredException;

}
