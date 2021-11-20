package com.mycompany.a3;

import com.codename1.charts.models.Point;

import com.codename1.ui.Graphics;

/**
 * The Class Flags.
 */
public class Flags extends Fixed{
	private int sequenceNumber;
	private boolean selected;
	
	
	/**
	 * Instantiates a new flags.
	 *
	 * @param x the x
	 * @param y the y
	 * @param s the s
	 * @param r the r
	 * @param g the g
	 * @param b the b
	 * @param seqnum the seqnum
	 */
	public Flags(float x, float y, int s, int r, int g, int b, int seqnum){
		super(x, y, s, r, g, b);
		super.setColor(0, 0, 255);
		sequenceNumber = seqnum;
		selected = false;
	}
	

	/**
	 * Gets the sequence number.
	 *
	 * @return the sequence number
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * Sets the sequence number.
	 *
	 * @param seqnum the new sequence number
	 */
	public void setSequenceNumber(int seqnum) {
		sequenceNumber = seqnum;
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
//		g.drawPolygon(xPoints, yPoints, nPoints);
		g.drawString("" + this.sequenceNumber, x, y);
		g.setAlpha(100);
		
		if (!isSelected()) {
			g.fillPolygon(xPoints, yPoints, nPoints);
		} else {
			g.drawPolygon(xPoints, yPoints, nPoints);
		}
		g.setAlpha(200);
		
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String superval =  super.toString() + " seqNum=" + getSequenceNumber(); 
		return "Flag " + superval;
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
	public void handleCollision(GameObject otherObject, GameWorld gw) {
		if(this.getCollide().contains(otherObject) == false) {
			
			this.getCollide().add(otherObject);
		}
		
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
