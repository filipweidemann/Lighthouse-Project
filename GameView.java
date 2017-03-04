//////////////////////////////////////////////////
// Name: GameView
// Beschreibung: Für die Anzeige zuständig
// 
// 
//////////////////////////////////////////////////////

import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameView extends JPanel {
	
	private ArrayList<GameObject> playerObject;
    private ArrayList<GameObject> obstacleObjects;
	public int width, height;


    public GameView(){

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter width: ");
        width = reader.nextInt(); // Scans the next token of the input as an int.
        System.out.println("Enter height");
        height = reader.nextInt();

        initForm(width, height);
        playerObject = new ArrayList<>();
        obstacleObjects = new ArrayList<>();
    }

    public void initForm(int width, int height){

        this.setLayout(new FlowLayout());
        this.setBounds(0, 0, width, height);
    }

    @Override
    public void paint(Graphics g){

        // For Player Object
    	for(GameObject player : playerObject){
            super.paint(g);
    		int x = (int) (player.getX()*this.getWidth());
    		int y = (int) ((1-player.getY())*this.getHeight());
    		int w = (int) (player.getWidth()*this.getWidth());
    		int h = (int) ((1-player.getHeight())*this.getHeight());

    		g.setColor(Color.RED);
    		g.drawRect(x, y-h, w, h);
    		g.fillRect(x, y-h, w, h);
		}

        for(GameObject obstacle : obstacleObjects){
            super.paint(g);
            int x = (int) (obstacle.getX()*this.getWidth());
            int y = (int) ((1-obstacle.getY())*this.getHeight());
            int w = (int) (obstacle.getWidth()*this.getWidth());
            int h = (int) ((1-obstacle.getHeight())*this.getHeight());

            g.setColor(Color.GREEN);
            g.drawRect(x, y-h, w, h);
            g.fillRect(x, y-h, w, h);
        }

    }
    
    public void repaintView(Object c){
    	playerObject.clear();
    	obstacleObjects.clear();
    	playerObject.add((GameObject) c);
    	// todo: fix order
    	// DAS HIER IST DAS PROBLEM
        // UEBERSCHREIBT DAS ANDERE ARRAY, SODASS DEREN INHALTE
        // NIE AUFGERUFEN WERDEN!
    	obstacleObjects.add((GameObject) c);
    }

}