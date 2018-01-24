package finalPractice;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class FinalScreen extends ClickableScreen {

	public Thread count = new Thread();
	public Button theButton;
	public TextArea textbox;
	public TextArea counterText;
	public int score = 0;
	public boolean isTrue = false;
	public boolean counterDone = false;
	
	public FinalScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		textbox = new TextArea(300, 100, 100, 100, "Score: " + score);
	
		counterText =  new TextArea(50, 50, 100, 100, "Countdown");
		
		theButton = new Button(100, 100, 100, 100, "Ready?", Color.BLUE, new Action() {
			public void act() {
				if(isTrue) {
					score++;
					textbox.setText("score: " + score);
				}
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
								counterText.setText("Go");
								theBUtton.setText("click me");
								isTrue = false;
							}
						}
						
						for(int i = 6; i > 0; i--) {
							try {
								Thread.sleep(1000);
							}
							catch(InterruptedException e) {
								e.printStackTrace();
								
							}
							counterText.setText(Integer.toString(i-1));
							if(i == 1) {
								thButton.setText("done");
								isTrue = true;
							}
						}
					}
				});
				
				if(!counterDone) {
					count.start();
					counterDone = true;
				}
			}
		});
		

	}

}