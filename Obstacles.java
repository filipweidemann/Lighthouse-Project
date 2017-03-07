import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

////////////////////////////////////////////////////
// Name: Obstacles
// Beschreibung: Die Hinternisse. 
// 
// 
//////////////////////////////////////////////////////


public class Obstacles extends GameObject {

	public int varPeriod = 25;
	public int counter = 0;

	public Obstacles() {
		super(30.0/28, 6.0/14, 2.0/28, 8.0/14);
		Obstacles.super.setType(1);
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				Random rand = new Random();
				int n = rand.nextInt(2);
				//System.out.println(n);
				if(Obstacles.super.getX() < -getWidth()){
					Obstacles.super.setX(30.0/28.0);
					if(n == 0){
						Obstacles.super.setY(6.0/14);
						Obstacles.super.setHeight(8.0/14);
						Obstacles.super.setType(1);
					} else {
						Obstacles.super.setY(0);
						Obstacles.super.setHeight(4.0/14);
						Obstacles.super.setType(0);
					}
				} else {
					moveObstacle();
				}

			}
		};
		Timer timer = new Timer("myTimer");
		timer.schedule(timerTask, 0, varPeriod);

	}


	private void moveObstacle(){
		this.setX(getX()-0.01);
	}

}
