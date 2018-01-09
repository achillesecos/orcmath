package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPlayer.CatalogScreen;
import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenAchilles extends ClickableScreen implements Runnable {

	
	private TextLabel textLabel;
	private ButtonInterfaceAchilles[] buttons;
	private ProgressInterfaceAchilles progress;
	private ArrayList<MoveInterfaceAchilles> arrayList;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenAchilles(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		textLabel.setText("");
		nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		
		arrayList.add(randomMove());
		setRound();
		setSequenceSize();
		changeText("Simon's turn");
		textLabel.setText("");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
		
	}

	private int setSequenceSize() {
		return arrayList.size();
	}

	private int setRound() {
		return roundNumber;
	}

	private void changeText(String string) {
		Thread blink = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(800);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void playSequence() {
		ButtonInterfaceAchilles b = null;
		for(int i = 0; i < arrayList.size(); i++) {
			if(b != null) {
				b.dim();
				b.getButton();
				b.highlight();
				int sleepTime;
				sleepTime = roundNumber + 1;
				try{
					Thread.sleep(800);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			b.dim();
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceAchilles a: buttons){ 
		    viewObjects.add(a); 
		}
		progress = getProgress();
		TextLabel label = new TextLabel(130,230,300,40,"Let's play Simon!");
		ArrayList<MoveInterfaceAchilles> sequence = new ArrayList<MoveInterfaceAchilles>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
		
		
		randomMove();
	}

	private MoveInterfaceAchilles randomMove() {
		int bIndex = (int)(Math.random()* buttons.length);
		while(bIndex == lastSelectedButton) {
			bIndex = (int)(Math.random()*buttons.length);
		}
		return getMove(bIndex);
	}

	private MoveInterfaceAchilles getMove(int bIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceAchilles getProgress() { 
	    // TODO Auto-generated method stub 
	    return null; 
	}

	private void addButtons() {
		int numberOfButtons = 5;
		
		buttons = new ButtonInterfaceAchilles[numberOfButtons-1];
		
		Color button1 = Color.blue;
		Color button2 = Color.red;
		Color button3 = Color.orange;
		Color button4 = Color.green;
		Color button5 = Color.black;
		Color button6 = Color.yellow;
		
		for(int i=0; i < numberOfButtons; i++) {
			final ButtonInterfaceAchilles b = getAButton();
			buttons[i] = b;
			
			b.setColor(Color.blue);
			b.setX(3);
			b.setY(4);
			
			b.setAction(new Action() {
				public void act() {
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable() {
							public void run() {
								b.highlight();
								try {
									Thread.sleep(800);
								} catch(InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
					}
				}
			});
			int sequenceIndex = 0;
			if(b == arrayList.get(sequenceIndex).getButton()) {
				sequenceIndex++;
			}
			else {
				progress.gameOver();
			}
			if(sequenceIndex == arrayList.size()) {
				Thread nextRound = new Thread(SimonScreenAchilles.this);
				nextRound.start();
			}
		}
		
		
	}

	private ButtonInterfaceAchilles getAButton() {
		// TODO Auto-generated method stub
		return null;
	}


}
