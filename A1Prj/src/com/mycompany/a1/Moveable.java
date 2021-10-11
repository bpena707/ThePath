package com.mycompany.a1;




/**
 * The Class Moveable.
 */
public abstract class Moveable extends GameObject{
	private int heading;
	private int speed;
	
	
	
	/**
	 * Instantiates a new moveable.
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
	public Moveable(float x, float y, int s, int r, int g, int b, int sp, int h) {
		super(x, y, s, r, g, b);
		heading  = h;
		speed = sp;
		
	}
	
	
	
	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Gets the heading.
	 *
	 * @return the heading
	 */
	public int getHeading() {
		return heading;
	}
	
	/**
	 * Sets the speed.
	 *
	 * @param s the new speed
	 */
	public void setSpeed(int s) {
		speed = s;
	}
	
	/**
	 * Sets the heading.
	 *
	 * @param h the new heading
	 */
	public void setHeading(int h) {
		heading = h;
	}
	
	
	/**
	 * Move.
	 */
	//no code here but all moveable objects must implement a move method
	public abstract void move();
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return super.toString() + " heading=" + '[' + getHeading() + ']' + "speed=" + '[' + getSpeed() + ']';  
	}

}



