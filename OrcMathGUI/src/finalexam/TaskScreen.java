package finalexam;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class TaskScreen extends ClickableScreen{

	private Button theButton1;
	private Button theButton2;
	private TextArea textbox;
	private int score = 0;
	
	public TaskScreen(int width, int height) {
		super(width, height);
	}
	

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		theButton1 = new Button(100,100,100,100, "Win", Color.BLUE, new Action() {
			public void act(){
				textbox.setText("You won");
			}
		});
		
		
		
		theButton2 = new Button(100, 300, 100, 100, "Loose", Color.RED, new Action() {
			public void act() {
				textbox.setText("You lost");
			}
		});
		
		textbox = new TextArea(200, 100, 100, 100, "Score is: " + score);
		viewObjects.add(theButton1);
		viewObjects.add(theButton2);
		viewObjects.add(textbox);
		

		
		
	}
		
	
	public void terminateGame() {
		boolean running = true;
		while(running) {
			
		if(textbox.equals("You won")) {
			running = !running;
		}
		}
	}

}
