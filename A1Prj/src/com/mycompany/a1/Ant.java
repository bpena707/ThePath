package com.mycompany.a1;





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
	
	
	/**
	 * Instantiates a new ant.
	 *
	 * @param x the x
	 * @param y the y
	 * @param s the s
	 * @param r the r
	 * @param g the g
	 * @param b the b
	 * @param sp the sp
	 * @param h the h
	 * @param ms the ms
	 * @param fl the fl
	 * @param fcr the fcr
	 * @param hl the hl
	 * @param lfr the lfr
	 */
	public Ant(float x, float y, int s, int r, int g, int b, int sp, int h, int ms, int fl, int fcr, int hl, int lfr) {
		super(x, y, s, r, g, b, sp, h);
		super.setColor(255, 0, 0);
		 maximumSpeed = ms;
		 foodLevel = fl;
		 foodConsumptionRate = fcr;
		 healthLevel = hl;
		 lastFlagReached = lfr; 
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
	public void move(){
		double theta;
		float x = super.getLocation().getX();
		float y = super.getLocation().getY();
		float deltaX;
		float deltaY;
		
		
        theta = Math.toRadians(90 - super.getHeading());

        deltaX = (float) (Math.cos(theta) * super.getSpeed());
        deltaY = (float) (Math.sin(theta) * super.getSpeed());
        
        
        float newLocationX = x + deltaX;
        float newLocationY = y + deltaY;
        
        if(newLocationX >= 0 || newLocationX <= 0 || newLocationY >= 0 || newLocationY <= 0) {
        	super.setLocation(newLocationX, newLocationY);
        }else {
        	return;
        }
        
        


  
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
	
	