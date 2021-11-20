package com.mycompany.a2;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command{
	private CheckBox soundBox;
	private GameWorld gw;
	
	public SoundCommand(GameWorld gw, CheckBox soundBox)
	{
		super("Sound ON/OFF");
		this.gw = gw;
		this.soundBox = soundBox;
	}
	public void actionPerformed(ActionEvent event)
	{
		//goes through an if statement to set the sound to on or off
		if (soundBox.isSelected())
		{
			System.out.println("Sound turned on");
			gw.setSound(true);
			gw.notifyObservers();
		}
		else
		{
			System.out.println("Sound turned off");
			gw.setSound(false);
			gw.notifyObservers();
		}
	}
}
