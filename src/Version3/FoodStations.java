package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;





/**
 * The Class FoodStations.
 */
public class FoodStations extends Fixed{
	
	
	private int capacity;
	
	/** The rand.  will generate rhe random variables to be used in location 
	 * and size for the food stations
	 * */
	Random rand = new Random();

	private boolean selected;
	
	/**
	 * Instantiates a new food stations.
	 *
	 * @param x the x
	 * @param y the y
	 * @param s the s
	 * @param r the r
	 * @param g the g
	 * @param b the b
	 */
	//capacity is determined after the random size is determined and then matched proportionally
	public FoodStations(float x, float y, int s, int r, int g, int b){
		super(x, y, s, r, g, b);
		super.setLocation(rand.nextFloat() *1000 , rand.nextFloat() *1000);
		super.setSize(rand.nextInt(100-50) + 50);
//		super.setColor(0, 255, 0);
		this.capacity = this.getSize();
	}
	
	/**
	 * Checks if capacity empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {// check here to see the difference between Boolean and boolean
		if(capacity == 0) {
			return true;
		}
		return false;
	}


	/**
	 * Gets the capacity.
	 *
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * Sets the capacity.
	 *
	 * @param c the new capacity
	 */
	public void setCapacity(int c) {
		capacity = c;
	}
	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		//x and y are set to the locatoin + the offset
		
		int x = (int) ((int) ( getLocation().getX() - (getSize() / 2) ) + pCmpRelPrnt.getX()) ;
		int y = (int) ((int) ( getLocation().getY() - (getSize() / 2) ) +  pCmpRelPrnt.getY());
		
				
				//creates a rectabgle and fills the color for the and which is red
		g.drawString(Integer.toString(getCapacity()), x, y);
		g.setColor(this.getColor());
//		g.drawRect(x, y, getSize(), getSize());
		g.fillRect(x, y, getSize(), getSize());
		
		
		g.setAlpha(100);
		if (!isSelected()) {
			g.fillRect(x, y, getSize(), getSize());
		}
		else {
			g.drawRect(x, y, super.getSize(), super.getSize());
		}
		g.setAlpha(200);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String superval = super.toString() + " capacity=" + getCapacity();
		return "FoodStations " + superval;

	}

	

	@Override
	public void handleCollision(GameObject otherObject, GameWorld gw) {
		// TODO Auto-generated method stub
		if(this.getCollide().contains(otherObject) == false) {
			
			this.getCollide().add(otherObject);
		}
	}

	@Override
	public boolean collidesWith(GameObject otherObject) {
		boolean result = false;
		//gets the center for this object 
		int thisCenterX = (int) getLocation().getX();
		int thisCenterY = (int) getLocation().getY();
		//gets the center of the other object
		int otherCenterX = (int) otherObject.getLocation().getX();
		int otherCenterY = (int) otherObject.getLocation().getY();
		
		//distance between the two centers 
		int dx = thisCenterX - otherCenterX;
		int dy = thisCenterY - otherCenterY;
		int distBetweenCentersSqr = (dx*dx + dy*dy);
		
		int thisRadius = this.getSize()/2;
    	int otherRadius = otherObject.getSize()/2;
		
		int radiiSqr = ((thisRadius*thisRadius) + (2*thisRadius*otherRadius) + (otherRadius*otherRadius));
		
		if (distBetweenCentersSqr <= radiiSqr) { 
    		result = true; 
    	}else {
    		if(this.getCollide().isEmpty()==false) {
    			if(this.getCollide().contains(otherObject)) {
    				this.getCollide().remove(otherObject);    			
    				}
    		}
    	}
    	
    	return result;
	}

	@Override
	public void setSelected(boolean b) {
		
		this.selected = b;
	}

	@Override
	public boolean isSelected() {
		
		return selected;
	}

	@Override
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrint) {
		int px = (int) pPtrRelPrnt.getX(); 
		int py = (int) pPtrRelPrnt.getY(); 
		
		int xLoc = (int) (pCmpRelPrint.getX() + (int) getLocation().getX());// shape location relative
		int yLoc = (int) (pCmpRelPrint.getY() + (int) getLocation().getY());// to parent�s origin
		
		if ( (px >= xLoc - getSize()/2) && (px <= xLoc + getSize()/2) 
		&& (py >= yLoc - getSize()/2) && (py <= yLoc + getSize()/2) ) {
				return true; 
		}
		else {
			return false;
		}
	}
	

	
}