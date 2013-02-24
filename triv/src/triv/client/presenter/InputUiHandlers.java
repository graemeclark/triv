package triv.client.presenter;

import java.util.List;

import com.gwtplatform.mvp.client.UiHandlers;

public interface InputUiHandlers extends UiHandlers
{
	
	//void getComponents(String component);
	//List<String> handleComponents(String component);
	List<String> compile(String source);
	void setParser(String name);
	void setLexer(String name);
	void setPattern(String name);
}
