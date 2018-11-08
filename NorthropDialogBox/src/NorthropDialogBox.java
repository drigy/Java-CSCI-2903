/*Charles Northrop
 * 
 * NorthropDialogBox
 * 
 * This program prompts user for a phone number in xx-xxx-xxxx format in a dialog box. Replaces the 
 * 
 * dashes with spaces. It then outputs the in a dialog box.
 * 
 * due 6/10/18
*/
import javax.swing.JOptionPane; //imports that class that allows the use of the dialog messages.
public class NorthropDialogBox {

	public static void main(String[] args)
	{
		String phoneNumberDash; //stores the phone number with dashes
		String phoneNumberSpace; // stores the phone number without dashes
		
		//prompts user for a phone number and stores it as a string in phoneNumberDash
		phoneNumberDash = JOptionPane.showInputDialog("Enter a phone number in xxx-xxx-xxxx format.");
		
		//replaces dashes with a space and stores it in phoneNumberSpace as a string
		phoneNumberSpace = phoneNumberDash.replace('-',' ');
		
		//displays phoneNumberSpace in a dialog window
		JOptionPane.showMessageDialog(null, phoneNumberSpace);
	}

}
