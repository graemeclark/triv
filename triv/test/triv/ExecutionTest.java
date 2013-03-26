package triv;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import triv.client.model.compiler.Compiler;
import triv.client.model.compiler.IdentifierNotDeclaredException;
import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.compiler.SymbolNotFoundException;
import triv.client.model.runtime.machine.TRIVMachine;
import triv.client.model.runtime.types.CodeVectorType;
import triv.client.model.runtime.types.Machine;
import triv.client.model.strategy.lexer.TRIVLexerStrategy;
import triv.client.model.strategy.parser.TRIVParserStrategy;
import triv.client.model.strategy.pattern.TRIVPatternStrategy;

public class ExecutionTest
{

  @Test
  public void testNum()
  {
    Compiler c = new Compiler();
    Machine m = new TRIVMachine();		
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();

    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("3");
    }
    catch (SymbolNotFoundException e) {
      e.printStackTrace();
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    m.setCodeVector(cv);
    
    while (m.getCurrentCodePointer() < m.getCodeVector().size()) {
      m.execute();
    }

    assertEquals(m.getResult(), "3"); 
  }
  
  @Test
  public void testBool()
  {
    Compiler c = new Compiler();
    Machine m = new TRIVMachine();      
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();

    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("true");
    }
    catch (SymbolNotFoundException e) {
      e.printStackTrace();
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    m.setCodeVector(cv);
    
    while (m.getCurrentCodePointer() < m.getCodeVector().size()) {
      m.execute();
    }

    assertEquals(m.getResult(), "true"); 
  }
  
  @Test
  public void testAdd()
  {
    Compiler c = new Compiler();
    Machine m = new TRIVMachine();      
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();

    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("3 + 7");
    }
    catch (SymbolNotFoundException e) {
      e.printStackTrace();
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    m.setCodeVector(cv);
    
    while (m.getCurrentCodePointer() < m.getCodeVector().size()) {
      m.execute();
    }

    assertEquals(m.getResult(), "10"); 
  }
  
  @Test
  public void testEq()
  {
    Compiler c = new Compiler();
    Machine m = new TRIVMachine();      
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();

    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("3 == 3");
    }
    catch (SymbolNotFoundException e) {
      e.printStackTrace();
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    m.setCodeVector(cv);
    
    while (m.getCurrentCodePointer() < m.getCodeVector().size()) {
      m.execute();
    }

    assertEquals(m.getResult(), "true"); 
  }
  
  @Test
  public void testIf()
  {
    Compiler c = new Compiler();
    Machine m = new TRIVMachine();      
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();

    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("if (true) then 0 else 1");
    }
    catch (SymbolNotFoundException e) {
      e.printStackTrace();
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    m.setCodeVector(cv);
    
    while (m.getCurrentCodePointer() < m.getCodeVector().size()) {
      m.execute();
    }

    assertEquals(m.getResult(), "0"); 
  }
  
  @Test
  public void testElse()
  {
    Compiler c = new Compiler();
    Machine m = new TRIVMachine();      
    List<CodeVectorType> cv = new ArrayList<CodeVectorType>();

    c.setParserStrategy(new TRIVParserStrategy());
    c.setLexerStrategy(new TRIVLexerStrategy());
    c.setPatternStrategy(new TRIVPatternStrategy());

    try {
      cv = c.compile("if (false) then 0 else 1");
    }
    catch (SymbolNotFoundException e) {
      e.printStackTrace();
    }
    catch (IllegalCharacterException e) {
      e.printStackTrace();
    }
    catch (IdentifierNotDeclaredException e) {
      System.out.println(e.getMessage());
    }

    m.setCodeVector(cv);
    
    while (m.getCurrentCodePointer() < m.getCodeVector().size()) {
      m.execute();
    }

    assertEquals(m.getResult(), "1"); 
  }

}
