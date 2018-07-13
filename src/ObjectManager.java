import java.awt.Graphics;

public class ObjectManager {
	Rocketship rocketship;
	
	ObjectManager(Rocketship object){
		rocketship= object;
	}
	
	public void update() {
		rocketship.update();
	}
	
	public void draw(Graphics g) {
		rocketship.draw(g);
	}
}
