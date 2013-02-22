package triv.client.view;

import triv.client.presenter.ProgramEntryPresenter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;

public class ProgramEntry implements EntryPoint
{
	
	ProgramEntryPresenter presenter = new ProgramEntryPresenter();

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void onModuleLoad()
	{

		LayoutPanel mainPanel = new LayoutPanel();
		
		final Button btnCompile = new Button("Compile");
		mainPanel.add(btnCompile);
		mainPanel.setWidgetLeftWidth(btnCompile, 43.0, Unit.PX, 81.0, Unit.PX);
		mainPanel.setWidgetTopHeight(btnCompile, 219.0, Unit.PX, 30.0, Unit.PX);
		
		final ListBox parserComboBox = new ListBox();
		mainPanel.add(parserComboBox);
		mainPanel.setWidgetLeftWidth(parserComboBox, 43.0, Unit.PX, 65.0, Unit.PX);
		mainPanel.setWidgetTopHeight(parserComboBox, 25.0, Unit.PX, 26.0, Unit.PX);
		
		/*ImmutableSet<ClassInfo> parsers = presenter.getParsers();
		
		for (ClassInfo c : parsers) {
			
			parserComboBox.addItem(c.getName());
			
		}*/
		
		//parserComboBox.setVisibleItemCount(parsers.size());
		
		/*parserComboBox.addChangeHandler(new ChangeHandler()
		{
			public void onChange(ChangeEvent event)
			{
				int current = parserComboBox.getSelectedIndex();
				presenter.updateParser(parserComboBox.getItemText(current));
			}
		});*/

	}
}
