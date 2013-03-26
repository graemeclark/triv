package triv.client.model.strategy.parser;

import java.util.ArrayList;
import java.util.List;

import triv.client.model.compiler.*;
import triv.client.model.runtime.instruction.*;
import triv.client.model.runtime.types.CodeVectorType;
import triv.client.model.strategy.interfaces.*;

public class TRIVParserStrategy implements ParserStrategy
{
  protected LexerStrategy lex;
  protected SymbolTable symbolTable;
  protected List<CodeVectorType> codeVector;
  protected String lastExpType;
  protected Integer codeIndex, codeAddr;

  public List<CodeVectorType> parse(LexerStrategy l, String source)
      throws SymbolNotFoundException, IllegalCharacterException, IdentifierNotDeclaredException
      {
    symbolTable = new SymbolTable();
    codeVector = new ArrayList<CodeVectorType>();
    codeIndex = 0;

    lex = l;
    lex.initialise(source);
    expression();
    addIns(new CodeVectorType(new Return()));

    if (!lex.getCurrentSymbol().getValue().equals("end of program")) {
      throw new IllegalCharacterException("symbols found after end of program");
    }

    return codeVector;		
      }

  public String expression()
      throws SymbolNotFoundException, IllegalCharacterException, IdentifierNotDeclaredException
      {		
    Symbol sym = lex.getCurrentSymbol();

    if (lex.have("let")) {
      letExpression();
    }

    else if (lex.have("if")) {
      ifExpression();
    }

    else if (lex.have("identifier")) {
      Integer addr = symbolTable.lookup(sym);
      if (addr != null) {
        addIns(new CodeVectorType(new StackLoad()));
        addIns(new CodeVectorType(addr));

        if (codeVector.get(addr + 1).isInt()) {
          lastExpType = "int";
        }
        if (codeVector.get(addr + 1).isBool()) {
          lastExpType = "bool";
        }
      }
      else {
        throw new IdentifierNotDeclaredException(sym.getValue() + " hasn't been declared.");
      }
    }

    else if (lex.have("numericLiteral")) {
      lastExpType = "int";
      addIns(new CodeVectorType(new LoadInt()));
      addIns(new CodeVectorType(Integer.parseInt(sym.getValue())));
    }

    else if (lex.have("boolLiteral")) {
      lastExpType = "bool";
      addIns(new CodeVectorType(new LoadBool()));
      addIns(new CodeVectorType(Boolean.parseBoolean(sym.getValue())));
    }

    else if (lex.have("(")) {
      lastExpType = expression();
      lex.mustBe(")");
    }

    else {
      if (sym == null) {
        throw new SymbolNotFoundException("null found where expression expected");
      }
      else {
        throw new SymbolNotFoundException(sym.getType() + " found where expression expected");
      }
    }

    if (lex.have("+")) {
      String e2 = expression();
      if (lastExpType.equals("int") && e2.equals("int")) {
        addIns(new CodeVectorType(new AddOp()));
        lastExpType = "int";
      }
      else {
        throw new SymbolNotFoundException(e2 + " found where int expected");
      }
    }

    else if (lex.have("==")) {
      String e2 = expression();
      if (lastExpType.equals(e2)) {
        addIns(new CodeVectorType(new EqualOp()));
        lastExpType = "bool";
      }
      else {
        throw new SymbolNotFoundException(lastExpType + " & " + e2 + " are not compatible here.");
      }
    }

    return lastExpType;
      }

  private void addIns(CodeVectorType c)
  {
    codeVector.add(codeIndex, c);
    if (c.isInstruction()) {
      codeAddr = codeIndex;
    }
    codeIndex++;
  }

  private void letExpression()
      throws SymbolNotFoundException, IllegalCharacterException, IdentifierNotDeclaredException
      {
    Symbol variable = lex.getCurrentSymbol();		
    lex.mustBe("identifier");
    if (symbolTable.lookup(variable) != null) {
      throw new IdentifierNotDeclaredException(variable.getValue() + " has already been declared.");
    }
    lex.mustBe("=");
    expression();
    symbolTable.put(variable.getValue(), codeAddr);
    lex.mustBe("in");
    expression();
    addIns(new CodeVectorType(new Retract()));
      }

  private void ifExpression()
      throws SymbolNotFoundException, IllegalCharacterException, IdentifierNotDeclaredException
      {
    lex.mustBe("(");
    expression();

    if (!lastExpType.equals("bool")) {
      throw new SymbolNotFoundException(lastExpType + " found where bool expected");
    }

    lex.mustBe(")");
    addIns(new CodeVectorType(new JumpIfFalse()));
    Integer falseJumpAddress = codeIndex;

    lex.mustBe("then");
    String type2 = expression();

    addIns(new CodeVectorType(new Jump()));
    codeVector.add(falseJumpAddress, new CodeVectorType(codeIndex + 2));
    Integer jumpAddress = ++codeIndex;

    lex.mustBe("else");
    String type3 = expression();
    codeVector.add(jumpAddress, new CodeVectorType(++codeIndex));

    if (!type2.equals(type3)) {
      throw new SymbolNotFoundException(type2 + " and " + type3 + " are not compatible here");
    }
      }

}
