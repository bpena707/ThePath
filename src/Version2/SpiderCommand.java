package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
//simple command to collide spiders by invoking the gameworld function
public class SpiderCommand extends Command{
	private GameWorld gw;
	
	public SpiderCommand(GameWorld gw) {
		super("Collide with Spider");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.spiderCollision();
		gw.notifyObservers();
	}

}
