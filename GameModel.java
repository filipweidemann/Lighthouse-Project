////////////////////////////////////////////////////
// Name: GameModel
// Beschreibung: Hier werden alle Gameobjects erstellt
// und verwaltet.
// 
//////////////////////////////////////////////////////


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameModel {
	private List<GameView> views;
	private List<GameObject> objects;
	private Player player;
	private Obstacles obstacle;

	
	public GameModel () {
		views = new ArrayList<>();
		objects = new ArrayList<>();
		
		player = new Player();
        // Player player2 = new Player(14.0/28, 0.0, 2.0/28, 8.0/14);
        // objects.add(player2);
        objects.add(player);
		obstacle = new Obstacles();
		objects.add(obstacle);
	}

	
	public List<GameObject> getObjects () {
		return this.objects;
	}
	
	public void addView(GameView view) { //add a Observer
		views.add(view);
		view.setModel(this);
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