package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

//simple command to turn right by invoking the gameworld function
public class RightCommand extends Command{
	private GameWorld gw;
	
	public RightCommand(GameWorld gw) {
		super("Right");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.turnRight();
		gw.notifyObservers();
	}

}