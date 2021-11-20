package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command{
	private GameWorld gw;
	
	public HelpCommand(GameWorld gw) {
		super("Help");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//displays all of the commands as strings so the user knows how to play the game
		Command ok = new Command("OK");
		String play = "  a : Accelerate \n"
					+ "  b : Brake \n"
					+ "  l : Turn left \n"
					+ "  r : Turn right \n"
					+ "  1-9 : Collide with Flag \n"
					+ "  f : Collide with FoodStation \n"
					+ "  g : Collide with Spider \n"
					+ "  t : Tick the Clock \n";
		
		Dialog.show("Help", play, ok);
		gw.notifyObservers();
	}
}
