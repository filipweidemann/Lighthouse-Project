//////////////////////////////////////////////////////
// Name: GameObjects
// Beschreibung: Alle Objecte (Hinderniss, Spieler etc.)
// sind Unterklassen von GameObjects
// 
//////////////////////////////////////////////////////


public class GameObject {
	
	private double x;
	private double y;
	private double width;
	private double height;
	
	public GameObject(double x, double y, double w, double h) {
		this.setX(x);
		this.setY(y);
		this.setWidth(w);
		this.setHeight(h);
	}

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
}
