package simon;

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
		// TODO Auto-generated method stub
		
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

	@Override
	public void update(Graphics2D g) {
		if(isGameOver) {
			gameOver();
		}else {
			
		}
		
	}

}
