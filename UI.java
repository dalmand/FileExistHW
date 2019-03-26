package fileexist;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.io.PrintWriter;

public class UI {

	//You will need to throw FileMissingException, your customized exception
	public static void main(String[] args) throws FileNotFoundException{
		
		
		
		UI user = new UI();
		boolean fileExists = false;
		Business business = new Business();
		Scanner input = new Scanner(System.in);
		//You will need to declare an ArrayList
		//ArrayList<String> list ; 
		
		do {
			
			//you may want to try{} catch(FileMissingException ex)... here. 

				//prompt user to type in file name
				System.out.println("Please enter the file name you would like to read.");
				String newFile = input.next();
				ArrayList<String> list = business.readFile(newFile);
			
				user.printList(list);
				
				user.reverseList(list);
				
				user.printList(list);
				
				System.out.println("Please enter the name of the new file to write");
				
				String secondFile = input.nextLine();
				
				if(secondFile.equals(newFile)) {
					
					do {
						System.out.println("You cannot use the same file name");
						System.out.println("Please enter the name of the new file to write");
						secondFile = input.nextLine(); 
					}while (!fileExists);
			
				}

				business.writeFile(secondFile, list);

		
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

