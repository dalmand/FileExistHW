package fileexist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class Business {

	public ArrayList<String> readFile(String fileName) throws FileMissingException{
		
		//creation of ArrayList object
		ArrayList<String> list = new ArrayList<>();
		
		
		try {
			
			//creation of Scanner object to read from txt file
			Scanner reader = new Scanner(new File(fileName));
			
			//adds txt file contents to String ArrayList
			while(reader.hasNextLine()) {
				
				list.add(reader.nextLine());
				
			}
			//closing of Scanner object

			
		}
		
		//display custom message if text file does not exist
		catch(FileNotFoundException ex) {
			
		throw new FileMissingException("File " + fileName + " could not be found. Please select another file.");
		
		
			
		}
		//return ArrayList
		return list;
		}
	
	public String writeFile(String fileName, ArrayList<String> lines) throws FileMissingException {

		try {
			PrintWriter output = new PrintWriter(fileName);
			output.println(lines);
			output.close();

		}
		catch(FileNotFoundException ex) {
			throw new FileMissingException("File " + fileName + "could not be written"); 
		}
		
		
		return "File " + fileName + "has been written.";

	}
	
}

