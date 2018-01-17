package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPlayer.CatalogScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
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
	private int testing;
	private static int finalButton = 0;
	//private static Color[] colors;
	//private static boolean userInput;
	
	//private Button button1;
	//private Button button2;
	//private Button button3;
	//private Button button4;
	//private Button button5;
	//private Button button6;
	
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
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < arrayList.size(); i++) {
			if(b != null) {
				b.dim();
				b.getButton();
				b.highlight();
				int sleepTime;
				sleepTime = roundNumber + 2;
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
		for(ButtonInterfaceAchilles b: buttons) {
			viewObjects.add(b);
		}
		progress = getProgress();
		
		textLabel = new TextLabel(50,330,300,40, "SIMON");
		arrayList = new ArrayList<MoveInterfaceAchilles>();
		lastSelectedButton = -1;
		arrayList.add(randomMove());
		arrayList.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(textLabel);
		
		//roundNumber = 0;
		
		/*finalButton = -1; 
		button1 = new Button(20,150,40,40,"", new Action() {
			public void act() {
				
			}
		});
		
		arrayList = new ArrayList<MoveInterfaceAchilles>();
		addMoves(2);
		textLabel = new TextLabel(100,200,250,50, "Round" + roundNumber);
		viewObjects.add(textLabel);
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = getAButton();
			ButtonInterfaceAchilles currentButton = buttons[i];
			Color currentColor = colors[i];
			int currentI = colors[i];
			currentButton.setColor(currentColor);
			currentButton.setX(50);
			currentButton.setY(i*20);
			currentButton.setAction(new Action() {
				
				public void act() {
					if(userInput) {
						Thread flash = new Thread(new Runnable() {
							public void run() {
								currentButton.setColor(currentColor.brighter());
								try {
									Thread.sleep(800);
								}
								catch(InterruptedException e) {
									e.printStackTrace();
								}
								currentButton.setColor(currentColor);
							}
						});
						flash.start();
						if(currentButton == arrayList.get(sequenceIndex).getButton()) {
							sequenceIndex ++;
						}
						else {
							progress.gameOver();
						}
						if(sequenceIndex == arrayList.size()) {
							Thread newRound = new Thread(SimonScreenAchilles.this);
							newRound.start();
						}
					}
				}
			});
			
			
			
			
		*/	
		}
		
		
		
		
		/*
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
		
	}*/

	private MoveInterfaceAchilles randomMove() {
		int bIndex = (int)(Math.random()* buttons.length);
		while(bIndex == lastSelectedButton) {
			bIndex = (int)(Math.random()*buttons.length);
		}
		return getMove(bIndex);
	}

	private MoveInterfaceAchilles getMove(int bIndex) {
		return new MoveJi(buttons[bIndex]);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/

	
	
	public void addMoves(int numberOfMoves) {
		for(int i = 0; i < numberOfMoves; i++) {
			int index = (int)(Math.random()*buttons.length);
			if(index == finalButton) {
				i--;
				continue;
			}
			arrayList.add(getMove(index));
		}
	}

	private void addButtons() {
		int numberOfButtons = 5;
		
		buttons = new ButtonInterfaceAchilles[numberOfButtons];
		
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
		return new ButtonAchilles(130, 230, 40, 40, "", Color.blue, null);
	}

	
	private ProgressInterfaceAchilles getProgress() {
		return new ProgressAchilles(10,10,300, 40);
	}
}
