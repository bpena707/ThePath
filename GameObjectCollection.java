package com.mycompany.a3;

import java.util.ArrayList;



public class GameObjectCollection implements ICollection {
	//here is where teh array list is now created and then initialized in the constructor
	private ArrayList <GameObject> gameObjectCollection;
	
	public GameObjectCollection() {
		gameObjectCollection = new ArrayList<GameObject>();
	}
	
	//all of these methods proved a way to add, remove , and clear objects in a polymorphic safe way 
	public void add (GameObject newGameObject) {
		gameObjectCollection.add(newGameObject);
	}
	
	public void remove(GameObject newGameObject) {
		gameObjectCollection.remove(newGameObject);
	}
	
	public void clear() {
		gameObjectCollection.clear();
	}
	
	//here is a subclass for the gameobjectiterator
	//
	public IIterator getIterator() {
		return new GameObjectIterator();
	}
	
	private class GameObjectIterator implements IIterator{
		private int currIndex;
		//wont go past the last index
		public GameObjectIterator() {
			currIndex = -1;
		}
		//looks thorugh the array wihtin its boudns
		public boolean hasNext() {
			if (gameObjectCollection.size () <= 0) return false;
			if(currIndex == gameObjectCollection.size() -1)
				return false;
			return true;
		}
		//increments and get the next index
		public GameObject getNext() {
			currIndex ++;
			return(gameObjectCollection.get(currIndex));
		}
	}

}
