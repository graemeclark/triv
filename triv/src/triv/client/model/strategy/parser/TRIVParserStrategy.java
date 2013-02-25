package triv.client.model.strategy.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Window;

import triv.client.model.compiler.*;
import triv.client.model.runtime.instruction.*;
import triv.client.model.runtime.types.CodeVectorType;
import triv.client.model.strategy.interfaces.*;

public class TRIVParserStrategy implements ParserStrategy
{
	protected LexerStrategy lex;
	protected SymbolTable symbolTable;
	protected List<CodeVectorType> codeVector;

	public List<CodeVectorType> parse(LexerStrategy l, String source)
			throws SymbolNotFoundException, IllegalCharacterException
	{
		symbolTable = new SymbolTable();
		codeVector = new ArrayList<CodeVectorType>();
		
		lex = l;
		lex.initialise(source);
		expression();
		
		return codeVector;		
	}

	public Symbol expression()
			throws SymbolNotFoundException, IllegalCharacterException
	{		
		Symbol sym = lex.getCurrentSymbol();
		Window.alert(sym.getType());
		
		if (lex.have("let")) {
			letExpression();
		}
		
		else if (lex.have("identifier")) {
			if (symbolTable.lookup(sym) != null) {
				//codeVector.add("stackLoad");
				//codeVector.add(sym.getValue());
			}
		}
		
		else if (lex.have("numericLiteral")) {
			codeVector.add(new CodeVectorType(new LoadInt()));
			codeVector.add(new CodeVectorType(Integer.parseInt(sym.getValue())));
		}
		
		else if (lex.have("boolLiteral")) {
			codeVector.add(new CodeVectorType(new LoadBool()));
			codeVector.add(new CodeVectorType(Boolean.parseBoolean(sym.getValue())));
		}
		return sym;		
	}
	
	private void letExpression()
			throws SymbolNotFoundException, IllegalCharacterException
	{
		Symbol variable = lex.getCurrentSymbol();
		
		lex.mustBe("identifier");
		lex.mustBe("=");
		
		Symbol init = expression();
		symbolTable.put(variable.getValue(), init.getValue());

		lex.mustBe("in");

		expression();
	}

}
