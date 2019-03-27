package fileexist;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.io.PrintWriter;

public class UI {

	public static void main(String[] args) throws FileMissingException{
		
		
		UI user = new UI();
		boolean fileExists = false;
		Business business = new Business();
		Scanner input = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();

		
		do {
			
			System.out.println("Please enter the file name you would like to read.");
			String newFile = input.next();

			try {
				//prompt user to type in file name
				list = business.readFile(newFile);
			}
			catch(FileMissingException ex) {
				System.out.println("File " + newFile + " could not be found");
			}
			
				user.printList(list);
				
				user.reverseList(list);
				
				user.printList(list);
				
				System.out.println("Please enter the name of the new file to write");
				
				String secondFile = input.next();
				
				if(secondFile.equals(newFile)) {
					
					do {
						System.out.println("You cannot use the same file name");
						System.out.println("Please enter the name of the new file to write");
						secondFile = input.nextLine(); 
					}while (!fileExists);
			
				}

				try {
				business.writeFile(secondFile, list);
				}
				catch(FileMissingException ae) {
					System.out.println("File " + secondFile +  " could not be written");
				}
	
				user.reverseList(list);
				
				user.printList(list);

		
		}while(fileExists);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void printList(ArrayList<String> list) {
		
		for(int i = 0;i < list.size();i++) {
		
			System.out.println(list.get(i));
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void reverseList(ArrayList<String> list) {
		
		Collections.reverse(list);
	}
}

