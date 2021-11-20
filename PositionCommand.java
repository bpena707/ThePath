package com.mycompany.a3;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PositionCommand extends Command{
	private Game game;
	private MapView mv;
	
	public PositionCommand(Game game, MapView mv) {
		super("Position");
		this.game = game;
		this.mv = mv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(game.isPaused() == true) {
			mv.positionPress();
		} else {
			return;
		}
	}

}
