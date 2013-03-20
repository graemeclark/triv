package triv.client.uihandler;

import java.util.List;

import triv.client.model.compiler.IdentifierNotDeclaredException;
import triv.client.model.compiler.IllegalCharacterException;
import triv.client.model.compiler.SymbolNotFoundException;
import triv.client.model.runtime.types.CodeVectorType;
import triv.client.presenter.NoSourceCodeException;

import com.gwtplatform.mvp.client.UiHandlers;

public interface InputUiHandlers extends UiHandlers
{
	
	//void getComponents(String component);
	//List<String> handleComponents(String component);
	List<CodeVectorType> compile(String source)
			throws SymbolNotFoundException, IllegalCharacterException, IdentifierNotDeclaredException, NoSourceCodeException;
	void execute();
}
