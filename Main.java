
/*
 * Name: Main
 * Beschreibung: Main.
 * 
 * 
*/

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import de.cau.infprogoo.lighthouse.LighthouseNetwork.LighthouseNetwork;

public class Main {

	static boolean serverError;

	public static void main(String[] args) {
		GameController gameController = new GameController();

		GameModel gameModel1 = new GameModel();
		gameController.addModel(gameModel1);

		GameView gameView1 = new GameView(500, 200);
		gameController.addView(gameView1);
		gameModel1.addView(gameView1);

		// Lighthouse:
		LighthouseNetwork lnNetwork = new LighthouseNetwork("localhost", 8000);
		try {
			lnNetwork.connect();
		} catch (IOException e1) {
			System.out.println("Error: Lighthouse Server not running.");
			serverError = true;
		}

		if (!serverError) {
			GameView gameView2 = new GameView(28, 14);
			gameController.addView(gameView2);
			gameModel1.addView(gameView2);
			
			gameView2.getFrame().setVisible(false);	// klappt nicht immer, irgendwie..

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
			Timer timer = new Timer("myTimer");
			timer.scheduleAtFixedRate(timerTask, 0, 25);
		}
	}

}