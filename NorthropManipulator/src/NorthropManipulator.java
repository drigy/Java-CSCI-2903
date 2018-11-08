// Charles Northrop

// NorthropManipulator

// Program prompt a user for a Movie name. It will output the length of input, the input in upper case,
// lower case, and last letter.

// due 6/10/2018

import java.util.Scanner; // This line is needed to use the scanner class. Used for its input capabilities.

public class NorthropManipulator
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in); // Creates a variable keyboard that can reference the Scanner object that can read input.
		
		String movieName; // Used to receive name of movie.
		
		String movieUpper; // This will store upper case version of movieName.
		
		String movieLower; // This will store lower case version of movieName.
		
		String lastLetter; // This will store last letter of movieName.
		
		int nameLength; // This will store length of movieName as an integer.
		
		// Get favorite movie title from user.
		System.out.println("Please type in the name of your favorite movie title, please. ");
		movieName = keyboard.nextLine();
		
		// Outputs length of movie name.
		nameLength = movieName.length();
		System.out.println(movieName + " is " + nameLength + " characters long.");
		
		// Outputs upper case version of movie name.
		movieUpper = movieName.toUpperCase();
		System.out.println(movieName + " in uppercase form: " + movieUpper);
		
		// Outputs lower case version of movie name.
		movieLower = movieName.toLowerCase();
		System.out.println(movieName + " in lowercase form: " + movieLower); 
		
		// Outputs last letter of movie name.
		lastLetter = Character.toString(movieName.charAt(nameLength-1));
		System.out.println("The last letter of " + movieName + " is " + lastLetter + " ."); 
	}

}
