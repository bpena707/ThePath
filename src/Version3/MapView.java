package com.mycompany.a3;


import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer{
	//this is the origin of the mapview needed to 
	
	private GameObjectCollection obj;
	private GameWorld gw;
	private Game g;
	private Fixed objSelected;
	private int pointerX;
	private int pointerY;
	private boolean positionPress;
	

	
	
	public MapView(GameWorld gameWorld, Game g) {
		
		gw = (GameWorld) gameWorld;
		obj = gw.getCollection();
		this.g = g;

		
		this.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.rgb(255, 0, 0)));
		
		
		
	}
	
	
	
	
	public void update(Observable GameWorld, Object data) {
		
		gw.map();


		repaint();
	}
	
	
	@Override
	public void paint(Graphics g) {
	super.paint(g);
	Point pCmpRelPrnt = new Point(this.getX(), this.getY());
	IIterator gameObjectIterator = obj.getIterator();
	while(gameObjectIterator.hasNext()) {
		GameObject obj = (GameObject) gameObjectIterator.getNext();
		obj.draw(g, pCmpRelPrnt);

			
		}
		
		}
	
	
	
	
	@Override
	public void pointerPressed(int x, int y) {
		if(g.isPaused()) {
		if (objSelected == null && positionPress == false) {
			// mouse click fix
			pointerX = x - getParent().getAbsoluteX();
			pointerY = y - getParent().getAbsoluteY();
			
			Point pPtrRelPrnt = new Point(pointerX, pointerY);
			Point pCmpRelPrnt = new Point(getX(), getY());
			
			IIterator gameObjectIterator = obj.getIterator();
			
			while (gameObjectIterator.hasNext())
			{
				GameObject obj = (GameObject) gameObjectIterator.getNext() ;
				if (obj instanceof Fixed)
				{
					Fixed selectObj = (Fixed) obj;
					
					if (selectObj.contains(pPtrRelPrnt, pCmpRelPrnt))
					{
						objSelected = (Fixed) obj;
						objSelected.setSelected(true);
					}
				}
			}
		}else if(objSelected != null && positionPress){
			
			objSelected.setLocation(x - getParent().getAbsoluteX() - getX(), y - getParent().getAbsoluteY() - getY());
			objSelected.setSelected(false);
			objSelected = null;
		}else {
			positionPress = false;
		}
		repaint();
		System.out.println("Pressed");
	}else{
		return;
	}
		
		
	}
	public void positionPress() {
		positionPress = true;
	}
	
	
	
	}

	
	
//}

