package myStuff;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;



public class CatalogScreen extends FullFunctionScreen {

	private TextField mainField;

	private TextField descriptionField;
	private TextField nameField;
	private TextField priceField;
	
	private Button add;
	
	
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		descriptionField = new TextField(40,40,200,30,"Text Goes Here","description");
		viewObjects.add(descriptionField);
		
		nameField = new TextField(140,40,200,30,"Text Goes Here","name");
		viewObjects.add(nameField);
		
		priceField = new TextField(240,40,200,30,"Text Goes Here","price");
		viewObjects.add(priceField);
		
		add = new Button(300, 300, 100, 100, "click here to buy", new Action() {

			@Override
			public void act() {
				descriptionField.setText("Hello");
			}
			
		});
	}

}
