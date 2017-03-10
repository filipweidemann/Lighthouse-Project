/*
 * Name: Screen_default
 * Beschreibung: Enthält vordefinierte Screens
 * 
 * 
*/

import java.awt.Color;
import java.util.ArrayList;

public class Screen_dafault {

		/**
		 * creates an ArrayList of GameObjects.
		 * These individual GameObjects are a preset and print "PAUSE" on the screen
		 * */
		public static ArrayList<GameObject> createPause() {
			ArrayList<GameObject> pauseString = new ArrayList<GameObject>();
			GameObject gobj = new GameObject(0.0, 0.0, 60.0, 14.0, Color.WHITE);
			pauseString.add(gobj);
			//P
			pauseString.add(new GameObject(2.0, 4.0, 1.0, 6.0));
			pauseString.add(new GameObject(5.0 , 7.0 , 1.0 , 4.0 ));
			pauseString.add(new GameObject(2.0, 10.0, 4.0, 1.0));
			pauseString.add(new GameObject(2.0, 7.0, 4.0, 1.0));
			
			//A
			pauseString.add(new GameObject(7.0, 4.0, 1.0, 6.0));
			pauseString.add(new GameObject(10.0, 4.0, 1.0, 6.0));
			pauseString.add(new GameObject(7.0, 10.0, 4.0, 1.0));
			pauseString.add(new GameObject(7.0, 7.0, 3.0, 1.0));
			
			//U
			pauseString.add(new GameObject(12.0, 4.0, 1.0, 7.0));
			pauseString.add(new GameObject(15.0, 4.0, 1.0, 7.0));
			pauseString.add(new GameObject(12.0, 4.0, 3.0, 1.0));
			
			//S
			pauseString.add(new GameObject(17.0, 7.0, 1.0, 4.0));
			pauseString.add(new GameObject(20.0, 4.0, 1.0, 4.0));
			pauseString.add(new GameObject(17.0, 4.0, 4.0, 1.0));
			pauseString.add(new GameObject(17.0, 7.0, 4.0, 1.0));
			pauseString.add(new GameObject(17.0, 10.0, 4.0, 1.0));
			
			//E
			pauseString.add(new GameObject(22.0, 4.0, 1.0, 7.0));
			pauseString.add(new GameObject(22.0, 4.0, 4.0, 1.0));
			pauseString.add(new GameObject(22.0, 7.0, 4.0, 1.0));
			pauseString.add(new GameObject(22.0, 10.0, 4.0, 1.0));
			
			return pauseString;
		}

		/**
		 * creates an ArrayList of GameObjects.
		 * These individual GameObjects are a preset and print "GAME OVER" on the screen
		 * */
		public static ArrayList<GameObject> createGameOver() {
			ArrayList<GameObject> pauseString = new ArrayList<GameObject>();
			GameObject gobj = new GameObject(0.0, 0.0, 60.0, 14.0, Color.WHITE);
			pauseString.add(gobj);
			//G
			pauseString.add(new GameObject(3.0, 7.0, 1.0, 5.0));
			pauseString.add(new GameObject(5.0, 9.0, 2.0, 1.0));
			pauseString.add(new GameObject(3.0, 7.0, 4.0, 1.0));
			pauseString.add(new GameObject(3.0, 11.0, 4.0, 1.0));
			pauseString.add(new GameObject(6.0, 8.0, 1.0, 1.0));
			
			//A
			pauseString.add(new GameObject(8.0, 7.0, 1.0, 5.0));
			pauseString.add(new GameObject(11.0, 7.0, 1.0, 5.0));
			pauseString.add(new GameObject(8.0, 11.0, 4.0, 1.0));
			pauseString.add(new GameObject(8.0, 9.0, 4.0, 1.0));
			
			//M
			pauseString.add(new GameObject(13.0, 7.0, 1.0, 5.0));
			pauseString.add(new GameObject(17.0, 7.0, 1.0, 5.0));
			pauseString.add(new GameObject(13.0, 11.0, 5.0, 1.0));
			pauseString.add(new GameObject(15.0, 9.0, 1.0, 3.0));
			
			//E
			pauseString.add(new GameObject(19.0, 7.0, 1.0, 5.0));
			pauseString.add(new GameObject(19.0, 7.0, 4.0, 1.0));
			pauseString.add(new GameObject(19.0, 9.0, 4.0, 1.0));
			pauseString.add(new GameObject(19.0, 11.0, 4.0, 1.0));
			
			//O
			pauseString.add(new GameObject(3.0, 1.0, 1.0, 5.0));
			pauseString.add(new GameObject(6.0, 1.0, 1.0, 5.0));
			pauseString.add(new GameObject(3.0, 5.0, 4.0, 1.0));
			pauseString.add(new GameObject(3.0, 1.0, 4.0, 1.0));
			
			//V
			pauseString.add(new GameObject(8.0, 3.0, 1.0, 3.0));
			pauseString.add(new GameObject(12.0, 3.0, 1.0, 3.0));
			pauseString.add(new GameObject(9.0, 2.0, 1.0, 1.0));
			pauseString.add(new GameObject(11.0, 2.0, 1.0, 1.0));
			pauseString.add(new GameObject(10.0, 1.0, 1.0, 1.0));
			
			//E
			pauseString.add(new GameObject(14.0, 1.0, 1.0, 5.0));
			pauseString.add(new GameObject(14.0, 1.0, 4.0, 1.0));
			pauseString.add(new GameObject(14.0, 3.0, 4.0, 1.0));
			pauseString.add(new GameObject(14.0, 5.0, 4.0, 1.0));
			
			//R
			pauseString.add(new GameObject(19.0, 1.0, 1.0, 5.0));
			pauseString.add(new GameObject(22.0, 4.0, 1.0, 2.0));
			pauseString.add(new GameObject(22.0, 1.0, 1.0, 2.0));
			pauseString.add(new GameObject(19.0, 3.0, 3.0, 1.0));
			pauseString.add(new GameObject(19.0, 5.0, 3.0, 1.0));
			
			return pauseString;
		}

		/**
		 * creates an ArrayList of GameObjects.
		 * These individual GameObjects are a preset and print "PRESS SPACE" on the screen
		 * */
		public static ArrayList<GameObject> createStart() {
			ArrayList<GameObject> pauseString = new ArrayList<GameObject>();
			GameObject gobj = new GameObject(0.0, 0.0, 60.0, 14.0, Color.WHITE);;
			pauseString.add(gobj);

			//P
			pauseString.add(new GameObject(2.0, 7.0, 1.0, 5.0));
			pauseString.add(new GameObject(4.0, 9.0, 1.0, 3.0));
			pauseString.add(new GameObject(2.0, 9.0, 3.0, 1.0));
			pauseString.add(new GameObject(2.0, 11.0, 3.0, 1.0));
			
			//R
			pauseString.add(new GameObject(7.0, 7.0, 1.0, 5.0));
			pauseString.add(new GameObject(9.0, 7.0, 1.0, 2.0));
			pauseString.add(new GameObject(9.0, 10.0, 1.0, 2.0));
			pauseString.add(new GameObject(7.0, 11.0, 3.0, 1.0));
			pauseString.add(new GameObject(7.0, 9.0, 2.0, 1.0));
			
			//E
			pauseString.add(new GameObject(12.0, 7.0, 1.0, 5.0));
			pauseString.add(new GameObject(12.0, 7.0, 3.0, 1.0));
			pauseString.add(new GameObject(12.0, 9.0, 3.0, 1.0));
			pauseString.add(new GameObject(12.0, 11.0, 3.0, 1.0));
			
			//S
			pauseString.add(new GameObject(17.0, 9.0, 1.0, 3.0));
			pauseString.add(new GameObject(19.0, 7.0, 1.0, 3.0));
			pauseString.add(new GameObject(17.0, 7.0, 3.0, 1.0));
			pauseString.add(new GameObject(17.0, 9.0, 3.0, 1.0));
			pauseString.add(new GameObject(17.0, 11.0, 3.0, 1.0));
			
			//S
			pauseString.add(new GameObject(22.0, 9.0, 1.0, 3.0));
			pauseString.add(new GameObject(24.0, 7.0, 1.0, 3.0));
			pauseString.add(new GameObject(22.0, 7.0, 3.0, 1.0));
			pauseString.add(new GameObject(22.0, 9.0, 3.0, 1.0));
			pauseString.add(new GameObject(22.0, 11.0, 3.0, 1.0));
			
			//S
			pauseString.add(new GameObject(2.0, 3.0, 1.0, 3.0));
			pauseString.add(new GameObject(4.0, 1.0, 1.0, 3.0));
			pauseString.add(new GameObject(2.0, 1.0, 3.0, 1.0));
			pauseString.add(new GameObject(2.0, 3.0, 3.0, 1.0));
			pauseString.add(new GameObject(2.0, 5.0, 3.0, 1.0));
			
			//P
			pauseString.add(new GameObject(7.0, 1.0, 1.0, 5.0));
			pauseString.add(new GameObject(9.0, 3.0, 1.0, 3.0));
			pauseString.add(new GameObject(7.0, 3.0, 3.0, 1.0));
			pauseString.add(new GameObject(7.0, 5.0, 3.0, 1.0));
			
			//A
			pauseString.add(new GameObject(12.0, 1.0, 1.0, 5.0));
			pauseString.add(new GameObject(14.0, 1.0, 1.0, 5.0));
			pauseString.add(new GameObject(12.0, 3.0, 3.0, 1.0));
			pauseString.add(new GameObject(12.0, 5.0, 3.0, 1.0));
			
			//C
			pauseString.add(new GameObject(17.0, 1.0, 1.0, 5.0));
			pauseString.add(new GameObject(17.0, 1.0, 3.0, 1.0));
			pauseString.add(new GameObject(17.0, 5.0, 3.0, 1.0));
			
			//E
			pauseString.add(new GameObject(22.0, 1.0, 1.0, 5.0));
			pauseString.add(new GameObject(22.0, 1.0, 3.0, 1.0));
			pauseString.add(new GameObject(22.0, 3.0, 3.0, 1.0));
			pauseString.add(new GameObject(22.0, 5.0, 3.0, 1.0));

			return pauseString;
		}

		/**
		 * this method constantly updates the background color, line after line.
		 * It does that by creating individual GameObjects with a specific color which
		 * are later painted onto the screen
		 * */
		public static ArrayList<GameObject> createBackground() {
			ArrayList<GameObject> background = new ArrayList<GameObject>();
			
			for (int i = 0; i < 14; i++) {
				GameObject obj = new GameObject(0.0, (double)i, 0.0, 1.0, new Color(0, 75, 255)) {
					@Override
					public void update() {
					}
				};
				background.add(obj);
			}
			
			return background;
		}
}
