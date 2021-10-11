package com.mycompany.a1;

import java.util.Random;





/**
 * The Class FoodStations.
 */
public class FoodStations extends Fixed{
	
	
	private int capacity;
	
	/** The rand.  will generate rhe random variables to be used in location 
	 * and size for the food stations
	 * */
	Random rand = new Random();
	
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
		super.setSize(rand.nextInt(20-10) + 10);
		super.setColor(r, g, b);
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
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String superval = super.toString() + " capacity=" + getCapacity();
		return "FoodStations " + superval;

	}
}
