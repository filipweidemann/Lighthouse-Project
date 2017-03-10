/*
 * Name: Player
 * Beschreibung: Spieler
 * 
 * 
*/

import java.awt.Color;

public class Player extends GameObject {

	public static double jumpHeight = 5.0;
	private boolean jump;

	/**
     * the Player's constructor which (basically) just generates a usual
     * GameObject (see class extension of GameObject) by calling the super constructor.
     * However, its color is always red and this is important because we later check
     * the instance of each GameObject by using the instanceof operator so we can
     * treat Player and Obstacle objects in different ways, even though they are stored
     * in just one list
     * @param x
     * the x coordinate
     * @param y
     * the y coordinate
     * @param w
     * the width in pixels
     * @param h
     * the height in pixels
     * */
	public Player(double x, double y, double w, double h) {
		super(x, y, w, h, Color.RED);
		jump = false;
	}

	/**
     * a no argument contructor which generates a default player object
     * */
	public Player() {
		this(6.0, 0.0, 2.0, 8.0);
	}

	/**
     * updates the players y-position whenever the jump boolean
     * is set to true. The player is not allowed to scroll to the sides,
     * so this update only deals with the y-positioning
     * */
	@Override
	public void update(){
		double speed = 0.05*(1.0+jumpHeight-getY());
		if (jump) {
			setY(getY()+speed);
			jump = (getY() <= jumpHeight);
		} else if (getY() > 0) {
			setY(getY()-speed);
			if (getY() < 0) {setY(0);}
		}
	}

	/**
     * the jump method which takes in a bool (or the call if the player
     * should jump or not) and sets its jump-boolean accordingly.
     * However, the bool is only set to true (or the player can only trigger a jump)
     * when he is currently on the ground (see if statement)
     * */
	public void jump(boolean bool) {
		if (getY() == 0 || !bool) {
			jump = bool;
		}
	}


	/**
     * Slightly customized jump method, this time for crouching.
     * Works like the jump, should be clear..
     * */
	public void crouch(boolean bool) {
		if (!bool && getY() == -(4.0)) {
			setY(0);
		} else if(bool && getY() <= 0) {
			setY(-(4.0));
		}
	}
}
