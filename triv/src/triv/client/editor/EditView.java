package triv.client.editor;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.gwtplatform.mvp.client.View;

/**
 * Interface for a view with an editor.
 * 
 * Adapted from code at 
 * @author Graeme Clark
 *
 * @param <B>
 */
public interface EditView<B> extends View, Editor<B>
{
	SimpleBeanEditorDriver<B, ?> createEditorDriver();
}
