////////////////////////////////////////////////////
// Name: Player
// Beschreibung: Der Spieler. 
// 
// 
//////////////////////////////////////////////////////

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	public Player() {
		super(3.0/14, 0.0, 1.0/14, 4.0/7);
	}

	public Player(double x, double y, double w, double h) {
		super(x, y, w, h);
	}

	private Rectangle skin;
	
	public void jump() { //public/(default)/protected?
		System.out.println("Jump.");
		if(this.getY() == 0 || this.getY() == 6.0/14.0)
			this.setY(6.0/14.0);
		else
			this.setY(0);
	}
	
	public void crouch() {
		System.out.println("Crouch.");
		if(this.getY() == 0 || this.getY() == -(4.0/14.0))
			this.setY(-(4.0/14.0));
		else
			this.setY(0);

	}
	
	public void repaint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(skin.x, skin.y, skin.width, skin.height);
	}
}
