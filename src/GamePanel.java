import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;

	int currentState = MENU_STATE;

	Font titleFont;
	Font bodyFont;

	Rocketship rocketship;

	ObjectManager objectManager;

	////////////////////////////////// constructor
	GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		bodyFont = new Font("Arial", Font.PLAIN, 32);
		rocketship = new Rocketship(250, 700, 50, 50);
		objectManager = new ObjectManager(rocketship);
	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		objectManager.update();

	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 25, 105);

		g.setColor(Color.YELLOW);
		g.setFont(bodyFont);
		g.drawString("Press ENTER to start", 65, 305);

		g.setColor(Color.YELLOW);
		g.setFont(bodyFont);
		g.drawString("Press space for instructions", 65, 505);

	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		objectManager.draw(g);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 105, 105);

		g.setColor(Color.BLACK);
		g.setFont(bodyFont);
		g.drawString("Press ENTER to restart", 65, 305);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	public void startGame() {
		timer.start();
	}

	// _______________________________________________
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("LeagueInvaders");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("LeagueInvaders");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			objectManager.addProjectile(new Projectile(rocketship.x, rocketship.y, 10, 10));
		}
			
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketship.x -= rocketship.speed;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocketship.x += rocketship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocketship.y -= rocketship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocketship.y += rocketship.speed;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("LeagueInvaders+");
	}

}
