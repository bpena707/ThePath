package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;



public class ScoreView extends Container implements Observer{
	//decale labels for all that is goign to output on the screen
	private Label clock;
	private Label livesLeft;
	private Label lastFlagReached;
	private Label antFoodLevel;
	private Label antHealth;
	private Label sound;
	
	public ScoreView() {
		//flow layout is now the default and centered
		this.setLayout(new FlowLayout(CENTER));
		
		//labels are created, added to the component and set style
		clock = new Label("Time: 0");
		this.addComponent(clock);
		clock.getUnselectedStyle().setFgColor(ColorUtil.BLUE);;
		
		
		livesLeft = new Label("Lives Left: 0");
		this.addComponent(livesLeft);
		livesLeft.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		
		lastFlagReached = new Label("Last Flag Reached: 0");
		this.addComponent(lastFlagReached);
		lastFlagReached.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		
		antFoodLevel = new Label("Food Level: 0");
		this.addComponent(antFoodLevel);
		antFoodLevel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		
		antHealth = new Label("Health Level: 0");
		this.addComponent(antHealth);
		antHealth.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		sound = new Label("Sound: ON");
		this.addComponent(sound);
		sound.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		
		
	}
	@Override
	public void update(Observable GameWorld, Object gameObjectCollection) {
		Ant ant = Ant.getAnt();
		GameWorld gw = (GameWorld) GameWorld;
		
		//setText will overrid the labels and set them to the games actual values 
		clock.setText("Time: " + gw.getClock());
		
		livesLeft.setText("Lives Left: " + gw.getLives());
		
		lastFlagReached.setText("Last Flag Reached: " + ant.getLastFlagReached());
		
		antFoodLevel.setText("Food Level: " + ant.getFoodLevel());
		antHealth.setText("Health Level: " + ant.getHealthLevel());
		
		if (gw.getSound()) {
			sound.setText("Sound:	" + "ON");
		} else {
			sound.setText("Sound:	" + "OFF");
		}
		
		
	}
	

}
