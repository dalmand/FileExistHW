package fileexist;

import java.io.FileNotFoundException;

public class FileMissingException extends FileNotFoundException{
	
	public FileMissingException() {
		super();
	}
	
	public FileMissingException(String message){
		super(message);
		
	}

}
