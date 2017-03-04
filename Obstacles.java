////////////////////////////////////////////////////
// Name: Obstacles
// Beschreibung: Die Hinternisse. 
// 
// 
//////////////////////////////////////////////////////


public class Obstacles extends GameObject {

	public Obstacles() {
		super(0.9, 0.0, 1.0/14, 4.0/7);
	}


	public void moveObstacles(){
		this.setX(getX()-0.01);
	}

}
