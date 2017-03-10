/*
 * Name: GameObjects
 * Beschreibung: Explaination
 * 
 * 
*/

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GameObject {
	
	private double x;
	private double y;
	private double width;
	private double height;
	private List<Double> startSize;
	private Color color;
	private Color startcolor;
	private boolean visible;

	/**
	 * the GameObject constructor which is storing basic information about each GameObject.
	 * this information can later be used by other methods to draw these objects or do
	 * basic calculations with the parameters (like collision checks).
	 * Also it creates an ArrayList which contains the starting size for each Object (later
	 * used to reset it to whatever we invoked it with)
	 * @param x
	 * the x coordinate
	 * @param y
	 * the y coordinate
	 * @param w
	 * the width in pixels
	 * @param h
	 * the height in pixels
	 * @param color
	 * the color of the object
	 * */
	public GameObject(double x, double y, double w, double h, Color color) {
		this.setX(x);
		this.setY(y);
		this.setWidth(w);
		this.setHeight(h);
		this.startSize = new ArrayList<Double>() {{
		    add(x);
		    add(y);
		    add(w);
		    add(h);
		}};
		this.setVisible(true);
		this.setColor(color);
		this.startcolor = color;
	}

	/**
	 * variation of the constructor using a default color of black
	 * */
	public GameObject(double x, double y, double w, double h) {
		this(x, y, w, h, Color.BLACK);
	}
	
	/**
	 * the GameObjects update method
	 * this can be empty because we are overriding it anyways accordingly to
	 * what we need at the moment / in every method this is called
	 * */
	public void update() {
	}

	/**
	 * the reset of the GameObject to its starting positions
	 * */
	public void reset() {
		this.setX(startSize.get(0));
		this.setY(startSize.get(1));
		this.setWidth(startSize.get(2));
		this.setHeight(startSize.get(3));
		this.setColor(startcolor);
		this.setVisible(true);
	}

	/**
	 * getter and setter for the GameObject.
	 * they are returning the coordinates, width, height,
	 * color and a boolean to check whether the object should
	 * be visible or not
	 * */
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visibile) {
		this.visible = visibile;
	}
}
