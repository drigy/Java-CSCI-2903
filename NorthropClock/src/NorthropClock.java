/*Charles Northrop
 * 
 * NorthropClock
 * 
 * This program demonstrates the Clock class and plays the digital clock game.
 * 
 * due 6/24/18
*/

import javax.swing.JOptionPane; 
public class NorthropClock 
{

	public static void main(String[] args) 
	{
		boolean terminator = true; //flag created to end the outer while loop and thus the program.
		Clock timeSet = new Clock();//Clock object created for majority of program.
		while(terminator)
		{
			String chooserStr="e";//made to store users decisions for what case they select.
			
			int counterTest=0; //created to let program know if the chooserStr had been given and incorrect value previously.
			
			do//runs the menu that the user sees until they give a valid value.
			{
				if(counterTest>0)//Lets user know they must enter a number between 1 to 11 if they enter something other then a number between 1 and 11 before.
				{
					JOptionPane.showMessageDialog(null, "You must enter a number from 1 to 11.");
				}
				//Shows user menu and stores user choice in schooserStr.
				chooserStr=JOptionPane.showInputDialog("Welcome to the Digital Clock Program!  Please choose an option below.\r\n" + 
			
					"\r\n" + 
					"1.  Set the time.\r\n" + 
					"2.  Return the hours.\r\n" + 
					"3.  Return the minutes.\r\n" + 
					"4.  Return the seconds.\r\n" + 
					"5.  Print the time.\r\n" + 
					"6.  Increment the time by one hour.\r\n" + 
					"7.  Increment the time by one minute.\r\n" + 
					"8.  Increment the time by one second.\r\n" + 
					"9.  Compare two times for equality.\r\n" + 
					"10. Play Amazing Digital Clock.\r\n" + 
					"11. Quit.");
				
				counterTest++; //Lets loop know if it has been run before.
				
				if(chooserStr.chars().allMatch( Character::isDigit )!= true || chooserStr.length() == 0)//Sets chooserStr to 99 if it isn't a digit to prevent from causing an error in the next few lines.
				{
					chooserStr = "99";				
				}
			}while (((Integer.parseInt(chooserStr) < 0 || Integer.parseInt(chooserStr) > 12))); // Continues the menu selection loop if chooserStr isn't a number from 1 to 11.
			
			int chooserInt = Integer.parseInt(chooserStr); //converts chooserStr to integer and stores in in chooserInt.
			
			
			//switch statement that activates specific cases based on user choice.
			switch (chooserInt)
			{
			case 1: //This case corresponds to the set time option 
				String time=JOptionPane.showInputDialog("Please enter a valid standard time in the HH:MM:SS format."); //prompts user for time.
				if(time.matches("\\d{2}:\\d{2}:\\d{2}"))//Checks if user input is in right form, then if it is breaks it up, converts it and inputs puts into timeSet's setTime method.
				{
					String stringHr = time.substring(0 , 2);
					String stringMin = time.substring(3 , 5);
					String stringSec = time.substring(6 , 8);
					
					timeSet.setTime(Integer.parseInt(stringHr), Integer.parseInt(stringMin), Integer.parseInt(stringSec));
				}
				else // Activates the setTime method if format is wrong. Done to prevent errors due to bad input.
				{
					timeSet.setTime(0, 0, 0);
				}
				JOptionPane.showMessageDialog(null,"You have succesfully set the time."); //Lets user know that time is done correctly. 
				break;
			
			case 2:// Corresponds to get hours option.
				int hour = timeSet.getHours(); //Gets hours.
				JOptionPane.showMessageDialog(null, "The hour is: " + hour); //Prints hours.
				break;
				
			case 3:// Corresponds to get Minutes option.
				int minute = timeSet.getMinutes();//Gets minutes.
				JOptionPane.showMessageDialog(null, "The minute is: " + minute);//Prints minutes.
				break;
				
			case 4:// Corresponds to get Seconds option.
				int second = timeSet.getSeconds();//Gets Seconds.
				JOptionPane.showMessageDialog(null, "The second is: " + second);//Prints Seconds.
				break;
				
			case 5://Corresponds to the print time option.
				timeSet.printTime();//prints the time.
				break;
				
			case 6://Corresponds to the increment hours option.
				timeSet.incrementHours();// runs the incrementHours method.
				JOptionPane.showMessageDialog(null,"You incremented the hour by 1.");//Lets user know hours has been incremented.
				break;
				
			case 7://Corresponds to the increment minute option.
				timeSet.incrementMin();// runs the incrementMinute method.
				JOptionPane.showMessageDialog(null,"You incremented the minute by 1.");//Lets user know minutes has been incremented.
				break;
			
			case 8://Corresponds to the increment seconds option.
				timeSet.incrementSec(); // runs the incrementSecond method
				JOptionPane.showMessageDialog(null,"You have incremented the second by 1."); //Lets user know seconds has been incremented.
				break;
				
			case 9://Corresponds to the compare times.
				
				Clock timeCompareFirst = new Clock(); // Creates clock object for first time.
				String timeCompare=JOptionPane.showInputDialog("Please enter the first valid time in the HH:MM:SS format.");//Prompts user for time.
				if(timeCompare.matches("\\d{2}:\\d{2}:\\d{2}"))//Puts time into timeCompareFirst object if in correct format.
				{
					String stringHr = timeCompare.substring(0 , 2);
					String stringMin = timeCompare.substring(3 , 5);
					String stringSec = timeCompare.substring(6 , 8);
					
					timeCompareFirst.setTime(Integer.parseInt(stringHr), Integer.parseInt(stringMin), Integer.parseInt(stringSec));
				}
				else //Activates the setTime method for timeCompareFirst if user input is in wrong format.
				{
					timeCompareFirst.setTime(0, 0, 0);
				}
				
				Clock timeCompareSecond = new Clock(); //Creates Clock object for second time.
				timeCompare=JOptionPane.showInputDialog("Please enter the second valid time in the HH:MM:SS format.");//Prompts user for second time.
				if(timeCompare.matches("\\d{2}:\\d{2}:\\d{2}"))//Puts time into timeCompareSecond object if in correct format.
				{
					String stringHr = timeCompare.substring(0 , 2);
					String stringMin = timeCompare.substring(3 , 5);
					String stringSec = timeCompare.substring(6 , 8);
					
					timeCompareSecond.setTime(Integer.parseInt(stringHr), Integer.parseInt(stringMin), Integer.parseInt(stringSec));
				}
				else//Activates the setTime method for timeCompareSecond if user input is in wrong format.
				{
					timeCompareSecond.setTime(0, 0, 0);
				}
				if(timeCompareSecond.equals(timeCompareFirst))//Compares two times and lets user know if they are equal or not.
				{
					JOptionPane.showMessageDialog(null, "The two times you gave are equal.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "The two times you gave are not equal.");
				}
				break;
				
			case 10: //This option corresponds to the amazing digital cock game.
				Clock gameTime = new Clock(); //Creates an object called  gameTime.
				gameTime.digitalClockGame();//Activates gameTime's digitalClockGame() method.
				break;
			case 11: // This option ends the program.
				terminator = false;
				JOptionPane.showMessageDialog(null, "The Program will now end.");
				break;
			}
			
		}

	}

}
