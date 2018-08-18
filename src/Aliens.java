import java.awt.Color;
import java.awt.Graphics;

public class Aliens extends GameObject {

	boolean moveRight;
	boolean moveDown;

	int counter;

	Aliens(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	// ------------------------------------------------//

	public void update() {
		super.update();
		y++;
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		g.drawRect(x, y, width, height);
		
	}
}
