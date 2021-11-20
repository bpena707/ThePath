package com.mycompany.a3;

import com.codename1.ui.Command;

import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game;

public class PauseCommand extends Command{
	
	//declaration of a game as a temp variable to access game
	private Game game;
	
	public PauseCommand(Game game) {
		super("Pause");
		this.game = game;
	}
	
	
	


	public void actionPerformed(ActionEvent event) {
		if(!game.isPaused()) {
			game.pause();
		}
		else {
			System.out.println("Pause");
			game.play();
		}
	}
	
	
}
