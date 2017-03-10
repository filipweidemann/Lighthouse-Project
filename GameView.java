/*
 * Name: GameView
 * Beschreibung: Explaination
 * 
 * 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.List;

public class GameView extends JPanel {
	private JFrame window;

	private GameModel model;

	/**
	 * the constructor of the GameView class. It creates a new GameView using a
	 * title, width, height and a boolean to either use a free ratio of width and height,
	 * or lock it.
	 * @param title
	 * the title of the window
	 * @param width
	 * integer value of the view width
	 * @param height
	 * integer value of the view height
	 * @param fixedRatio
	 * boolean to either allow a free width/height ratio or lock it
	 * */
	public GameView(String title, int width, int height, boolean fixedRatio) {
		super(true);
		window = new JFrame(title);
		if(fixedRatio) {
			window.addComponentListener(new ComponentAdapter() {
	            @Override
	            public void componentResized(ComponentEvent e) {
	            	int paneWidth = window.getContentPane().getWidth();
	            	int windowWidth = window.getWidth();
	            	int borderWidth = windowWidth-paneWidth;
	            	int paneHeight = window.getContentPane().getHeight();
	            	int windowHeight = window.getHeight();
	            	int borderHeight = windowHeight-paneHeight;
	            	int stretchFactor = 1;
	        		if (window.getWidth() >= window.getHeight()*3) {
	        			stretchFactor = 2;
	        		}
	            	int factor = (paneWidth-(28*stretchFactor))/(28*stretchFactor)+1;
	            	Dimension dim = new Dimension(factor*28*stretchFactor+borderWidth, factor*14+borderHeight);
	            	if (!dim.equals(window.getSize())) {           		
	            		window.setPreferredSize(dim);
	            		window.pack();
	            	}
	            }
	        });
		}
		window.add(this);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		window.setPreferredSize(new Dimension(width, height));
		window.pack();
		
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.requestFocusInWindow();
	}

	/**
	 * a variation of the default GameView constructor.
	 * whenever you call this one, the fixedRatio boolean is set to
	 * false by default.
	 *@param title
	 * the title of the window
	 * @param width
	 * integer value of the view width
	 * @param height
	 * integer value of the view height
	 * */
	public GameView(String title, int width, int height) {
		this(title, width, height, false);
	}

	/**
	 * returns the active JFrame of this view
	 * */
	public JFrame getFrame() {
		return this.window;
	}

	/**
	 * the overridden paint function of the jframe;
	 * it gets every GameObject it needs to draw using the
	 * getObjects() method from the GameModel and creates
	 * a rectangle for every object using a for loop to iterate
	 * through the list.
	 * */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		List<GameObject> objects = model.getObjects();
		int stretchFactor = 1;
		if (this.getWidth() >= this.getHeight()*4) {
			stretchFactor = 2;
		}
		for (GameObject gameObject : objects) {
			if (gameObject.isVisible()) {
				int x = (int) (gameObject.getX() * this.getWidth() / 28)/stretchFactor;
				int y = (int) ((14 - gameObject.getY()) * this.getHeight() / 14);
				int w = (int) (gameObject.getWidth() * this.getWidth() / 28)/stretchFactor;
				int h = (int) ((gameObject.getHeight()) * this.getHeight() / 14);
				g.setColor(gameObject.getColor());
				g.fillRect(x, y - h, w, h);
			}
		}
	}

	/**
	 * updates the currently active model by replacing its state
	 * with the parsed model's state
	 * @param model
	 * the model which is used to replace the current state
	 * */
	public void update(GameModel model) {
		this.model = model;	//thoeretisch können 2 Models auf der Selben view angezeigt werden. 
		repaint();
	}

	/**
	 * reset method for the view, this just sets the
	 * background color to black.
	 * */
	public void reset() {
		this.setBackground(Color.BLACK);
	}

	/**
	 * returns a buffered image of the current view;
	 * this is later used to get all RGB values and parse
	 * the view into the array which is sent to the lighthouse.
	 * */
	public BufferedImage getViewImage() {
		BufferedImage bi = new BufferedImage(28, 14, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		this.paint(g);
		return bi;
	}
}