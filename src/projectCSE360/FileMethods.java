package projectCSE360;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class FileMethods {
	public int wordCount(File filetype) {
	Scanner scan = new Scanner(filetype);
	while(scan.hasNext())		//Counts the words in the .txt file used to form the X axis of the 2D array
	{
		scan.next();
		WordCount++;
	}
	}
}


