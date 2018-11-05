package ru.antony.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


public class StartPage implements EntryPoint {

	public void onModuleLoad() {
		MainPanel mainPanel = new MainPanel();
		RootPanel.get().add(mainPanel);
	}
}
