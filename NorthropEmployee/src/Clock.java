import javax.swing.JOptionPane; 

public class Clock 
{
private int hr; //private field that stores the hour component time.
private int min; //private field that stores the minute component time.
private int sec; //private field that stores the second component time.

	public Clock() // This method is a constructor that initialize the private fields with 0.
	{
		hr = 0;
		min = 0;
		sec = 0;
	}
	
	public Clock(int hour, int minute, int second) //This method is a constructor that initialize the private fields with arguments.
	{
		hr = hour;
		min = minute;
		sec = second;
		// The following while loop is a validation code to the values make sense.
		while((hr < 0 || hr > 23 ) || (min < 0 || min > 59) || (sec < 0 || sec > 59))
		{
			String time=JOptionPane.showInputDialog("You entered an invalid standard time please renter the time in the HH:MM:SS");
			if(time.matches("\\d{2}:\\d{2}:\\d{2}"))
			{
				String stringHr = time.substring(0 , 2);
				String stringMin = time.substring(3 , 5);
				String stringSec = time.substring(6 , 8);
				
				hr = Integer.parseInt(stringHr);
				min = Integer.parseInt(stringMin);
				sec = Integer.parseInt(stringSec);
			}
		}
		
	}
	//This method has no return and three integer parameters. It will set time into the corresponding fields.
	public void setTime(int hour, int minute, int second)
	{
		hr = hour;
		min = minute;
		sec = second;
		// The following while loop is a validation code to the values make sense.
		int testWrong=0;
		while((hr < 0 || hr >23 ) || (min <0 || min >59) || (sec < 0 || sec > 59))
		{
			String time;
			if(testWrong >0)
			{
				time=JOptionPane.showInputDialog("You entered an invalid standard time please renter the time in the HH:MM:SS");
			}
			else
			{
				time=JOptionPane.showInputDialog("Please enter the time in the HH:MM:SS, military time format");
			}
			if(time.matches("\\d{2}:\\d{2}:\\d{2}"))
			{
				String stringHr = time.substring(0 , 2);
				String stringMin = time.substring(3 , 5);
				String stringSec = time.substring(6 , 8);
				
				hr = Integer.parseInt(stringHr);
				min = Integer.parseInt(stringMin);
				sec = Integer.parseInt(stringSec);
			}	
			++testWrong;
		}
		
	}
	
	public int getHours()//The following method returns the hour.
	{
		
		return hr;
	}
	
	public int getMinutes()//The following method returns the minute.
	{
		
		return min;
	}
	
	public int getSeconds()//The following method returns the second.
	{
		
		return sec;
	}
	
	public void printTime()//This method will print the time.
	{
		// This line takes the hr,min, and sec fields and converts them to a string and formats it to HH:MM:SS.
		String time = String.format("%02d", hr) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec); 
		JOptionPane.showMessageDialog(null, time); // actually prints out the time.
	}
	public String getTime()
	{
		return String.format("%02d", hr) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);
	}
	
	public void incrementHours()// increments the hr field by 1
	{
	if (hr < 23)//increments hr if it is less then 12
		{
		hr++;
		}
	else //Rolls over hr if it is 12
		{
		hr = 0;
		}
	}
	
	
	public void incrementMin()//increments min by 1
	{
		if (min <59) //increments min if it is less then 59
		{
			min++;
		}
		else// rolls min over if it is 59
		{
			
			incrementHours();
			min = 0;
			
		}
	
		
	}
	
	public void incrementSec() //increments the sec field by 1
	{
		if (sec < 59)//increments sec if it is less then 59
		{
			sec++;
		}
		else// rolls sec over if it is 59
		{
			incrementMin();
			sec = 0;
		}
		
	}
	
	public boolean equals(Clock otherClock) //checks to see if two clock objects are equal, returns true if they are, false if they are not.
	{
		if(this.hr == otherClock.hr && this.min == otherClock.min && this.sec == otherClock.sec)// compares fields of respective objects
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void makeCopy(Clock otherClock)//takes a clock object and makes it a copy of current object
	{
		otherClock.setTime(this.getHours(), this.getMinutes(), this.getSeconds());
	}

	public Clock getCopy()	// makes and returns a clock object that is a copy
	{
		Clock newCopy  = new Clock(this.hr,this.min,this.sec);
		return newCopy;
	}
	public void digitalClockGame()//Plays the digital clock game.
	{
		
		String gameTime = JOptionPane.showInputDialog("Please enter the time in the HH:MM:SS, standard time format");// gets time stores it in string gameTime
		Clock gameTimeObj = new Clock();//creates clock object to store and handle game time.
		if(gameTime.matches("\\d{2}:\\d{2}:\\d{2}"))//validates time is in right form and stores it in clock obj created previously.
		{
			String stringHr = gameTime.substring(0 , 2);
			String stringMin = gameTime.substring(3 , 5);
			String stringSec = gameTime.substring(6 , 8);
			
			gameTimeObj.setTime(Integer.parseInt(stringHr), Integer.parseInt(stringMin), Integer.parseInt(stringSec));
		}
		else//starts the setTime method form gameTimObj if the user enters time in wrong form
		{
			gameTimeObj.setTime(0,0,0);
		}
		int compHrTen = gameTimeObj.getHours() / 10;//gets first digit of hour
		int compHrOne = gameTimeObj.getHours() % 10; // gets second digit of hour
		
		int compMinTen = gameTimeObj.getMinutes() /10;//gets first digit of minute
		int compMinOne = gameTimeObj.getMinutes() % 10;//gets second digit of minute
		
		int compSecTen = gameTimeObj.getSeconds() / 10; //gets first digit of second
		int compSecOne = gameTimeObj.getSeconds() % 10; //gets second digit of second.
		
		boolean flag = true; //Trigger for if statement in case none of other if statements are triggered.
		
		//Lets user know if their time is lucky
		if ((gameTimeObj.getHours() == gameTimeObj.getMinutes() && gameTimeObj.getMinutes() == gameTimeObj.getSeconds()))//runs it if hour digits, minute digits and second digits equal each other when added up
		{
			JOptionPane.showMessageDialog(null, "The time you gave is a lucky time. What you are thinking about or wishing for will come true.");
			flag = false;
		}
		//Lets user know if their time indicates they might when the lottery
		if ((compHrTen == compHrOne && compHrOne == compMinTen && compMinTen == compMinOne && compMinOne == compSecTen && compSecTen == compSecOne)||(compHrTen == 0 && (compHrOne == compMinTen && compMinTen == compMinOne && compMinOne == compSecTen && compSecTen == compSecOne)))
		{
			JOptionPane.showMessageDialog(null, "All the digits for time you gave are the same. You might win the lottery.");
			flag = false;
		}
		//Lets user know if their time is in ascending order and their dreams will come true.
		if (((compHrTen == compHrOne-1) && (compHrOne == compMinTen-1) && (compMinTen == compMinOne-1) && (compMinOne == compSecTen-1) && (compSecTen == compSecOne -1))||((compHrTen == 0) && (compHrOne == compMinTen-1) && (compMinTen == compMinOne-1) && (compMinOne == compSecTen-1) && (compSecTen == compSecOne -1)))
		{
			JOptionPane.showMessageDialog(null, "The digits of the time you gave are in acsending order. Your dreams will come true.");
			flag =false;
		}
		//Lets user know if their time is in descending order and if they are in for difficult times.
		if (((compHrTen == compHrOne+1) && (compHrOne == compMinTen+1) && (compMinTen == compMinOne+1) && (compMinOne == compSecTen+1) && (compSecTen == compSecOne +1)) ||((compHrTen == 0) && (compHrOne == compMinTen+1) && (compMinTen == compMinOne+1) && (compMinOne == compSecTen+1) && (compSecTen == compSecOne +1)))
		{
			JOptionPane.showMessageDialog(null, "The digits of the time you gave are in decsending order. Your are in for rought times.");
			flag =false;
		}
		//Lets user know if their time is ordinary.
		if(flag)
		{
			JOptionPane.showMessageDialog(null, "Your number is normal.");
		}
		
	}
}
