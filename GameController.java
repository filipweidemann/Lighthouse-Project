//////////////////////////////////////////////////
// Name: GameController
// Beschreibung: Für die Interaktion zuständig?
// Schnittstelle zwischen GameView und GameModel?
// 
//////////////////////////////////////////////////////

import javax.swing.*;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class GameController implements KeyListener, ActionListener {

    private GameModel _model;
    private GameView _view;
    private GameView _view2;
    
    public GameController(){
        this._model = new GameModel();
        this._view = new GameView();
        this._view2 = new GameView();
        _view.addKeyListener(this);
        _view2.addKeyListener(this);

        JFrame window = new JFrame();
        window.setTitle("Lighthouse Project Window 1");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.addKeyListener(this);
        window.add(_view);
        window.setSize(_view.width, _view.height);
        window.setVisible(true);

        JFrame window2 = new JFrame();
        window2.setTitle("Lighthouse Project Window 2");
        window2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window2.addKeyListener(this);
        window2.add(_view2);
        window2.setSize(_view2.width, _view2.height);
        window2.setVisible(true);



        TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				for (Object obj : _model.getObjects()) {
                    _view.repaintView(obj);
                    _view.repaint();
                    _view2.repaintView(obj);
                    _view2.repaint();
                }
			}
		};

		Timer timer = new Timer("myTimer");
		timer.schedule(timerTask, 1000, 30);
		
    }

    public void showView(){
        this._view.setVisible(true);
        this._view2.setVisible(true);
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		_model.keyPressed(keyCode);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}