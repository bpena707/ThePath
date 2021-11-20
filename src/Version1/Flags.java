package com.mycompany.a1;




/**
 * The Class Flags.
 */
public class Flags extends Fixed {
	private int sequenceNumber;
	
	
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
	
	
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String superval =  super.toString() + " seqNum=" + getSequenceNumber(); 
		return "Flag " + superval;
	}

}
