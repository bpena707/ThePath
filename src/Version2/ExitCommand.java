package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command {
private GameWorld gw;
	
	public ExitCommand(GameWorld gw) {
		super("Exit");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//print out a dialog and exits if the user clicks yes
		boolean exit = Dialog.show("Exit", "Would you like to exit the game?", "Yes", "No");
		if(exit) {
			System.exit(0);
		}
		gw.notifyObservers();
	}
}

