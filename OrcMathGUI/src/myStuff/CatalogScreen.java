package myStuff;

import java.util.List;

import guiPlayer.Apartments;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;



public class CatalogScreen extends FullFunctionScreen {

	private TextField mainField;

	private TextField descriptionField;
	private TextField nameField;
	private TextField neighborhoodField;
	private TextField priceField;
	
	private TextArea textarea;
	
	private Button add;
	
	
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		descriptionField = new TextField(40,40,200,30,"Text Goes Here","description");
		viewObjects.add(descriptionField);
		
		nameField = new TextField(280,40,200,30,"Text Goes Here","name");
		viewObjects.add(nameField);
		
		
		neighborhoodField = new TextField(40, 280, 200, 30, "Text Goes here", "neighborhood");
		
		priceField = new TextField(520,40,200,30,"Text Goes Here","price");
		viewObjects.add(TextField.INPUT_TYPE_NUMERIC);
		
		add = new Button(300, 300, 100, 100, "click here to buy", new Action() {

			@Override
			public void act() {
				descriptionField.setText(addButtonClicked());
			}
			
		});
		viewObjects.add(add);
		
		textarea = new TextArea(300, 300, 200, 80, "Insert text here");
		viewObjects.add(textarea);
	}

	protected String addButtonClicked() {
		
		Apartments a = new Apartments(nameField.getText(), descriptionField.getText(), neighborhoodField.getText(), priceField.parseInt());
		String s = textarea.getText() + a + "\n";
		textarea.setText(s);
		catalog.getCatalog().add(a);

	}

}
