////////////////////////////////////////////////////
// Name: GameModel
// Beschreibung: Hier werden alle Gameobjects erstellt
// und verwaltet.
// 
//////////////////////////////////////////////////////


import java.awt.Label;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameModel {
	 private ArrayList<GameObject> objects = new ArrayList<>();
	 private Player player;
	 private Player player2;

	 private Obstacles obstacle;
	
	public GameModel () {
		player = new Player();
        player2 = new Player(7.0/14, 0.0, 1.0/14, 4.0/7);
		obstacle = new Obstacles();

		objects.add(player2);
        objects.add(player);
	}
	
	public ArrayList getObjects () {
		return this.objects;
	}

	public void keyPressed(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			player.jump();
			break;
		case KeyEvent.VK_DOWN:
			player.crouch();
			break;
		default:
			break;
		}
	}	
}