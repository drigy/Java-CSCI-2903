import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Employee 
{
	private String empName; //field that stores employee name
	private int empID; // field that stores employee ID
	private Clock timeIn = new Clock(); //Field creates an object to store their time in
	private Clock timeOut = new Clock(); //Field creates an object to store their time out.

	//Constructor that assigns zero or space to all fields
	public Employee() 
	{
		empName = " ";
		empID = 0 ;
		timeIn.setTime(0,0,0);
		timeOut.setTime(0, 0, 0);
	}
	
	//constructor that assigns all fields the corresponding parameter value.
	public Employee(String name, int id, Clock startTime, Clock endTime)
	{
		empName = name;
		empID = id;
		startTime.makeCopy(timeIn);
		endTime.makeCopy(timeOut);
	}
	
	// Method ask users for name.
	public void setName()
	{
		empName = JOptionPane.showInputDialog("Please enter Employee's name.");
	}
	
	//method ask user for ID and then validates ID.
	public void setID()
	{
		String strID = JOptionPane.showInputDialog("Please enter Employee's id");
		while(strID.matches("\\d{5}") != true  || Integer.parseInt(strID)<0)
		{
			strID = JOptionPane.showInputDialog("Please reenter Employee's id, it should be a postive whole number, and 5 digits long.");
		}
		empID = Integer.parseInt(strID);
	}
	
	// Method allows user to input time in.
	public void setTimeIn()
	{
		JOptionPane.showMessageDialog(null, "Please input time that work started." );
		timeIn.setTime(-1, -1, -1);
	}
	
	// method allows user to input time out.
	public void setTimeOut()
	{
		JOptionPane.showMessageDialog(null, "Please input time that work ended." );
		timeOut.setTime(-1, -1, -1);
		
	}
	
	//method returns the empName field.
	public String getName() 
	{
		return empName;
	}
	
	//Method returns the empID field.
	public int getID()
	{
		return empID;
	}
	
	//Method returns the timeIn field.
	public Clock getTimeIn() 
	{
		return timeIn;
	}
	
	//Method returns the timeOut Field.
	public Clock getTimeOut()
	{
		return timeOut;
	}
	
	//Method returns hours worked as a string using the timeIn and timeOut objects.
	public String hoursWorked() 
	{
		int hourIn = timeIn.getHours();
		int minuteIn = timeIn.getMinutes();
		int secondIn= timeIn.getSeconds();
		
		int hourOut = timeOut.getHours();
		int minuteOut = timeOut.getMinutes();
		int secondOut = timeOut.getSeconds();
		
		//Calculates hours
		int hour = hourOut - hourIn;
		
		//calculates minute
		int minute = minuteOut - minuteIn;
		
		//handles minute if it rolls over to 60
		if(minute<0)
		{
			hour--;
			minute = 60 + minute;
		}
		
		//Calculates seconds
		int second = secondOut - secondIn;
		
		//handles seconds if they roll over.
		if(second<0)
		{
			if(minute == 0)
			{
				hour--;
				minute = 59;
			}
			else
			{
				minute--;
			}
			second =60 + second;
		}
		
		//formats and creates string for hours worked
		String hoursWorked = String.format("%02d", hour) + ":" + String.format("%02d", minute);
		
		//returns string.
		return hoursWorked;
		
	}
	
	
	/* This method compares timeIn and timeOut.
	 * Returns true if timeIn happens before timeOut
	 * Other wise returns false.
	 * Made to make validation of times easier.
	 */
	public boolean compareTime() 
	{
		
		int hourIn = timeIn.getHours();
		int minuteIn = timeIn.getMinutes();
		int secondIn= timeIn.getSeconds();
		
		int hourOut = timeOut.getHours();
		int minuteOut = timeOut.getMinutes();
		int secondOut = timeOut.getSeconds();
		
		//Calculates hours.
		int hour = hourOut - hourIn;
		
		//Calculates minutes
		int minute = minuteOut - minuteIn;
		
		//Rolls minutes over.
		if(minute<0)
		{
			hour--;
			minute = 60 + minute;
		}
		
		//Calculates seconds
		int second = secondOut - secondIn;
		
		//Rolls seconds over.
		if(second<0)
		{
			if(minute == 0)
			{
				hour--;
				minute = 59;
			}
			else
			{
				minute--;
			}
			second = 60 + second;
		}
		if(hour<0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	//This method reveres the order of the ArryList object.
	public static List<Employee> reverseOrder(List<Employee> forward)
	{
		
		 for (int i = 0; i < forward.size(); i++) 
		 {
	            forward.add(i, forward.remove(forward.size() - 1));
	      }
		return forward;
	}
	
	//This method formats and prints the Array list. It is static
	public static void printArrayList(List<Employee> tempList)
	{
		int longest = 0;
		//This loop determines number of spaces need to maintain columns.
		for(int i= 0; i<tempList.size(); i++) 
		{
			
			if(tempList.get(i).getName().length()> longest)
			{
				longest = tempList.get(i).getName().length();
			}
		}
		longest +=5;
		String finalString ="";
		for(int i = 0; i < tempList.size(); i++ )
		{
			finalString += tempList.get(i).getName();
			for(int a =0; a <(longest-tempList.get(i).getName().length()); a++)
			{
				finalString+= " ";
			}
			finalString += tempList.get(i).getID();
			finalString += "     ";
			finalString +=tempList.get(i).getTimeIn().getTime();
			finalString += "     ";
			finalString += tempList.get(i).getTimeOut().getTime();
			finalString += "     ";
			finalString += tempList.get(i).hoursWorked();
			finalString += "\n";
			

		}
		JOptionPane.showMessageDialog(null, "Output will be printed to Console window.");
		
		// I really hated doing this but I couldn't get it to format correctly in to columns in JOptionPane.
		System.out.println(finalString);
	}
}
