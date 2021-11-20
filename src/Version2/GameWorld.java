package com.mycompany.a2;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import com.codename1.charts.models.Point;




/**
 * The Class GameWorld.
 */
public class GameWorld extends Observable{
	private int clock;
	private int lives;
	private boolean sound;
	private GameObjectCollection gameObjectCollection;
	private double width;
	private double height;
	
	/**
	 * Instantiates a new game world.
	 */
	public GameWorld() {
		this.clock = 0;
		this.lives = 3;
		this.sound = false;
		gameObjectCollection = new GameObjectCollection();
		width = 0;
		height = 0;
		
	}
	
	
	public void setHeight(double y) {
		height = y;
	}
	
	public void setWidth(double x) {
		width = x;
	}
	


	/**
	 * Init will create the objects and add them to the array list.
	 */
	public void init() {
		
		//Objects are now added in a polymorphic safe way.
		//since array is no longer directly accesible each object is added as a recognizable gameObjectCollection
		//the first flag is instantiated on its own to allow access to the add and to the Point 
		Flags flag = new Flags(100, 300, 20, 0, 0, 255, 1);
		gameObjectCollection.add(flag);
		gameObjectCollection.add(new Flags(300, 500, 20, 0, 0, 255, 2));
		gameObjectCollection.add(new Flags(600, 700, 20, 0, 0, 255, 3));
		gameObjectCollection.add(new Flags(700, 200, 20, 0, 0, 255, 4));
		
		//ant is accessed and set to the location of the first flag
		Ant ant = Ant.getAnt();
		Point point = flag.getLocation();
		ant.setLocation(point.getX(), point.getY());
		gameObjectCollection.add(ant);
		
		gameObjectCollection.add(new Spiders(1005, 1300, 10, 0, 0, 0, 10, 0));
		gameObjectCollection.add(new Spiders(450, 650, 10, 0, 0, 0, 10, 0));
		
		gameObjectCollection.add(new FoodStations(250, 500, 10, 255, 255, 0));
		gameObjectCollection.add(new FoodStations(600, 550, 10, 255, 255, 0));	
		
		//this will show make the changes according to the invoked game commands
		this.setChanged();
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
	
	public boolean getSound() {
		return sound;
	}

	public void setSound(boolean sound) {
		this.sound = sound;
		this.setChanged();
	}
	
	/**
	 * Check lives.
	 */
	public void checkLives() {
		lives--;
		Ant ant = Ant.getAnt();
		if(lives <= 0) {
			System.out.println("Game over, you Failed!");//added new message when the Game is over!
			System.exit(0);
		}else {
			
			gameObjectCollection.clear();
			ant.clear();
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
		Ant ant = Ant.getAnt();
				ant.accelerate();
				System.out.println("Ant accelerated");
				this.setChanged();
			}

	/**
	 * Brake.
	 */
	public void brake() { 
		Ant ant = Ant.getAnt();
				ant.brake();
				System.out.println("Ant braked");
				this.setChanged();
	     	} 	
	

	/**
	 * Turn left.
	 */
	public void turnLeft() {
		Ant ant = Ant.getAnt();
		    	 ant.turnLeft();
		    	 System.out.println("Ant turned left");
		    	 this.setChanged();
	     	} 	
	
	
	/**
	 * Turn right.
	 */
	public void turnRight() {
		Ant ant = Ant.getAnt();
		    	 ant.turnRight();
		    	 System.out.println("Ant turned right");
		    	 this.setChanged();
	     	} 	
	


	/**
	 * Food station collision will cause food level of the ant and the capacity of the 
	 * food station to add up. then the food stations capacity is drained and set to the color black
	 * showing that its used up. the break is so that it only checks one food station at a time
	 * rather than looping and using both. 
	 */
	public void foodStationCollision() {
		
		 IIterator gameObjectIterator = gameObjectCollection.getIterator();
		 Ant ant = Ant.getAnt();
		
		 int capacity = 0;

			while(gameObjectIterator.hasNext()) {
				GameObject obj = (GameObject) gameObjectIterator.getNext();
				if (obj instanceof FoodStations) {
					FoodStations food = (FoodStations) obj;
		
		    	 if(food.isEmpty() != true) {
		    	 	capacity = food.getCapacity();   		 
		    	 	food.setCapacity(0);
		    	 	food.setColor(0,0,0);
		    	 	ant.setFoodLevel(ant.getFoodLevel() + capacity);
		    	 	System.out.println("Collided with Food Station");
		    	 	this.setChanged();
		    	 	return;
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
		IIterator gameObjectIterator = gameObjectCollection.getIterator();
		Ant ant = Ant.getAnt();

		while(gameObjectIterator.hasNext()) {
			GameObject obj = (GameObject) gameObjectIterator.getNext();
			if (obj instanceof Spiders) {
				Spiders spider = (Spiders) obj;
				//ant now fades when whem collisioin occurs unlike before in A1
				ant.setHealthLevel(ant.getHealthLevel() - 5);
				ant.setSpeed(ant.getSpeed() - 5);
				ant.setColor(205,92,92);
				gameObjectCollection.remove(spider);
				gameObjectCollection.add(spider);
				//spider is instantiaed with x and y values however 
				//spider overrides this and sets a random location
				//refer to the constructor in the spider class to this 
				spider  = new Spiders(500, 450, 10, 0, 0, 0, 10, 0);
				System.out.println("Collided with Spider");
				boolean isalive = ant.isAlive();
				if(isalive == false){
					checkLives();
				
				
				this.setChanged();
				return;
						}
	     			} 
				}	
			}
		
		
			
		

	/**
	 * Maps out all of the toStrings for the classes to the console to see the state of the game
	 */
	public void map() {
		IIterator gameObjectIterator = gameObjectCollection.getIterator();
		
		while(gameObjectIterator.hasNext()) {
			GameObject obj = (GameObject) gameObjectIterator.getNext();
			System.out.println(obj.toString());
			this.setChanged();
			
		}
		
	}

	/**
	 * Game clock tick will make the ant and the spider move. ants health decreases by the factor of the 
	 * food consumption rate. since food level is decreasing every time the ant moves 
	 * we must check to make sure the ant is still alive because if food level is 0 a life is lost
	 * also increments the time on the clock
	 */
	public void gameClockTick() {
		Ant ant = Ant.getAnt();
		ant.move(this.width, this.height);
		IIterator gameObjectIterator = gameObjectCollection.getIterator();
		
		
	
	    	while(gameObjectIterator.hasNext()) {
				GameObject obj = (GameObject) gameObjectIterator.getNext();
				if (obj instanceof Spiders) {
					ant.setFoodLevel(ant.getFoodLevel() - ant.getFoodConsumptionRate());
					Spiders spider = (Spiders) obj;
					spider.move(this.width, this.height);
	     		}
			}
		clock ++;
		System.out.println("Clock has ticked");
		boolean isalive = ant.isAlive();
		if(isalive == false){
			checkLives();
			
			this.setChanged();
			}
		}

	/**
	 * Displays the status of the ant and the clock to the console
	 */
	public void display() {
		Ant ant = Ant.getAnt();
		
	 
	    	 System.out.println("Lives: " + this.lives + " Elapsed time: " + this.clock + "  Highest flag reached: " + ant.getLastFlagReached() + " Food level: " + ant.getFoodLevel() + " Ant health: " + ant.getHealthLevel());
	    	 this.setChanged();
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
	public void flagCollision(int flagNumber) {
	    
		Ant ant = Ant.getAnt();
		if(flagNumber == ant.getLastFlagReached() + 1) {
			ant.setLastFlagReached(flagNumber);
			System.out.println("Flag Collision occured");
		}
		

		this.setChanged();
	        }
	
	
	




	/**
	 * Exit the simulator
	 */
//	public void exit() {
//	
//		System.exit(0);
//		
//		
//	}

	
}