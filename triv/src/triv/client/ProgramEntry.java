package triv.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.dom.client.Style.Unit;

public class ProgramEntry implements EntryPoint
{

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void onModuleLoad()
	{

		LayoutPanel mainPanel = new LayoutPanel();
		
		Button btnCompile = new Button("Compile");
		mainPanel.add(btnCompile);
		mainPanel.setWidgetLeftWidth(btnCompile, 43.0, Unit.PX, 81.0, Unit.PX);
		mainPanel.setWidgetTopHeight(btnCompile, 219.0, Unit.PX, 30.0, Unit.PX);
		
		TextArea textAreaCode = new TextArea();
		mainPanel.add(textAreaCode);
		mainPanel.setWidgetLeftWidth(textAreaCode, 43.0, Unit.PX, 361.0, Unit.PX);
		mainPanel.setWidgetTopHeight(textAreaCode, 50.0, Unit.PX, 161.0, Unit.PX);

	}
}
