package com.mycompany.a2;

public interface ICollection {
	//add with parameters to be able to add gameobjects on the array when needed
	public void add(GameObject newGameObject);
	public IIterator getIterator();

}
