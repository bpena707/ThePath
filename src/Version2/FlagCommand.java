package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class FlagCommand extends Command{
	private GameWorld gw;
	
	public FlagCommand(GameWorld gw) {
		super("Collide with Flag");
		this.gw = gw;
	}
	
	/**
	 * Action performed.
	 *
	 * @param ev the ev
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		
			//setting of the ok command, textfield, dialog, 
			Command ok = new Command("OK");
			TextField numberText = new TextField();
			Dialog.show("Enter Number :  ", numberText, ok);
			//number is = to an integer and parses the string for ascii values
			int  number = Integer.parseInt(numberText.getText());
			System.out.println(number);
			
			//checks to make sure we are inputing a number between 1-9
			//then causes collision and notifies observers 
			if (number >= 1 && number <= 9) {
				gw.flagCollision(number);
				gw.notifyObservers();
			} 
			else {
				//handles in the case where any other key other than 1-9 is input
				System.out.println("Please Enter Valid Number form 1 to 9 : ");
				boolean flag = true;
				while(flag) {
					Command cOk = new Command("OK");
					TextField numberError = new TextField();
					Dialog.show("Please Enter Valid Number form 1 to 9 :  ", numberError, cOk);
					number = Integer.parseInt(numberError.getText());
					
					if (number >= 1 && number <= 9) {
						gw.flagCollision(number);
						gw.notifyObservers();
						flag = false;
					} 
					else {
						flag = true;
					}
				}
				
			}
		}
		
	}



