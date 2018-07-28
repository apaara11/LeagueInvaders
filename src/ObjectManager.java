import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocketship;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Aliens> aliens = new ArrayList<Aliens>();

	ObjectManager(Rocketship object) {
		rocketship = object;

	}

	public void update() {
		rocketship.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
	}

	public void draw(Graphics g) {
		rocketship.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
	}

	public void addProjectile(Projectile object) {
		projectiles.add(object);
	}

	public void addAliens(Aliens object) {
		aliens.add(object);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAliens(new Aliens(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isAlive) {
				projectiles.remove(i);
			}
		}
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isAlive) {
				aliens.remove(i);
			}
		}
	}

	public void checkCollision() {
		for (Aliens a : aliens) {
			if (rocketship.collisionBox.intersects(a.collisionBox)) {
				rocketship.isAlive = false;
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i);
		}
	}

}
