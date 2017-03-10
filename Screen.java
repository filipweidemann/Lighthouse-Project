/*
 * Name: Screen
 * Beschreibung: Eine Collection von GameObject's. (Sowas wie ein Canvas.)
 * 
 * 
*/

import java.util.ArrayList;
import java.util.List;

public class Screen {
	
	private List<GameObject> objects;
	private boolean visible;

	/**
	 * no argument screen constructor;
	 * it creates a new ArrayList of objects and sets
	 * itself to invisible
	 * */
	public Screen() {
		objects = new ArrayList<>();
		setVisible(false);
	}

	/**
	 * screen constructor which gets a list of objects and
	 * adds them to its objects ArrayList
	 * */
	public Screen(List<GameObject> objects) {
		this();
		addObject(objects);
	}

	/**
	 * update method which iterates through the objects ArrayList, gets
	 * all GameObjects and calls their individual update methods!
	 * */
	public void update() {
		for (GameObject gameObject : objects) {
			gameObject.update();
		}
	}

	/**
	 * resets each GameObject and sets the screen to invisible
	 * */
	public void reset() {
		setVisible(false);
		for (GameObject gameObject : objects) {
			gameObject.reset();
		}
	}

	/**
	 * the method used to add individual GameObjects to the ArrayList
	 * */
	public void addObject(GameObject gameObject) {
		objects.add(gameObject);
		
	}

	/**
	 * the method used to add Lists of GameObjects to the ArrayList
	 * */
	public void addObject(List<GameObject> objects) {
		for (GameObject gameObject : objects) {
			addObject(gameObject);
		}
	}

	/**
	 * returns the ArrayList of GameObjects currently used by this screen
	 * */
	public List<GameObject> getObjects () {
		return objects;
	}

	/**
	 * returns the boolean to check whether this screen should be visible or not
	 * */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * sets the visibility of the screen to the desired state
	 * @param visibile
	 * boolean to which we set the screens visibility
	 * */
	public void setVisible(boolean visibile) {
		this.visible = visibile;
		for (GameObject gameObject : objects) {
			gameObject.setVisible(visibile);
		}
	}
}