package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

//simple command to turn left by invoking the gameworld function
public class LeftCommand extends Command{
	private GameWorld gw;
	
	public LeftCommand(GameWorld gw) {
		super("Left");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.turnLeft();
		gw.notifyObservers();
	}

}
