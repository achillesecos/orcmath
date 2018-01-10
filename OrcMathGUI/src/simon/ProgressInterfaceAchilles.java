package simon;

import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceAchilles extends Visible {

	public void gameOver();
	public int setRound(int round);
	public int setSequenceSize(int size);
}
