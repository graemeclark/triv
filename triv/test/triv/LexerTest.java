package triv;

import static org.junit.Assert.*;

import org.junit.Test;

import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.strategy.interfaces.LexerStrategy;
import triv.client.model.strategy.interfaces.PatternStrategy;
import triv.client.model.strategy.lexer.TRIVLexerStrategy;
import triv.client.model.strategy.pattern.TRIVPatternStrategy;

public class LexerTest
{

  @Test
  public void testInt()
  {
    LexerStrategy lex = new TRIVLexerStrategy();
    PatternStrategy pat = new TRIVPatternStrategy();
    lex.setPatternStrategy(pat);
    
    try {
      lex.initialise("3");
      assertEquals(lex.getCurrentSymbol().getType(), "numericLiteral");
      assertEquals(lex.getCurrentSymbol().getValue(), "3");
      lex.nextSymbol();
      assertEquals(lex.getCurrentSymbol().getType(), "end of program");
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testMult()
  {
    LexerStrategy lex = new TRIVLexerStrategy();
    PatternStrategy pat = new TRIVPatternStrategy();
    lex.setPatternStrategy(pat);
    
    try {
      lex.initialise("334");
      assertEquals(lex.getCurrentSymbol().getType(), "numericLiteral");
      assertEquals(lex.getCurrentSymbol().getValue(), "334");
      lex.nextSymbol();
      assertEquals(lex.getCurrentSymbol().getType(), "end of program");
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testBool()
  {
    LexerStrategy lex = new TRIVLexerStrategy();
    PatternStrategy pat = new TRIVPatternStrategy();
    lex.setPatternStrategy(pat);
    
    try {
      lex.initialise("true");
      assertEquals(lex.getCurrentSymbol().getType(), "boolLiteral");
      assertEquals(lex.getCurrentSymbol().getValue(), "true");
      lex.nextSymbol();
      assertEquals(lex.getCurrentSymbol().getType(), "end of program");
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testAdd()
  {
    LexerStrategy lex = new TRIVLexerStrategy();
    PatternStrategy pat = new TRIVPatternStrategy();
    lex.setPatternStrategy(pat);
    
    try {
      lex.initialise("3 + 4");
      assertEquals(lex.getCurrentSymbol().getType(), "numericLiteral");
      assertEquals(lex.getCurrentSymbol().getValue(), "3");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "+");
      assertEquals(lex.getCurrentSymbol().getValue(), "+");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "numericLiteral");
      assertEquals(lex.getCurrentSymbol().getValue(), "4");
      lex.nextSymbol();
      assertEquals(lex.getCurrentSymbol().getType(), "end of program");
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testEq()
  {
    LexerStrategy lex = new TRIVLexerStrategy();
    PatternStrategy pat = new TRIVPatternStrategy();
    lex.setPatternStrategy(pat);
    
    try {
      lex.initialise("3 == 4");
      assertEquals(lex.getCurrentSymbol().getType(), "numericLiteral");
      assertEquals(lex.getCurrentSymbol().getValue(), "3");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "==");
      assertEquals(lex.getCurrentSymbol().getValue(), "==");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "numericLiteral");
      assertEquals(lex.getCurrentSymbol().getValue(), "4");
      lex.nextSymbol();
      assertEquals(lex.getCurrentSymbol().getType(), "end of program");
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testLet()
  {
    LexerStrategy lex = new TRIVLexerStrategy();
    PatternStrategy pat = new TRIVPatternStrategy();
    lex.setPatternStrategy(pat);
    
    try {
      lex.initialise("let x = 3 in x");
      
      assertEquals(lex.getCurrentSymbol().getType(), "let");
      assertEquals(lex.getCurrentSymbol().getValue(), "let");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "identifier");
      assertEquals(lex.getCurrentSymbol().getValue(), "x");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "=");
      assertEquals(lex.getCurrentSymbol().getValue(), "=");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "numericLiteral");
      assertEquals(lex.getCurrentSymbol().getValue(), "3");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "in");
      assertEquals(lex.getCurrentSymbol().getValue(), "in");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "identifier");
      assertEquals(lex.getCurrentSymbol().getValue(), "x");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "end of program");
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testIf()
  {
    LexerStrategy lex = new TRIVLexerStrategy();
    PatternStrategy pat = new TRIVPatternStrategy();
    lex.setPatternStrategy(pat);
    
    try {
      lex.initialise("if (true) then 0 else 1");
      
      assertEquals(lex.getCurrentSymbol().getType(), "if");
      assertEquals(lex.getCurrentSymbol().getValue(), "if");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "(");
      assertEquals(lex.getCurrentSymbol().getValue(), "(");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "boolLiteral");
      assertEquals(lex.getCurrentSymbol().getValue(), "true");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), ")");
      assertEquals(lex.getCurrentSymbol().getValue(), ")");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "then");
      assertEquals(lex.getCurrentSymbol().getValue(), "then");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "numericLiteral");
      assertEquals(lex.getCurrentSymbol().getValue(), "0");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "else");
      assertEquals(lex.getCurrentSymbol().getValue(), "else");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "numericLiteral");
      assertEquals(lex.getCurrentSymbol().getValue(), "1");
      lex.nextSymbol();
      
      assertEquals(lex.getCurrentSymbol().getType(), "end of program");
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
  }

}
