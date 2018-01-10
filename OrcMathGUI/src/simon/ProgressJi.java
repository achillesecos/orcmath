package simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressJi extends Component implements ProgressInterfaceAchilles{

	private boolean isGameOver = false;
	
	public ProgressJi(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameOver() {
		isGameOver = true;
		update();
		
	}


	@Override
	public void update(Graphics2D g) {
		if(isGameOver) {
			g.setColor(Color.red);
		}else {
			g.setColor(Color.green);
		}
		
	}

	@Override
	public int setRound(int round) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setSequenceSize(int size) {
		// TODO Auto-generated method stub
		return 0;
	}

}
