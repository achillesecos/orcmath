package finalPractice;

import guiTeacher.GUIApplication;

public class FinalGame extends GUIApplication {

	public static FinalGame game;
	public static FinalScreen s;
	
	public FinalGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		s = new FinalScreen(getWidth(), getHeight());
		setScreen(s);

	}

	public static void main(String[] args) {
		FinalGame game = new FinalGame(500,500);
		Thread start = new Thread(game);
		start.start();
	}

}
