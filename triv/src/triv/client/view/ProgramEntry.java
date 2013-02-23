package triv.client.view;

import java.util.ArrayList;
import java.util.List;

import triv.client.presenter.ProgramEntryPresenter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.dom.client.Style.Unit;

public class ProgramEntry implements EntryPoint
{
	
	private static final String PARSER = "parser";
	private static final String LEXER = "lexer";
	private static final String PATTERN = "pattern";
	
	ProgramEntryPresenter presenter = new ProgramEntryPresenter();
	public List<String> parsers = new ArrayList<String>();

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
		
		presenter.getComponents(PARSER);
		
		parserComboBox.setVisibleItemCount(parsers.size());
		
		for (String s : parsers) {
			parserComboBox.addItem(s);			
		}
		
		RootPanel.get("btnCompile").add(btnCompile);
		RootPanel.get("parserComboBox").add(parserComboBox);
		
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
