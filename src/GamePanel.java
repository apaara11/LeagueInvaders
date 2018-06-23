import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	GameObject object;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		object.update();
	}

	@Override
	public void paintComponent(Graphics g) {
		object.draw(g);
	}

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		object = new GameObject(11, 11, 11, 11);
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("LeagueInvaders+");
	}

}
