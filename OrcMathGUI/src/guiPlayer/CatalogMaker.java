
package guiPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogMaker {

	private ArrayList<Apartments> catalog;

	public CatalogMaker() {
		catalog = new ArrayList<Apartments>();
		catalog.add(new Apartments("West End Apartments", "104 St" , "Manhattan Valley", 1000000));
		catalog.add(new Apartments("West End Apartments", "104 St" , "Manhattan Valley", 1000000));

	}

	public static void main(String[] args) {
		CatalogMaker c = new CatalogMaker();
		System.out.println(c.getCSVContent());
		Scanner in = new Scanner(System.in); 
		c.saveContent("apartments.csv");
	}



	public String getCSVContent() {
		String data = "name,description,amount,neighborhood,price\n";

		for(Apartments t : catalog) {
			data += t + "\n";
		}
		return data;
	}

	public void addNewItem(String name, String address, String neighborhood, int price){
		this.catalog.add(new Apartments(name, address, neighborhood, price));
		System.out.println("Added successfully");
	}

	private void saveContent(String fileName) {
		try{    
			FileWriter fw=new FileWriter(fileName);   
			for(Apartments a:catalog) {
				fw.write(a + "\n");    
			}
			fw.close();    
			System.out.println("Success! File \""+fileName+"\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}

	}

	private void testFileLoading() {
		Scanner in = new Scanner(System.in);
		String fileName = "";
		List<String> content = new ArrayList<String>();
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){
			try {
				System.out.println("Enter a file to open");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read teh file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {



					String[] param = line.split(",");

					/*
					 * useful later:
					 * split only a comma that has an even number of quotes ahead of it
	 String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					 */
				}

				br.close();
				opened = true;
			}catch (IOException e) {
				System.out.println("The file name you specified does not exist.");
			}
		}

	}
	
	public ArrayList<Apartments> getCatalog() {
		return catalog;
	}
}