package simon;

import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressAchilles extends Component implements ProgressInterfaceAchilles{

	private boolean isGameOver = false;
	
	public ProgressAchilles(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void gameOver() {
	
	}

	@Override
	public void update(Graphics2D g) {
		if(isGameOver) {
			gameOver();
		}else {
			
		}
	}

	@Override
	public int setRound() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setSequenceSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
