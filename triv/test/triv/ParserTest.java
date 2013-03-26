package triv;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import triv.client.model.compiler.Compiler;
import triv.client.model.compiler.IdentifierNotDeclaredException;
import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.compiler.SymbolNotFoundException;
import triv.client.model.runtime.instruction.*;
import triv.client.model.runtime.types.CodeVectorType;
import triv.client.model.strategy.lexer.TRIVLexerStrategy;
import triv.client.model.strategy.parser.TRIVParserStrategy;
import triv.client.model.strategy.pattern.TRIVPatternStrategy;

import org.junit.Test;

public class ParserTest
{

  public void checker(List<CodeVectorType> cv, List<CodeVectorType> expected)
  {
    assertEquals(cv.size(), expected.size());
    
    for (int i = 0; i < expected.size(); i++) {
      assertEquals(cv.get(i).toString(), expected.get(i).toString());
    }
  }
  
  @Test
  public void testDec()
  {
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();
    List<CodeVectorType> expected = new ArrayList<CodeVectorType>();
    
    Compiler c = new Compiler();
    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("12");
    }
    catch (SymbolNotFoundException e) {
      System.out.println(e.getMessage());
    }
    catch (IllegalCharacterException e) {
      System.out.println(e.getMessage());
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    expected.add(new CodeVectorType (new LoadInt()));
    expected.add(new CodeVectorType (12));
    expected.add(new CodeVectorType (new Return()));

    checker(cv, expected);
  }
  
  @Test
  public void testTrue()
  {
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();
    List<CodeVectorType> expected = new ArrayList<CodeVectorType>();
    
    Compiler c = new Compiler();
    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("true");
    }
    catch (SymbolNotFoundException e) {
      System.out.println(e.getMessage());
    }
    catch (IllegalCharacterException e) {
      System.out.println(e.getMessage());
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    expected.add(new CodeVectorType (new LoadBool()));
    expected.add(new CodeVectorType (true));
    expected.add(new CodeVectorType (new Return()));

    checker(cv, expected);
  }
  
  @Test
  public void testFalse()
  {
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();
    List<CodeVectorType> expected = new ArrayList<CodeVectorType>();
    
    Compiler c = new Compiler();
    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("false");
    }
    catch (SymbolNotFoundException e) {
      System.out.println(e.getMessage());
    }
    catch (IllegalCharacterException e) {
      System.out.println(e.getMessage());
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    expected.add(new CodeVectorType (new LoadBool()));
    expected.add(new CodeVectorType (false));
    expected.add(new CodeVectorType (new Return()));

    checker(cv, expected);
  }
  
  @Test
  public void testAdd()
  {
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();
    List<CodeVectorType> expected = new ArrayList<CodeVectorType>();
    
    Compiler c = new Compiler();
    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("1 + 2");
    }
    catch (SymbolNotFoundException e) {
      System.out.println(e.getMessage());
    }
    catch (IllegalCharacterException e) {
      System.out.println(e.getMessage());
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    expected.add(new CodeVectorType (new LoadInt()));
    expected.add(new CodeVectorType (1));
    expected.add(new CodeVectorType (new LoadInt()));
    expected.add(new CodeVectorType (2));
    expected.add(new CodeVectorType (new AddOp()));
    expected.add(new CodeVectorType (new Return()));

    checker(cv, expected);
  }
  
  @Test
  public void testEquals()
  {
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();
    List<CodeVectorType> expected = new ArrayList<CodeVectorType>();
    
    Compiler c = new Compiler();
    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("1 ==2");
    }
    catch (SymbolNotFoundException e) {
      System.out.println(e.getMessage());
    }
    catch (IllegalCharacterException e) {
      System.out.println(e.getMessage());
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    expected.add(new CodeVectorType (new LoadInt()));
    expected.add(new CodeVectorType (1));
    expected.add(new CodeVectorType (new LoadInt()));
    expected.add(new CodeVectorType (2));
    expected.add(new CodeVectorType (new EqualOp()));
    expected.add(new CodeVectorType (new Return()));

    checker(cv, expected);
  }
  
  @Test
  public void testLet()
  {
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();
    List<CodeVectorType> expected = new ArrayList<CodeVectorType>();
    
    Compiler c = new Compiler();
    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("let x = 1 in x");
    }
    catch (SymbolNotFoundException e) {
      System.out.println(e.getMessage());
    }
    catch (IllegalCharacterException e) {
      System.out.println(e.getMessage());
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    expected.add(new CodeVectorType (new LoadInt()));
    expected.add(new CodeVectorType (1));
    expected.add(new CodeVectorType (new StackLoad()));
    expected.add(new CodeVectorType (0));
    expected.add(new CodeVectorType (new Retract()));
    expected.add(new CodeVectorType (new Return()));

    checker(cv, expected);
  }
  
  @Test
  public void testIf()
  {
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();
    List<CodeVectorType> expected = new ArrayList<CodeVectorType>();
    
    Compiler c = new Compiler();
    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("if (true) then 0 else 1");
    }
    catch (SymbolNotFoundException e) {
      System.out.println(e.getMessage());
    }
    catch (IllegalCharacterException e) {
      System.out.println(e.getMessage());
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    expected.add(new CodeVectorType (new LoadBool()));
    expected.add(new CodeVectorType (true));
    expected.add(new CodeVectorType (new JumpIfFalse()));
    expected.add(new CodeVectorType (8));
    expected.add(new CodeVectorType (new LoadInt()));
    expected.add(new CodeVectorType (0));
    expected.add(new CodeVectorType (new Jump()));
    expected.add(new CodeVectorType (10));
    expected.add(new CodeVectorType (new LoadInt()));
    expected.add(new CodeVectorType (1));
    expected.add(new CodeVectorType (new Return()));

    checker(cv, expected);
  }
  
}
