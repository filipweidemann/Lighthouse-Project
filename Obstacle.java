/*
 * Name: Obstacles
 * Beschreibung: Hindernisse
 * 
 * 
*/

import java.awt.Color;

public class Obstacle extends GameObject {


	/**
	 * obstacle constructor (basically the same as the players constructor).
	 * this uses the GameObjects super constructor as well, using the same parameters
	 * @param x
	 * x coordinate
	 * @param y
	 * y coordinate
	 * @param w
	 * width
	 * @param h
	 * height
	 * @param color
	 * color
	 * */
	public Obstacle(double x, double y, double w, double h, Color color) {
		super(x, y, w, h, color);
	}
	
	public Obstacle(double x, double y, double w, double h) {
		this(x, y, w, h, new Color(100, 200, 100));
	}

	/**
	 * update method of the obstacle;
	 * whenever this is called by the GameModel, the obstacles x-position is slightly decreased
	 * and it therefore scrolls to the left.
	 * when it disappears out of the view (or passes the left boundary of the view) it
	 * replaces itself at either its old starting position or a new position, altering the y-position.
	 * this is determined by Math.random() < 0.5.
	 * so we can get two kinds of obstacles, these from above and from below
	 * */
	@Override
	public void update(){
		this.setX(getX()-0.15);
		if (getX() < -getWidth()) {
			if (Math.random() < 0.5) {
				setX(60.0);
				setY(5.0);
				setWidth(2.0);
				setHeight(9.0);
			} else {
				setX(60.0);
				setY(0);
				setWidth(2.0);
				setHeight(4.0);
			}
		}
	}
}
