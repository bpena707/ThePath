package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
//simple command to collide food station by invoking the gameworld function

public class FoodCommand extends Command{
	private GameWorld gw;
	
	public FoodCommand(GameWorld gw) {
		super("Collide with Food Station");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.foodStationCollision();
		gw.notifyObservers();
	}

}
