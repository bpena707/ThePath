package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;

/**
 * The Class Ant.
 */
public class Ant extends Moveable implements ISteerable{
	
	/** The maximum speed. */
	private int maximumSpeed;
	
	/** The food level. */
	private int foodLevel;
	
	/** The food consumption rate. */
	private int foodConsumptionRate;
	
	/** The health level. */
	private int healthLevel;
	
	/** The last flag reached. */
	private int lastFlagReached;
	
	private static Ant theAnt;
	
	private Ant(float x, float y, int s, int r, int g, int b, int sp, int h, int ms, int fl, int fcr, int hl, int lfr) {
		super(x, y, s, r, g, b, sp, h);
//		super.setColor(255, 0, 0);
		 maximumSpeed = ms;
		 foodLevel = fl;
		 foodConsumptionRate = fcr;
		 healthLevel = hl;
		 lastFlagReached = lfr; 
	}
	
	public static Ant getAnt() {
		if(theAnt == null)
			theAnt = new Ant(100, 200, 100, 255, 0, 0, 100,  5,  50,  2000,  2,  100,  1);
		return theAnt;
	
	}
	
	
	
	
	public void clear() {
		theAnt = null;
	}
	
	/**
	 * Gets the maximum speed.
	 *
	 * @return the maximum speed
	 */
	public int getMaximumSpeed() {
		return maximumSpeed;
	}
	
	/**
	 * Gets the food level.
	 *
	 * @return the food level
	 */
	public int getFoodLevel() {
		return foodLevel;
	}
	
	/**
	 * Gets the food consumption rate.
	 *
	 * @return the food consumption rate
	 */
	public int getFoodConsumptionRate() {
		return foodConsumptionRate;
	}
	
	/**
	 * Gets the health level.
	 *
	 * @return the health level
	 */
	public int getHealthLevel() {
		return healthLevel;
	}
	
	/**
	 * Gets the last flag reached.
	 *
	 * @return the last flag reached
	 */
	public int getLastFlagReached() {
		return lastFlagReached;
	}
	
	/**
	 * Sets the maximum speed.
	 *
	 * @param ms the new maximum speed
	 */
	public void setMaximumSpeed(int ms) {
		maximumSpeed = ms;
	}
	
	/**
	 * Sets the food level.
	 *
	 * @param f the new food level
	 */
	public void setFoodLevel(int f) {
		foodLevel = f;
	}
	
	/**
	 * Sets the food consuption rate.
	 *
	 * @param fcr the new food consuption rate
	 */
	public void setFoodConsuptionRate(int fcr) {
		foodConsumptionRate = fcr;
	}
	
	/**
	 * Sets the health level.
	 *
	 * @param hl the new health level
	 */
	public void setHealthLevel (int hl) {
		healthLevel = hl;
	}
	
	/**
	 * Sets the last flag reached.
	 *
	 * @param lff the new last flag reached
	 */
	public void setLastFlagReached(int lff) {
		lastFlagReached = lff;
	}
	
	
	
	
	
	/**
	 * Accelerate based on health and food level not being 0.
	 * also cannot go past the max speed
	 * as long as these conditions arent met the ant accelerates by factor of 5
	 */
	public void accelerate() {
		if(healthLevel == 0 || foodLevel == 0 ) {
			super.setSpeed(0);
		}else if(super.getSpeed() >= maximumSpeed){
			super.setSpeed(maximumSpeed);
		}else {
			super.setSpeed(super.getSpeed() + 5 );
		}
	}
	
	
	/**
	 * Brake simply decreases the speed of the ant by factor of 1
	 */
	public void brake() {
		if(super.getSpeed() <= 0) {
			return;
		}else{
			super.setSpeed(super.getSpeed() - 1 );
		}
	}
	
	/**
	 * Turn left overides isteerable heading is changed to -5 to simulate a left turn 
	 */
	@Override
	public void turnLeft() {
		super.setHeading(super.getHeading() - 5);
		}

	
	
	/**
	 * Turn right overides isteerable heading is changed to + 5 to simulate a left turn 
	 */
	@Override
	public void turnRight() {
		super.setHeading(super.getHeading() + 5);
		
	}
	
	
	/**
	 * Checks if ant is alive by checking the health and food level if either is zero returns false
	 *
	 * @return the boolean
	 */
	public Boolean isAlive() {
		if(this.healthLevel <= 0 || this.foodLevel <= 0) {
			return false;
		}else {
			return true;
		}
	}
	
	
	
	
	
	
	
	/**
	 * Move.
	 */
	@Override
	public void move(double maxWidth, double maxHeight, int elapsedTime){
		double theta;
		float x = super.getLocation().getX();
		float y = super.getLocation().getY();
		float deltaX;
		float deltaY;
		
		double distance = (getSpeed() * elapsedTime) / 1000;
		
        theta = Math.toRadians(90 - super.getHeading());

        deltaX = (float) (Math.cos(theta) * distance);
        deltaY = (float) (Math.sin(theta) * distance);
        
        
        float newLocationX = x + deltaX;
        float newLocationY = y + deltaY;
        
        super.setLocation(newLocationX, newLocationY);
        
        if(newLocationX >= maxWidth || newLocationX <= 0 || newLocationY >= maxHeight || newLocationY <= 0) {
        	super.setHeading(super.getHeading() + 180);
        }
    }
	
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		//x and y are set to the locatoin + the offset
		int x = (int) ((int) ( getLocation().getX() - (getSize() / 2) ) + pCmpRelPrnt.getX()) ;
		int y = (int) ((int) ( getLocation().getY() - (getSize() / 2) ) +  pCmpRelPrnt.getY());
		
		//creates a rectabgle and fills the color for the and which is red
		g.setColor(this.getColor());
		g.drawArc(x, y, this.getSize(), this.getSize(), 0, 360);
		g.fillArc(x, y, getSize(), getSize(), 0, 360);
	}
	
	
	public void handleCollision(GameObject otherObject, GameWorld gw) {
		if(otherObject instanceof FoodStations) {
			System.out.println("collide with foodstaion");
			if(this.getCollide().contains(otherObject) == false) {
				gw.foodStationCollision((FoodStations) otherObject);
				this.getCollide().add(otherObject);
			}
		} else if (otherObject instanceof Flags) {
			System.out.println("collide with flag");
			
			if(this.getCollide().contains(otherObject) == false) {
				gw.flagCollision(((Flags)otherObject).getSequenceNumber());
				this.getCollide().add(otherObject);
			}
		}else if (otherObject instanceof Spiders) {
			System.out.println("collide with spider");
			
			if(this.getCollide().contains(otherObject) == false) {
				gw.spiderCollision((Spiders) otherObject);
				this.getCollide().add(otherObject);
			}
		}
	}
	
	public boolean collidesWith(GameObject otherObject) {
		System.out.println("collision");
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
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String superval = super.toString() + " maxSpeed=" + getMaximumSpeed()  + " foodConsumptionRate=" + getFoodConsumptionRate(); 
		return "Ant " + superval;
	}

	

	
}
