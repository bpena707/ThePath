package com.mycompany.a3;

import java.util.ArrayList;
import java.util.Vector;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public abstract class GameObject implements ICollider, IDrawable{
	
	/** The size. */
	private int size;
	
	/** The location. */
	private Point location;
	
	/** The color. */
	private int color; 
	
	private Vector <GameObject> collideArray;
	
	public abstract boolean collidesWith(GameObject otherObject);
	public abstract void handleCollision(GameObject otherObject, GameWorld gw);
	
	
	
	/**
	 * Instantiates a new game object.
	 *
	 * @param x the x
	 * @param y the y
	 * @param s the s
	 * @param r the r
	 * @param g the g
	 * @param b the b
	 */
	//default constructor 
	public GameObject(float x, float y, int s, int r, int g, int b) {
		collideArray = new Vector<GameObject>();
		size = s;
		color = ColorUtil.rgb(r, g, b);
		location = new Point(x,y);
	}
		

	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	//getters
	
	public Vector <GameObject> getCollide(){
		return collideArray;
	}
	public int getSize() {
		return size;
	}
	

	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Point getLocation() {
		return location;
	}
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public int getColor() {
		return color;
	}
	
	//setters
	
	/**
	 * Sets the size.
	 *
	 * @param s the new size
	 */
	public void setSize(int s) {
		size = s;
	}
	
	
	
	/**
	 * Sets the location.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setLocation(float x, float y) {
		location = new Point(x,y);
	}
	
	/**
	 * Sets the color.
	 *
	 * @param r the r
	 * @param g the g
	 * @param b the b
	 */
	public void setColor(int r, int g, int b){
		color = ColorUtil.rgb(r, g, b);
	}
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return " loc:" + '[' + location.getX() + ',' + location.getY() + ']' + "color=" + '[' + ColorUtil.red(getColor()) + ',' 
				+ ColorUtil.green(getColor()) + ',' + ColorUtil.blue(getColor()) + ']' + "size=" + '[' + getSize() + ']'; 
	}



	
	

}

