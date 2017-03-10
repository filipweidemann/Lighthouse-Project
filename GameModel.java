/*
 * Name: GameModel
 * Beschreibung: Explaination
 * 
 * 
*/

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameModel {
	private List<GameView> views;
	private List<Screen> screens;
	private Screen startScreen;
	private Screen pauseScreen;
	private Screen gameOverScreen;
	private Screen backScreen;
	private Screen gameScreen;
	private Timer timer;
	private TimerTask timerTask;
	private int timerIsRunning;
	private Player player;

	public GameModel() {
		views = new ArrayList<>();
		screens = new ArrayList<>();

		// Start-Screen, wird am Anfang angezeigt.
		startScreen = new Screen(Screen_dafault.createStart());
		screens.add(startScreen);

		// Pause-Screen, wird beim pausieren angezeigt.
		pauseScreen = new Screen(Screen_dafault.createPause());
		screens.add(pauseScreen);

		// GameOver-Screen, wird beim Fail angezeigt.
		gameOverScreen = new Screen(Screen_dafault.createGameOver());
		screens.add(gameOverScreen);

		// Back-Screen, wird beim Spielen im Hintergrund angezeigt.
		backScreen = new Screen(Screen_dafault.createBackground()) {
			@Override
			public void update() {
				List<GameObject> background = getObjects();
				for (int i = background.size() - 1; i >= 0; i--) {
					if (background.get(i).getWidth() <= 28*2) {
						background.get(i).setWidth((background.get(i).getWidth() + 0.5));
						return;
					}
				}
				Color color = background.get(1).getColor();
				for (GameView view : views) {
					view.setBackground(color);
				}
				int newblue = color.getBlue() - 20;
				int newred = color.getRed() + 10;
				if (newblue < 0) {
					newred = 0;
					newblue = 255;
				}
				for (int i = background.size() - 1; i >= 0; i--) {
					background.get(i).setWidth(0);
					background.get(i).setColor(new Color(newred, color.getGreen(), newblue));
				}
			}
		};
		screens.add(backScreen);

		// Game-Screen, wird beim Spielen angezeigt.
		gameScreen = new Screen();

		player = new Player();
		gameScreen.addObject(player);
		gameScreen.addObject(new Obstacle(30.0, 5.0, 2.0, 9.0));
		gameScreen.addObject(new Obstacle(60.0, 0.0, 2.0, 4.0));
		screens.add(gameScreen);

		reset();

		timer = new Timer("myTimer");
	}

	/**
	 * this method resets the current state of the game,
	 * ensuring that you get a new start / state of the game
	 * whenever the player collides with an obstacle
	 * */
	private void reset() {
		for (Screen screen : screens) {
			screen.reset();
		}
		timerIsRunning = 0;
		for (GameView view : views) {
			view.reset();
		}
		startScreen.setVisible(true);
		update();
	}

	/**
	 * updates all objects currently available on the gameScreen
	 * using a for loop, updates screens and views, and checks if a collision between player
	 * and obstacles is currently happening (using the checkCollision method)
	 * of the Collision class. If objects are colliding, the timer stops,
	 * the current gameScreen is set to invisible and the gameOverScreen
	 * is set to visible.
	 * */
	private void update() {
		for (GameObject gameObject : gameScreen.getObjects()) {
			if (gameObject instanceof Obstacle && Collision.checkCollisionGameObject(player, gameObject)) {
				timerTask.cancel();
				timerIsRunning = 0;
				backScreen.setVisible(false);
				gameScreen.setVisible(false);
				gameOverScreen.setVisible(true);
			}
		}
		for (Screen screen : screens) {
			screen.update();
		}
		for (GameView view : views) {
			view.update(this);
		}
	}

	/**
	 * returns all current GameObjects as a List of GameObjects
	 * this is used by other classes (primarily the GameView) to
	 * get all objects it needs to draw
	 * */
	public List<GameObject> getObjects() {
		List<GameObject> returnList = new ArrayList<>();
		for (Screen screen : screens) {
			if (screen.isVisible()) {
				returnList.addAll(screen.getObjects());
			}
		}
		return returnList;
	}

	/**
	 * Adds a view to the views array and runs the update method on the associated view.
	 * @param view
	 * the view to add to the views array.
	 * */
	public void addView(GameView view) {
		views.add(view);
		view.update(this);
	}

	/**
	 * toggle method for the timer.
	 * this is called whenever you hit the spacebar
	 * (pause the game)
	 * */
	private void togglePause() {
		if (timerIsRunning >= 40) {	//pause geht nur alle 1000 ms.
			timerTask.cancel();
			timerIsRunning = 0;
			backScreen.setVisible(false);
			gameScreen.setVisible(false);
			pauseScreen.setVisible(true);
			update();
		} else if (timerIsRunning == 0) {
			timerTask = new TimerTask() {
				@Override
				public void run() {
					update();
					if (timerIsRunning < 40) {
						timerIsRunning++;
					}
				}
			};
			timer.schedule(timerTask, 0, 25);
			backScreen.setVisible(true);
			gameScreen.setVisible(true);
			pauseScreen.setVisible(false);
		}
	}
	/**
	 * these methods react accordingly
	 * to which key is currently pressed using switch statements, and
	 * run a different set of instructions for specific keys.
	 * the controller parses the keyCode to this method.
	 * @param keyCode
	 * the internal code of each key which is parsed into the method
	 * */
	public void keyPressed(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			if (timerIsRunning > 0) {
				player.jump(true);
			}
			break;
		case KeyEvent.VK_DOWN:
			if (timerIsRunning > 0) {
				player.crouch(true);
			}
			break;
		case KeyEvent.VK_SPACE:
			if (gameOverScreen.isVisible()) {
				timerTask.cancel();
				reset();
			} else if (startScreen.isVisible()) {
				startScreen.setVisible(false);
				togglePause();
			} else {
				togglePause();
			}
			break;
		default:
			break;
		}
	}

	public void keyReleased(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			if (timerIsRunning > 0) {
				player.jump(false);
			}
			break;
		case KeyEvent.VK_DOWN:
			if (timerIsRunning > 0) {
				player.crouch(false);
			}
			break;
		default:
			break;
		}

	}
}