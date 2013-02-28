package triv.client.editor;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.gwtplatform.mvp.client.View;

public interface EditView<B> extends View, Editor<B>
{
	SimpleBeanEditorDriver<B, ?> createEditorDriver();
}
