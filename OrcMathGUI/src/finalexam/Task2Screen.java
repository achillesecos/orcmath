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
	private TextArea counterText;
	private int score = 0;
	private boolean isTrue = false;
	
	private boolean counterDone = false;
	
	
	
	public Task2Screen(int width, int height) {
		super(width, height);
	}
	

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		textbox = new TextArea(300, 100, 100, 100, "Score: " + score);
		
		counterText = new TextArea(50, 50, 100, 100, "Countdown");
		
		
		theButton = new Button(100,100,100,100, "READY?", Color.BLUE, new Action() {
			public void act(){
				
				if(isTrue) {
					score ++;
					textbox.setText("Score: " + score);
				}
				
				Thread count = new Thread(new Runnable() {
					public void run() {
						for(int i = 4; i > 0; i--) {
							try{
								Thread.sleep(1000);
							}
							catch(InterruptedException e){
								e.printStackTrace();
							}
							
							counterText.setText(Integer.toString(i-1));
							if(i == 1) {
								counterText.setText("GO!");
								theButton.setText("Click me");
								isTrue = true;
							}
						}
						for(int i = 6; i > 0; i--){
							try {
								Thread.sleep(1000);
							}
							catch(InterruptedException e){
								e.printStackTrace();
							}
							counterText.setText(Integer.toString(i-1));
							if(i == 1) {
								theButton.setText("Done");
								isTrue = false;
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
		
		
		viewObjects.add(theButton);
		viewObjects.add(textbox);
		viewObjects.add(counterText);
		

		
		
	}
		

}