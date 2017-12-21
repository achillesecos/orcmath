package myStuff;

import java.util.List;

import guiTeacher.GUIApplication;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class OpeningScreen extends FullFunctionScreen {

	public OpeningScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Button open = new Button((getWidth() - 100)/2, getHeight() - 40, 100, 30, "Switch", new Action() {
			public void act() {
				
			}
		});
		viewObjects.add(open);
	}

	public static void main(String[] args) {
		CatalogMakerGUI catalog = new CatalogMakerGUI(800, 550);
		Thread runner = new Thread(catalog);
		runner.start();
	}
	
	public void initScreen() {
		CatalogScreen screen = new CatalogScreen(getWidth(), getHeight());
		setScreen(screen);
	}


}
