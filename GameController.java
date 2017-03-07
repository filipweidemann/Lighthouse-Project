//////////////////////////////////////////////////
// Name: GameController
// Beschreibung: F��r die Interaktion zust��ndig?
// Schnittstelle zwischen GameView und GameModel?
// 
//////////////////////////////////////////////////////

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class GameController implements KeyListener, ActionListener {
    
	private List<GameModel> models;
	
    public GameController() {
    	models = new ArrayList<>();
    }
	
	public void addView(GameView view) {
		view.addKeyListener(this);
	}
	
	public void addModel(GameModel model) {
		models.add(model);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		for (GameModel gameModel : models) {
			gameModel.keyPressed(keyCode);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
}