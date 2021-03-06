package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


//simple command to brake by invoking the gameworld function
public class BrakeCommand extends Command{
	private GameWorld gw;
	
	public BrakeCommand(GameWorld gw) {
		super("Brake");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.brake();
		gw.notifyObservers();
	}

}
