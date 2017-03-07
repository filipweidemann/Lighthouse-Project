////////////////////////////////////////////////////
// Name: Player
// Beschreibung: Der Spieler. 
// 
// 
//////////////////////////////////////////////////////

public class Player extends GameObject {

	public Player(double x, double y, double w, double h) {
		super(x, y, w, h);
	}
	
	public Player() {
		this(4.0/28, 0.0, 2.0/28, 8.0/14);
	}
	
	public void jump() {
		if(this.getY() == 0 || this.getY() == 10.0/28.0) {
			this.setY(10.0/28.0);
		} else {
			this.setY(0);
		}
	}
	
	public void crouch() {
		if(this.getY() == 0 || this.getY() == -(8.0/28.0)) {
			this.setY(-(8.0/28.0));
		} else {
			this.setY(0);
		}
	}
}
