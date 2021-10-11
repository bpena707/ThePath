package com.mycompany.a1;
import com.codename1.ui.Form;

import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.lang.String;

public class Game extends Form {
	private GameWorld gw;
	private boolean flagCheck = false;
	
	/**
	 * Instantiates a new game.
	 */
	public Game() {
		gw = new GameWorld();
		gw.init();
		
		
		play();
	}
	
	/**
	 * Play.
	 */
	private void play() {
		//instantiates new label to enter command
		//then adds component
		Label myLabel = new Label("Enter a Command: ");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		
		myTextField.addActionListener(new ActionListener() {
			
			/**
			 * Action performed is a listener that uses a switch statement that grab the input from the user so that 
			 * the appropriate action is performed
			 *
			 * @param evt the evt
			 */
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				if(sCommand.length() != 0)
					switch(sCommand.charAt(0)) {
					case 'a':
						gw.accelerate();
						break;
					case 'b':
						gw.brake();
						break;
					case 'l':
						gw.turnLeft();
						break;
					case 'r': 
		                gw.turnRight();
		                break;
					case '1':
						gw.flagCollision1(1);
						break;
					case '2':
						gw.flagCollision2(2);
						break;
					case '3':
						gw.flagCollision3(3);
						break;
					case '4':
						gw.flagCollision4(4);
						break;
					case '5':
						gw.flagCollision5(5);
						break;
					case '6':
						gw.flagCollision6(6);
						break;
					case '7':
						gw.flagCollision7(7);
						break;
					case '8':
						gw.flagCollision8(8);
						break;
					case '9':
						gw.flagCollision9(9);
						break;
		            case 'f': 
		                gw.foodStationCollision();
		                break;
		            case 'g': 
		                gw.spiderCollision();
		                break;
		            case't':
		            	gw.gameClockTick();
		            	break;
		            case'd':
		            	gw.display();
		            	break;
		            case 'm': 
		                gw.map();
		                break;
		            case 'x': //this case performs the boolean function and asks for an input from the user to see if the game will be closed
		            	System.out.println("Would you like to quit? Input y for yes n for no");
			             flagCheck = true;
		                break;
		            case 'y': 
		            	if(flagCheck == true)  
		                System.exit(0);
		                break;
		            case 'n': 
		                if(flagCheck == false)
		                	flagCheck = true;
		                break;	
		            default: //tells the user that no command was entered 
		                System.out.println("no command entered");
		                break;
					}
			
			}
		}
		);
	}
}



