package guiPlayer;

import java.awt.Color;


import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Apartments extends Component {
	
	private String name;
	private String address;
	private String neighborhood;
	private int price;

	public Apartments(String name, String address, String neighborhood, int price) {
		super(40,40,387,579);
		this.name = name;
		this.address = address;
		this.neighborhood = neighborhood;
		this.price = price;
		update();
	}
	
	public String toString() {
		return name + ", " + neighborhood + "," + address + ", " + price;
	}

	@Override
	public void update(Graphics2D g) {
		//g.setColor(Color.blue);
		//g.fillRect(0, 0, getWidth(), getHeight());
		//super.update(g);

	}

}
