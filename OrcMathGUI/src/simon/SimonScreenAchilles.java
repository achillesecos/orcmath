package simon;

import java.awt.Color;
import java.util.List;

import guiPlayer.CatalogScreen;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenAchilles extends ClickableScreen implements Runnable {

	
	private TextLabel;
	private ButtonInterfaceX[];
	private ProgressInterfaceX;
	private ArrayList<MoveInterfaceX>;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequesnceIndex;
	private int lastSelectedButton;
	
	public SimonScreenAchilles(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceAchilles a: buttons){ 
		    viewObjects.add(a); 
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceX>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceAchilles getProgress() { 
	    // TODO Auto-generated method stub 
	    return null; 
	}
	private Object getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		new Color(100, 180, 255);
	}

	public static void main(String args) {
		SimonScreenAchilles screen = new SimonScreenAchilles(500, 500);
	}
	
	public void initScreen() {
		CatalogScreen screen = new CatalogScreen(getWidth(), getHeight());
		setScreen(screen);
	}
}
