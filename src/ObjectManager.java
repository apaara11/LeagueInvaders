import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Rocketship rocketship;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	ObjectManager(Rocketship object) {
		rocketship = object;
	}

	public void update() {
		rocketship.update();
		for(int i=0; i<projectiles.size(); i++) {
			projectiles.get(i).update();
		}
	}

	public void draw(Graphics g) {
		rocketship.draw(g);
		for(int i=0; i<projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	public void addProjectile(Projectile object) {
		projectiles.add(object);
	}
}
