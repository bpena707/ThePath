package com.mycompany.a1;

import java.util.ArrayList;
import java.util.Random;




/**
 * The Class GameWorld.
 */
public class GameWorld {
	private int clock;
	private int lives;
	private ArrayList<GameObject> objects;
	


	/**
	 * Init will create the objects and add them to the array list.
	 */
	public void init() {
		
		
		Flags flag1 = new Flags(100, 200, 20, 0, 0, 255, 1);
		Flags flag2 = new Flags(300, 500, 20, 0, 0, 255, 2);
		Flags flag3 = new Flags(600, 700, 20, 0, 0, 255, 3);
		Flags flag4 = new Flags(800, 750, 20, 0, 0, 255, 4);

		
		Ant ant = new Ant(100, 200, 10, 255, 0, 0, 5, 0, 50, 50, 2, 50, 1);
		
		Spiders spider1 = new Spiders(1005, 1300, 10, 0, 0, 0, 10, 0);
		Spiders spider2 = new Spiders(450, 650, 10, 0, 0, 0, 10, 0);
		
		
		FoodStations food1 = new FoodStations(250, 500, 10, 255, 255, 0);
		
		FoodStations food2 = new FoodStations(600, 550, 10, 255, 255, 0);
		
		
		
		
		
		
		objects.add(flag1);
		objects.add(flag2);
		objects.add(flag3);
		objects.add(flag4);
		objects.add(ant);
		objects.add(spider1);
		objects.add(spider2);
		objects.add(food1);
		objects.add(food2);
		
		
		
	}

	/**
	 * Instantiates a new game world.
	 */
	public GameWorld() {
		this.clock = 0;
		this.lives = 3;
		this.objects = new ArrayList<GameObject>();
		
	}
	
	
	
	
	

	/**
	 * Gets the clock.
	 *
	 * @return the clock
	 */
	public int getClock() {
		return clock;
	}

	/**
	 * Gets the lives.
	 *
	 * @return the lives
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * Sets the clock.
	 *
	 * @param clock the new clock
	 */
	public void setClock(int clock) {
		this.clock = clock;
	}

	/**
	 * Sets the lives.
	 *
	 * @param lives the new lives
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	/**
	 * Check lives.
	 */
	public void checkLives() {
		lives--;
		if(lives <= 0) {
			System.out.println("Game over, you Failed!");//added new message when the Game is over!
			System.exit(0);
		}else {
			objects.clear();
			init();
		}
	}

	
	/**
	 * all of these methodes will use a for loop to look for the first instance of the object in the 
	 * array list and also use a temp variable to access teh functionality in the appropriate classes
	 */


	/**
	 * Accelerate.
	 */
	public void accelerate() {
		for (int i=0; i<objects.size(); i++) {
		     	if (objects.get(i) instanceof Ant) {
		    	 Ant ant = (Ant)objects.get(i);
		    	 ant.accelerate();
		     } 		
		}
	}

	/**
	 * Brake.
	 */
	public void brake() { 
		for (int i=0; i<objects.size(); i++) {
	     	if (objects.get(i) instanceof Ant) {
	    	 Ant ant = (Ant)objects.get(i);
	    	 ant.brake();
	     	} 	
		}
	}

	/**
	 * Turn left.
	 */
	public void turnLeft() {
		for (int i=0; i<objects.size(); i++) {
	     	if (objects.get(i) instanceof Ant) {
	    	 Ant ant = (Ant)objects.get(i);
		    	 ant.turnLeft();
	     	} 	
		}
	}
	
	/**
	 * Turn right.
	 */
	public void turnRight() {
		for (int i=0; i<objects.size(); i++) {
	     	if (objects.get(i) instanceof Ant) {
	    	 Ant ant = (Ant)objects.get(i);
		    	 ant.turnRight();
	     	} 	
		}
	}
		
	    
	

	/**
	 * Food station collision will cause food level of the ant and the capacity of the 
	 * food station to add up. then the food stations capacity is drained and set to the color black
	 * showing that its used up. the break is so that it only checks one food station at a time
	 * rather than looping and using both. 
	 */
	public void foodStationCollision() {
		
		 Ant ant = null;
		 
		 for (int i=0; i<objects.size(); i++) {
		     	if (objects.get(i) instanceof Ant) {
		    	 ant = (Ant)objects.get(i);
		     }
		}
		 for (int i=0; i<objects.size(); i++) {
		     	if (objects.get(i) instanceof FoodStations) {
		    	 FoodStations food = (FoodStations)objects.get(i);
		
		    	 if(food.isEmpty() != true) {
		    	 	int foodLevel = ant.getFoodLevel();
		    	 	int capacity = food.getCapacity();   		 
		    	 	ant.setFoodLevel(capacity + foodLevel);
		    	 	food.setCapacity(0);
		    	 	food.setColor(0,0,0);
		    	 	break;
		     		}else {
		     		}
		     	}
		 
		
			}
		}
	
		
		
		
	    
	    


	
 
	/**
	 * Spider collision will cause the ants health to decrease by one every time and uses the is alive boolean
	 * in the ant class to check if the ant is still alive after the collision. refer to ant class for more details.
	 * the ants color fades removes the spider from the array and adds a new one in which is placed in a random location
	 */
	public void spiderCollision() {
		Ant ant = null;
		
		for (int i=0; i<objects.size(); i++) {
	     	if (objects.get(i) instanceof Ant) {
	    	 ant = (Ant)objects.get(i); 
	    	 
	     	}
		}
		
		for (int i=0; i<objects.size(); i++) {
	     	if (objects.get(i) instanceof Spiders) {
	    	 Spiders spider = (Spiders)objects.get(i);
	    	 
	    	 ant.setHealthLevel(ant.getHealthLevel() - 1);
				boolean isalive = ant.isAlive();
				if(isalive == false){
					checkLives();
					//return;
					
				
			
				ant.setColor(205,92,92);
				objects.remove(spider);
				objects.add(spider);
				spider  = new Spiders(500, 450, 10, 0, 0, 0, 10, 0);
				return;
					}
	     		} 	
			}
		}
		
			
		

	/**
	 * Maps out all of the toStrings for the classes to the console to see the state of the game
	 */
	public void map() {
		for(int i=0; i<objects.size(); i++) {
			System.out.println(objects.get(i).toString());
			
		}
		
	}

	/**
	 * Game clock tick will make the ant and the spider move. ants health decreases by the factor of the 
	 * food consumption rate. since food level is decreasing every time the ant moves 
	 * we must check to make sure the ant is still alive becasue if food level is 0 a life is lost
	 * also increments the time on the clock
	 */
	public void gameClockTick() {
		Ant ant = null;
		for (int i=0; i<objects.size(); i++) {
	     	if (objects.get(i) instanceof Ant) {
	    	 ant = (Ant)objects.get(i); 
	    		ant.move();
	    		ant.setFoodLevel(ant.getFoodLevel() - ant.getFoodConsumptionRate());
	     	}
		}
		for (int i=0; i<objects.size(); i++) {
	     	if (objects.get(i) instanceof Spiders) {	
	    	 Spiders spider = (Spiders)objects.get(i); 
	    	 spider.move();
	     		}
			}
		clock ++;
		boolean isalive = ant.isAlive();
		if(isalive == false){
			checkLives();
			}
		}

	/**
	 * Displays the status of the ant and the clock to the console
	 */
	public void display() {
		Ant ant = null;
		for (int i=0; i<objects.size(); i++) {
	     	if (objects.get(i) instanceof Ant) {
	    	 ant = (Ant)objects.get(i);
	 
	    	 System.out.println("Lives: " + this.lives + " Elapsed time: " + this.clock + "  Highest flag reached: " + ant.getLastFlagReached() + " Food level: " + ant.getFoodLevel() + " Ant health: " + ant.getHealthLevel());
	    	 break;
	     	} 	
		}
		
	}
	
	/**
	 * the flag collisions occur in a sequential order for the the flags 1-4 these check to make sure a flag
	 * cant be reached if the previous flag in the order hasnt been reached yet
	 */
	
	/**
	 * Flag collision 1.
	 *
	 * @param flagNumber the flag number
	 */
	public void flagCollision1(int flagNumber) {
	    
	    // Find the Ant in the objects vector. Update necessary
	    // data members for respective objects.
	    for (int i=0; i<objects.size(); i++) {
	        if (objects.get(i) instanceof Ant) {
	            Ant ant = (Ant) objects.get(i);
	            if(flagNumber == ant.getLastFlagReached() + 1 ) {
	                ant.setLastFlagReached(flagNumber);
	            }
	        }
	    }
	}
	
	/**
	 * Flag collision 2.
	 *
	 * @param flagNumber the flag number
	 */
	public void flagCollision2(int flagNumber) {
	    for (int i=0; i<objects.size(); i++) {
	        if (objects.get(i) instanceof Ant) {
	            Ant ant = (Ant) objects.get(i);
	            if(flagNumber == ant.getLastFlagReached() + 1 ) {
	                ant.setLastFlagReached(flagNumber);
	            }
	        }
	    }
	}
	
	/**
	 * Flag collision 3.
	 *
	 * @param flagNumber the flag number
	 */
	public void flagCollision3(int flagNumber) {
	    for (int i=0; i<objects.size(); i++) {
	        if (objects.get(i) instanceof Ant) {
	            Ant ant = (Ant) objects.get(i);
	            if(flagNumber == ant.getLastFlagReached() + 1 ) {
	                ant.setLastFlagReached(flagNumber);
	            }
	        }
	    }
	}
	
	/**
	 * Flag collision 4.
	 *the game only has 4 flags so after reaching flag 4 the game is over! this will also display the clock and close the console
	 * @param flagNumber the flag number
	 */
	
	public void flagCollision4(int flagNumber) {

	    for (int i=0; i<objects.size(); i++) {
	        if (objects.get(i) instanceof Ant) {
	            Ant ant = (Ant) objects.get(i);
	            if(flagNumber == ant.getLastFlagReached() + 1 ) {
	                ant.setLastFlagReached(flagNumber);
	                System.out.println("Game over, you win!" + " Elapsed Time: " + getClock());
	                System.exit(0);
	            }
	        }
	    }
	}
	
	/**
	 * Flag collision 5.
	 *
	 * @param flagNumber the flag number
	 */
	/*this method will simulate additional flag collisions 5-9 but reaching these will not end the game 
	*since this game only has 4 flags at the moment. 
	*no if statements to check the sequential order at this point since these are irrelevant at the moment
	*since game will exit after the 4th flag is reached.
	*/
	public void flagCollision5(int flagNumber) {

	    for (int i=0; i<objects.size(); i++) {
	        if (objects.get(i) instanceof Ant) {
	            Ant ant = (Ant) objects.get(i);
	                ant.setLastFlagReached(flagNumber);
	            
	        }
	    }
	}
	
	/**
	 * Flag collision 6.
	 *
	 * @param flagNumber the flag number
	 */
	public void flagCollision6(int flagNumber) {

	    for (int i=0; i<objects.size(); i++) {
	        if (objects.get(i) instanceof Ant) {
	            Ant ant = (Ant) objects.get(i);
	           
	                ant.setLastFlagReached(flagNumber);
	       
	        }
	    }
	}
	
	/**
	 * Flag collision 7.
	 *
	 * @param flagNumber the flag number
	 */
	public void flagCollision7(int flagNumber) {

	    for (int i=0; i<objects.size(); i++) {
	        if (objects.get(i) instanceof Ant) {
	            Ant ant = (Ant) objects.get(i);
	            
	                ant.setLastFlagReached(flagNumber);
	            
	        }
	    }
	}
	
	/**
	 * Flag collision 8.
	 *
	 * @param flagNumber the flag number
	 */
	public void flagCollision8(int flagNumber) {

	    for (int i=0; i<objects.size(); i++) {
	        if (objects.get(i) instanceof Ant) {
	            Ant ant = (Ant) objects.get(i);
	            
	                ant.setLastFlagReached(flagNumber);
	            
	        }
	    }
	}
	
	/**
	 * Flag collision 9.
	 *
	 * @param flagNumber the flag number
	 */
	public void flagCollision9(int flagNumber) {

	    for (int i=0; i<objects.size(); i++) {
	        if (objects.get(i) instanceof Ant) {
	            Ant ant = (Ant) objects.get(i);
	            
	                ant.setLastFlagReached(flagNumber);
	            
	        }
	    }
	}
	




	/**
	 * Exit the simulator
	 */
	public void exit() {
	
		System.exit(0);
		
		
	}

	
}
