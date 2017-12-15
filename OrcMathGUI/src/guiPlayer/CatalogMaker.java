package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {
	
	private ArrayList<Apartments> catalog;
	
	public CatalogMaker() {
		catalog = new ArrayList<Apartments>();
		catalog.add(new Apartments("West End Apartments", "104 St" , "Manhattan Valley", 1000000));
		
	}
	
	public static void main(String[] args) {
		CatalogMaker c = new CatalogMaker();
		System.out.println(c.getCSVContent());
		Scanner in = new Scanner(System.in); 
	}




	public String getCSVContent() {
		String data = "name,description,amount,neighborhood,price\n";
	
		for(Apartments t : catalog) {
			data += t + "\n";
		}
		return data;
	}
	
	public void addNewItem(String name, String address, String neighborhood, int price){
		this.add(name, address, neighborhood, price);
		System.out.println("Added successfully");
	}
}
