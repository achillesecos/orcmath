package finalexam;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class Task2Screen extends ClickableScreen{

	private Thread count = new Thread();
	private Button theButton;
	private TextArea textbox;
	private int score = 0;
	private boolean isTrue = false;
	
	private boolean stopCounting;
	
	
	private TextArea counterText;
	
	//private TextArea timer;
	
	private int buttonClickedNums = 0;
	
	public Task2Screen(int width, int height) {
		super(width, height);
	}
	

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		counterText = new TextArea(50, 50, 100, 100, "Countdown");
		
		//timer = new TextArea(200, 200, 50, 50, "");
		
		theButton = new Button(100,100,100,100, "READY?", Color.BLUE, new Action() {
			public void act(){
				Thread count = new Thread(new Runnable() {
					public void run() {
						for(int i = 4; i > 0; i--) {
						try {
							Thread.sleep(1000);
						}
						catch(InterruptedException e) {
							e.printStackTrace();
						}
						
						counterText.setText(Integer.toString(i-1));
						if(i == 1) {
							counterText.setText("GO!");						}
						}
						
					}
				});
				count.start();
				/*
				for(int i = 6; i > 0; i--) {
					try {
						Thread.sleep(1000);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
					counterText.setText(Integer.toString(i-1));
					
					
				}
				*/
			}
		});
		
		
		textbox = new TextArea(200, 100, 100, 100, "Score is: " + score);
		viewObjects.add(theButton);
		viewObjects.add(textbox);
		viewObjects.add(counterText);
		//viewObjects.add(timer);

		
		
	}
		

}