package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer{
	
	
	
	
	public MapView() {
		this.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.rgb(255, 0, 0)));
		
		
	}
	
	
	
	public void update(Observable GameWorld, Object gameObjectCollection) {
		//no code yet since we don't have any graphical output but it can iterate through 
		//the objects at this point in a similar fashion to m and output them to the console
		GameWorld gw = (GameWorld) GameWorld;
		gw.map();
		
	

		
	}

}
