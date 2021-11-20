package com.mycompany.a2;

import java.util.Random;



public class Spiders extends Moveable{
	
	
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
		super.setLocation(rand.nextFloat() *1000 , rand.nextFloat() *1000);
		super.setSpeed(rand.nextInt(10) + 5);
		super.setHeading(rand.nextInt(359));
	}
	
	

	
	
	/**
	 * Move will cause the spider to move. since the spider is not controlled by the player 
	 * a random heading is assigned to the spider to make it 
	 */
	@Override
	public void move(double maxWidth, double maxHeight) {
		double theta;
		float x = super.getLocation().getX();
		float y = super.getLocation().getY();
		float deltaX;
		float deltaY;
		
		Random rand = new Random();
        theta = Math.toRadians(90 - super.getHeading());

        deltaX = (float) (Math.cos(theta) * super.getSpeed());
        deltaY = (float) (Math.sin(theta) * super.getSpeed());
        
        float newLocationX = x + deltaX;
        float newLocationY = y + deltaY;
        
        if(newLocationX >= maxWidth || newLocationX <= 0 || newLocationY >= maxHeight || newLocationY <= 0) {
        	return;
        }else {
        	super.setLocation(newLocationX, newLocationY);
        	super.setHeading(getHeading() + rand.nextInt(5));
        	
        }
		
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

}
