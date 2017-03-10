/*
 * Name: Main
 * Beschreibung: Main.
 * 
 * 
*/
/**
 * PROJECT DESCRIPTION
 * This game is using the MVC style, so it uses a seperate view, controller and model to represent the full
 * game. The view is what you see and just knows what it needs to print; there is no logic going on in there, it just prints
 * stuff to its JFrame. The model holds the entire state of the game and checks this state! So, whenever you hit some
 * obstacle, the model will know it and react accordingly. The controller basically tells the model and the view what to to,
 * this involves listening for key inputs etc.
 *
 * The idea behind our implementation is that our game can run without any view attached to it.
 * Everything is basically abstract and can be used without any views involved. Collision checks,
 * updating of the game's state etc is all done without the need of a view.
 * We did that by creating our own datatype, the GameObject, as a own class.
 * Every obstacle and the player are subclasses of this GameObject class and exist with a set x,y coordinate
 * value, a width, a height and a color. Every step of logic is performed using these coordinates only, which means
 * that you can theoretically play the game blind (without a view). Just when the view needs to paint the actual state
 * of the game, we transform these abstract values (specifically they are percentages of the lighthouse's dimension)
 * to a real pixel value which is then used to parse them into a rectangle contructor and painting the game!
 *
 * We decided to set (almost) every variable's visibility to private and rather use some getters and setters, to
 * make our code look cleaner. Also, we are having few static variables or methods, almost all methods are called
 * on an object. The only case we didnt do that is the collision method and the screen methods (createPause, createGameOver)
 * etc.. the reason behind this is that we wanted to wrap them up in own classes because our structure in every other method
 * would be absolutely destroyed if we added them in there.
 * */
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import de.cau.infprogoo.lighthouse.LighthouseNetwork;

public class Main {

	static boolean serverError;

	/**
	 * this method is run to start the game.
	 * it creates a GameController and adds view and model to it!
	 * Also, we create different views, one is freele resizable, the other one has a locked ratio
	 * */
	public static void main(String[] args) {
		GameController gameController = new GameController();

		GameModel gameModel1 = new GameModel();
		gameController.addModel(gameModel1);

		GameView gameView1 = new GameView("Fixed ratio", 560, 280, true);
		gameView1.getFrame().setResizable(true);
		gameController.addView(gameView1);
		gameModel1.addView(gameView1);
		
		GameView gameView3 = new GameView("Free scaleable", 1000, 250, false);
		gameView3.getFrame().setResizable(true);
		gameController.addView(gameView3);
		gameModel1.addView(gameView3);

		connectLighthouse("localhost", 1337, gameController, gameModel1);
	}
	
	/**
	 * Connects a game (GameController+Model) to a Lighthouse View.
	 * @param host
	 * @param port
	 * @param controller
	 * @param model
	 */
	private static void connectLighthouse(String host, int port, GameController controller, GameModel model) {
		LighthouseNetwork lnNetwork = new LighthouseNetwork(host, port);
		try {
			lnNetwork.connect();
		} catch (IOException e1) {
			System.out.println("Error: Lighthouse Server not running.");
			serverError = true;
		}

		/**
		 * we are only crreating the lighthouse view if the server is connected!
		 * otherwise we dont need it, so dont create it! ;)
		 * */
		if (!serverError) {
			GameView gameView2 = new GameView("Lighthouse View", 28, 14, true);
			controller.addView(gameView2);
			model.addView(gameView2);
			
			//gameView2.getFrame().setVisible(false);
			/**
			 * this is the timertask which executes the send method
			 * of the lighthouse object. We do so by iterating through the
			 * buffered image created in the GameView and reading each individual R, G and B
			 * value and passing it into the data array which is then completely sent to the
			 * lighthouse.
			 * */
			TimerTask timerTask = new TimerTask() {
				@Override
				public void run() {
					
					BufferedImage bi = gameView2.getViewImage();
					byte data[] = new byte[1176];
					int k = 0;
					for (int y = 0; y < 14; y++) {
						for (int x = 0; x < 28; x++) {
							Color c = new Color(bi.getRGB(x, y));
							data[k] = (byte) c.getRed();
							data[k + 1] = (byte) c.getGreen();
							data[k + 2] = (byte) c.getBlue();
							k += 3;
						}
					}
					try {
						lnNetwork.send(data);
					} catch (IOException e) {
						System.out.println("Error: Lighthouse Server connection lost.");
						this.cancel();
					}
				}
			};

			/**
             * creating the Timer which executes whatever stands in the timertask every 25 milliseconds!
             * (in this case: sending data to the lighthouse)
             * */
			Timer timer = new Timer("myTimer");
			timer.scheduleAtFixedRate(timerTask, 0, 25);
		}
	}

}