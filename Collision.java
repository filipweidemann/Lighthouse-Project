/*
 * Name: Collision
 * Beschreibung: Prüft, ob sich zwei GameObjects überschneiden
 * 
 * 
*/

public class Collision {
	/**
	 * this method can check whether two GameObjects are currently colliding with each other.
	 * it's a slightly modded version of the basic "intersects" method used by the default Java
	 * Rectangles class.
	 * @param plr
	 * the player object
	 * @param obs
	 * the obstacle object
	 * */
	public static boolean checkCollisionGameObject(GameObject plr, GameObject obs){
		if(plr.getWidth()  <= 0 || 
		   plr.getHeight() <= 0 || 
		   obs.getWidth()  <= 0 ||
		   obs.getHeight() <= 0 ){
			return false;
		}
		
		int obsW = (int) (obs.getWidth() + obs.getX());
		int obsH = (int) (obs.getHeight() + obs.getY());
		int plrW = (int) (plr.getWidth() + plr.getX());
		int plrH = (int) (plr.getHeight() + plr.getY());
		
		return ((obsW < obs.getX() || obsW > plr.getX()) &&
				(obsH < obs.getY() || obsH > plr.getY()) &&
				(plrW < plr.getX() || plrW > obs.getX()) &&
				(plrH < plr.getY() || plrH > obs.getY()));
	}
}