
/*
 * Name: GameController
 * Beschreibung: Explaination
 * 
 * 
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class GameController implements KeyListener, ActionListener {

	private List<GameModel> models;

	/**
	 * constrcutor of the GameController;
	 * creates a new ArrayList which later holds all models
	 * */
	public GameController() {
		models = new ArrayList<>();
	}

	/**
	 * adds a view to the Controller and
	 * adds the KeyListeners implemented in the GameModel to the
	 * view of the game.
	 * @param view
	 * the view to which the KeyListeners are getting added to
	 * */
	public void addView(GameView view) {
		view.addKeyListener(this);
	}

	/**
	 * adds a GameModel to the the GameController's array
	 * of models
	 * @param model
	 * the model to add
	 * */
	public void addModel(GameModel model) {
		models.add(model);
	}

	/**
	 * the implemented KeyListener events;
	 * these all need to be added because of the implements keyword
	 * in the class declaration (simpler: because the KeyListeners need
	 * to be implemented).
	 * this is called for each GameModel and returns a keyCode
	 * which is later used in the GameModel's class which has implemented
	 * methods that react and do different actions for each key tap.
	 * @param e
	 * the KeyEvent which is used to extract the keyCode value
	 * */
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		for (GameModel gameModel : models) {
			gameModel.keyPressed(keyCode);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		for (GameModel gameModel : models) {
			gameModel.keyReleased(keyCode);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}