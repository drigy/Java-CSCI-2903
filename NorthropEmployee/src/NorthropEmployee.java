import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/*Charles Northrop
 * 
 * NorthropEmployee
 * 
 * This program demonstrates the Employee class. It also demonstrates the ArrayList functionallity.
 * 
 * due 7/1/2018
*/

public class NorthropEmployee {

	public static void main(String[] args) 
	{
		List<Employee> employObjectList = new ArrayList<Employee>(); //Creats an arrayList to store objects.
		boolean continueFlag = true; // indicates if the user wish to continue or not.
		/*This loop prompt and ask the user for input for the fields of Employee. 
		* It validates the values.
		* It adds the object to the employObjectList ArrayList.
		* Repeats till user asks to stop.
		*/
		while(continueFlag)
		{
		Employee testEmp = new Employee(); //object created to employee information.
		
		testEmp.setName(); // asks user for name
		
		testEmp.setID(); // ask user for id
		
		//created loop below needs to run or not.
		boolean timeRight = false;
		
		int testCounter = 0; // created to signal to if statement when the loop has run more then once.
		//Loop prompts user for time in and time out and then validates it.
		while(timeRight == false)
		{
			//Prompt to remind user to that time in needs to be before time out.
			if(testCounter > 0)
			{
				JOptionPane.showMessageDialog(null, "Please Make sure time in is earlier then time out.");
			}

			testEmp.setTimeIn();
			testEmp.setTimeOut();
			timeRight = testEmp.compareTime();
			testCounter++;
		}
		//adds the current iteration of TestEmp.		
		employObjectList.add(testEmp);
		//Prompts user if it has more employee information add then if statement changes flag to false if the y don't
		String continueOrNot= JOptionPane.showInputDialog("Type no or n if you are finshed entering names. Other wise enter character.");
		if(continueOrNot.equals("no") || continueOrNot.equals("No")|| continueOrNot.equals("NO")|| continueOrNot.equals("nO") || continueOrNot.equals("n") || continueOrNot.equals( "N"))
		{
			continueFlag = false;
		}
		
		}
		
		//prints employObjectList Forward.
		Employee.printArrayList(employObjectList);
		
		//reverses employObjectList.
		Employee.reverseOrder(employObjectList);
		
		//Prints the backward version of employObjectList.
		Employee.printArrayList(employObjectList);
		
	}

}
