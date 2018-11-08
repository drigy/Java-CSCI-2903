/*Charles Northrop
 * 
 * NorthropReverseDigit
 * 
 * This program takes a user inputed integer and uses a method to reverse the digits
 * It then reports that to the user.
 * 
 * due 6/16/18
*/

import javax.swing.JOptionPane; //imports that class that allows the use of the dialog messages.

 class NorthropReverseDigit 
{

	public static void main(String[] args) 
	{
		//The following line prompts the user for an integer and then initializes that value into userINT.
		int userInt = Integer.parseInt(JOptionPane.showInputDialog("Please input an integer you which to see reversed."));
		
		//Calls the method reverseDigit and pass userInt into. It also stores the return value into OutputInt.
		int outputInt = reverseDigit(userInt);
		
		//Reports to the User their original integer and the it reversed form.
		JOptionPane.showMessageDialog(null,"Your orginal integer is " + userInt + "\nThe reverse of your integer is "+outputInt);
	}
	//This method has forwardInt as parameter and returns the reverseInt. Which is the reversed form of the argument.
	public static int reverseDigit(int forwardInt)
	{
		// The following integer was created to store the reverse form of the integer.
		int reverseInt = 0;
		
		// This loop repeats until forwardInt is 0
		while (forwardInt != 0)	
		{
			//This line increases reverseInt by a power of 10 and then adds ones digit of fowardInt to reverseInt.
			reverseInt = reverseInt * 10 + (forwardInt % 10);
		 
			//This line decrease fowardInt by a power of 10.
			forwardInt = forwardInt / 10;
		}
		return reverseInt;
	}
}
