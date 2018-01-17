package finalexam;

import guiTeacher.GUIApplication;

public class TaskGame extends GUIApplication {

	public static TaskScreen t;
	public static TaskGame game;
	
	public TaskGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		TaskGame game = new TaskGame(500,500);
		Thread start = new Thread(game);
		start.start();
	}
	
	@Override
	public void initScreen() {
		t = new TaskScreen(getWidth(), getHeight());
		setScreen(t);
	}

	
	
}
