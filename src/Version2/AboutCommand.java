package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command{
private GameWorld gw;
	
	public AboutCommand(GameWorld gw) {
		super("About");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//outputs a string about my info and ok command to exit out of it when done
		String info = "Bryan Pena, CSC 133, Version 2";
		Command ok = new Command("ok");
		Dialog.show("About",info, ok);
		gw.notifyObservers();
	}
}
