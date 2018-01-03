package simon;

import guiPlayer.CatalogScreen;
import guiTeacher.GUIApplication;

public class SimonGameAchilles extends GUIApplication {

	public SimonGameAchilles(int width, int height) {
		super(width, height);
		Thread runner = new Thread(game);
		runner.start();
	}

	@Override
	public void initScreen() {
		CatalogScreen screen = new CatalogScreen(getWidth(), getHeight());
		setScreen(screen);
	}
	
	public static void main(String args) {
		SimonGameAchilles game = new SimonGameAchilles(500, 500); 
	}
	
}
