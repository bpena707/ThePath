package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

//simple command toaccelerate by invoking the gameworld function
public class AccelerateCommand extends Command{
	private GameWorld gw;
	
	public AccelerateCommand(GameWorld gw) {
		super("Accelerate");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.accelerate();
		gw.notifyObservers();
	}
	

}
