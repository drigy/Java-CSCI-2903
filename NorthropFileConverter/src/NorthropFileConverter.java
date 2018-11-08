/*Charles Northrop
 * 
 * NorthropFileConverter
 * 
 * This program prompts a user for two file names. It takes the first files contents converts it to uppercase
 * and then copies it to the new text file.
 * 
 * due 6/17/18
*/

import java.io.*;
import java.util.Scanner;
import java.io.FileReader;
public class NorthropFileConverter 
{

	public static void main(String[] args) throws IOException
	{
		
		//this First section of code is for reading the first file.
		
		Scanner keyboard = new Scanner(System.in); //object created to recive user input.
		
		//prompt for user input
		System.out.println("Enter the name of the file to read from in the format filename.txt:");
		
		 String readFile = keyboard.nextLine(); //stores file name inputed by user in String readFile.
		 
		 File myFile = new File(readFile); //opens user file
		 
		 // The creates the inputFile object with the myFile argument. It allows other filereader objects to use the txt file
		 FileReader inputFile = new FileReader(myFile); 
		 
		 //Creates object to read file.
		 BufferedReader lineTextRecievier = new BufferedReader(inputFile);
		 
		 //This object will store string until we are ready to write it to txt file.
		 StringBuffer lineReader = new StringBuffer();
		 
		 //String used to hold string value until it can be transfered to line reader.
		 String textStorer= "";
		 
		 //This loop appends the string line by line to lineReader. The test statement also reads directly from the file.
		 while ((textStorer = lineTextRecievier.readLine()) != null)
		 {
			 lineReader.append(textStorer.toUpperCase()); // Appends and converts to upper case here.
			 lineReader.append("\r\n"); // \r\n is windows specific next line escape sequence for text files.
		 }
		 
		
		 // This section of code handles the output file
		
		 // The following two lines prompt and receive the file name for the second file.
		 System.out.println("Enter the name of the file like the first file to be copied to in the format filename.txt:");
		 String writeFile = keyboard.nextLine();
		
		 //PrintWriter object is creates will be used to write to the second file.
		 PrintWriter outputFile = new PrintWriter(writeFile);
		 outputFile.print(lineReader.toString()); //second file is written here.
		 
		 //Closing out some objects here.
		 outputFile.close();
		 keyboard.close();
		 lineTextRecievier.close();
	}

}
