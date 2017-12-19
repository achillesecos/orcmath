package guiPlayer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InputSave {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your text");
		String input = in.nextLine();
		
		try{    
			FileWriter fw=new FileWriter("File.txt");    
			fw.write(input);    
			fw.close();    
			System.out.println("Success! File \""+input+"\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}
	
	
	public InputSave(){
		
	}
	
	
}
