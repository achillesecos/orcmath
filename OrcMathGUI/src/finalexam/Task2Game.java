 package finalexam;

import guiTeacher.GUIApplication;

public class Task2Game extends GUIApplication {

	public static Task2Screen t;
	public static Task2Game game;
	
	public Task2Game(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		Task2Game game = new Task2Game(500,500);
		Thread start = new Thread(game);
		start.start();
	}
	
	@Override
	public void initScreen() {
		t = new Task2Screen(getWidth(), getHeight());
		setScreen(t);
	}

	
	
	
}