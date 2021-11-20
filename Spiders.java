package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;





public class Spiders extends Moveable implements IDrawable{
	
	
	/** The rand. */
	Random rand = new Random();
	
	/**
	 * Instantiates a new spiders.
	 *
	 * @param x the x
	 * @param y the y
	 * @param s the s
	 * @param r the r
	 * @param g the g
	 * @param b the b
	 * @param sp the sp
	 * @param h the h
	 */
	public Spiders(float x, float y, int s, int r, int g, int b, int sp, int h) {
		super(x, y, s, r, g, b, sp, h);
//		super.setLocation(rand.nextFloat() *1000 , rand.nextFloat() *1000);
//		super.setSpeed(rand.nextInt(10) + 5);
//		super.setHeading(rand.nextInt(359));
	}
	
	

	
	
	/**
	 * Move will cause the spider to move. since the spider is not controlled by the player 
	 * a random heading is assigned to the spider to make it 
	 */
	@Override
	public void move(double maxWidth, double maxHeight, int elapsedTime) {
		double theta;
		float x = super.getLocation().getX();
		float y = super.getLocation().getY();
		float deltaX;
		float deltaY;
		
		double distance = (getSpeed() * elapsedTime) / 1000;	
		
		Random rand = new Random();
		int randomvalue = -5 + rand.nextInt(5-(-5));
        theta = Math.toRadians(90 - super.getHeading());

        deltaX = (float) (Math.cos(theta) * distance);
        deltaY = (float) (Math.sin(theta) * distance);
        
        float newLocationX = x + deltaX;
        float newLocationY = y + deltaY;
        
        super.setLocation(newLocationX, newLocationY);
    	super.setHeading(getHeading() + randomvalue);
        
        if(newLocationX >= maxWidth || newLocationX <= 0 || newLocationY >= maxHeight || newLocationY <= 0) {
        	super.setHeading(super.getHeading() + 180);
        }
		
	}
	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		//x and y are set to the locatoin + the offset
		int x = (int) ((int) ( getLocation().getX() - (getSize() / 2) ) + pCmpRelPrnt.getX()) ;
		int y = (int) ((int) ( getLocation().getY() - (getSize() / 2) ) +  pCmpRelPrnt.getY());
		int xPoints[] = {x, x + getSize(), x + (getSize() / 2)};
		int yPoints[] = {y, y, y + getSize()};
		int nPoints = 3;
		
		//creates a rectabgle and fills the color for the and which is red
		g.setColor(this.getColor());
		g.drawPolygon(xPoints, yPoints, nPoints);
		g.fillPolygon(xPoints, yPoints, nPoints);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		
		String superval = super.toString();
		return "Spider " + superval;
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
		
		int radiiSqr = ((thisRadius*otherRadius) + (2*thisRadius*otherRadius) + (otherRadius*otherRadius));
		
		if (distBetweenCentersSqr <= radiiSqr) { 
    		result = true ; 
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
	public void handleCollision(GameObject obj, GameWorld gw) {
		// TODO Auto-generated method stub
		if(this.getCollide().contains(obj) == false) {
			
			this.getCollide().add(obj);
		}
	}

}
