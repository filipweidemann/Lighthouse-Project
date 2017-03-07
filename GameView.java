
//////////////////////////////////////////////////
// Name: GameView
// Beschreibung: F��r die Anzeige zust��ndig
// 
// 
//////////////////////////////////////////////////////

import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameView extends JPanel {

    public double round2Decimal(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }

	private JFrame window;
    private int playerX, playerY, playerW, playerH;
    private int obstacleX, obstacleY, obstacleW, obstacleH;
	private GameModel model;
	private List<GameObject> playerObjects;
	private List<GameObject> obstacleObjects;
	public int width, height;


	public GameView(int width, int height) {
		window = new JFrame();
		window.setTitle("Lighthouse Project Window");
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.add(this);
		window.setVisible(true);
		
		/////// Das geht noch nicht richtig:
		window.setSize(width, height);
		window.getContentPane().setSize(new Dimension(width, height));
		this.setSize(window.getContentPane().getSize());
		///////
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		// playerObjects = new ArrayList<>();
		
		obstacleObjects = new ArrayList<>();

		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				repaint();
			}
		};

		Timer timer = new Timer("myTimer");
		timer.schedule(timerTask, 0, 1);
	}

	public GameView() {
		this(100, 200);
	}

	public JFrame getFrame() {
		return this.window;
	}

	// Hier drin ist die Kollision,
    // und Player/Hindernisse sind unterschiedlich gefärbt ;)
    // außerdem ist die update-methode der Hindernisse etwas überarbeitet,
    // damit es random die Hindernisse generiert

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (GameObject player : model.getObjects()) {
			if(player instanceof Player) {

				// Übertragen der aktuellen Playerkoordinaten
				if(this.getWidth() == 28){
					playerX = (int) (player.getX() * this.getWidth());
					playerY = (int) (-(player.getY() * this.getHeight()));
					playerW = (int) (player.getWidth() * this.getWidth());
					playerH = (int) (-(player.getHeight() * this.getHeight()));
				}

				int x = (int) (player.getX() * this.getWidth());
				int y = (int) ((1 - player.getY()) * this.getHeight());
				int w = (int) (player.getWidth() * this.getWidth());
				int h = (int) ((player.getHeight()) * this.getHeight());

				g.setColor(Color.RED);
				g.fillRect(x, y - h, w, h);

			} else if(player instanceof Obstacles){

                if(this.getWidth() == 28){
                    obstacleX = (int) (player.getX() * this.getWidth());
                    obstacleY = (int) (-(player.getY() * this.getHeight()));
                    obstacleW = (int) (player.getWidth() * this.getWidth());
                    obstacleH = (int) (-(player.getHeight() * this.getHeight()));
                }

				int x = (int) (player.getX() * this.getWidth());
				int y = (int) ((1 - player.getY()) * this.getHeight());
				int w = (int) (player.getWidth() * this.getWidth());
				int h = (int) ((player.getHeight()) * this.getHeight());

				g.setColor(Color.GREEN.darker());
				g.fillRect(x, y - h, w, h);


                // Kollisionsabfrage
                if(this.getWidth() == 28){

                    if(player.getType() == 1){
                        if((playerY + playerH) >= obstacleY){
                            System.out.println("Colliding!");
                        }
                    } else if(player.getType() == 0){
                        if(playerY < (obstacleY + obstacleH)){
                            System.out.println("Colliding!");
                        }
                    }
                }
			}
		}



	}

	public void setModel(GameModel model) {
		this.model = model;
		//playerObjects = model.getObjects();
		//repaint();
	}
	
	public BufferedImage getViewImage() {
		//System.out.println(size());
		BufferedImage bi = new BufferedImage(28, 14, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		this.paint(g);
		return bi;
	}

}