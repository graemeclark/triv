package triv.client.model.compiler;

import java.util.List;

import triv.client.model.strategy.interfaces.*;
import triv.client.model.strategy.lexer.TRIVLexerStrategy;
import triv.client.model.strategy.parser.TRIVParserStrategy;
import triv.client.model.strategy.pattern.TRIVPatternStrategy;
import triv.client.model.runtime.types.CodeVectorType;

/**
 * @author graeme
 *
 */
public class Compiler
{

  public ParserStrategy parser;
  private LexerStrategy lex;

  /**
   * 
   */
  public Compiler()
  {	
    setParserStrategy(new TRIVParserStrategy());
    setLexerStrategy(new TRIVLexerStrategy());
    setPatternStrategy(new TRIVPatternStrategy());
  }

  /**
   * Sets the ParserStrategy for the compiler to any implementation
   * of the ParserStrategy interface.
   * 
   * @param p the new parser strategy
   */
  public void setParserStrategy(ParserStrategy p)
  {

    parser = p;

  }

  /**
   * Sets the ParserStrategy for the compiler to any implementation
   * of the LexerStrategy interface.
   * 
   * @param l the new lexer strategy
   */
  public void setLexerStrategy(LexerStrategy l)
  {

    lex = l;

  }

  /**
   * Sets the PatternStrategy for the compiler to any implementation
   * of the PatternStrategy interface.
   * 
   * @param p the new pattern strategy
   */
  public void setPatternStrategy(PatternStrategy p)
  {

    lex.setPatternStrategy(p);

  }

  /**
   * Triggers compilation by passing the LexerStrategy and the source
   * code to the parser's parser method.
   * 
   * @param source the source code to be compiled.
   * @return the code vector produced by the compilation.
   * @throws SymbolNotFoundException
   * @throws IllegalCharacterException
   * @throws IdentifierNotDeclaredException
   */
  public List<CodeVectorType> compile(String source)
      throws SymbolNotFoundException, IllegalCharacterException, IdentifierNotDeclaredException
      {

        return parser.parse(lex, source);

      }

}
