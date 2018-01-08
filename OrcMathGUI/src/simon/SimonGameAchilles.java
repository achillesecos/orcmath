package simon;

import java.util.ArrayList;

import guiPlayer.CatalogScreen;
import guiTeacher.GUIApplication;
import guiTeacher.components.TextLabel;

public class SimonGameAchilles extends GUIApplication {
	
	private static SimonGameAchilles game;
	private SimonGameAchilles screen;
	
	private TextLabel textLabel;
	private ButtonInterfaceAchilles[] buttonInterface;
	private ProgressInterfaceAchilles progressInterface;
	private ArrayList<MoveInterfaceAchilles> arrayList;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonGameAchilles(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SimonGameAchilles screen = new SimonGameAchilles(getWidth(), getHeight());
	}
	
	public static void main(String args) {
		SimonGameAchilles game = new SimonGameAchilles(500, 500); 
		Thread runner = new Thread(game);
		runner.start();
	}
	
}
