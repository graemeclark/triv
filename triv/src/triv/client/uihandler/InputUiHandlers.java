package triv.client.uihandler;

import java.util.List;

import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.compiler.SymbolNotFoundException;
import triv.client.model.runtime.types.CodeVectorType;

import com.gwtplatform.mvp.client.UiHandlers;

public interface InputUiHandlers extends UiHandlers
{
	
	//void getComponents(String component);
	//List<String> handleComponents(String component);
	List<CodeVectorType> compile(String source)
			throws SymbolNotFoundException, IllegalCharacterException;
	void setParser(String name);
	void setLexer(String name);
	void setPattern(String name);
	void execute();
}
