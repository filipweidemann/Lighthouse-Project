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
	private int type;

	private double lastX, lastY, lastW, lastH;

	public GameObject(double x, double y, double w, double h) {
		this.setX(x);
		this.setY(y);
		this.setWidth(w);
		this.setHeight(h);

		this.lastX = x;
		this.lastY = y;
		this.lastW = w;
		this.lastH = h;
        //System.out.println("Last X: " + lastX + "\n" + "Last Y: " + lastY + "\n" + "Last W: " + lastW + "\n" + "Last H: " + lastH + "\n");
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

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
