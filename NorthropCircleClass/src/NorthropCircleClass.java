/*Charles Northrop
 * 
 * NorthropCircleClass
 * 
 * This program demonstrates a class called Circle but prompting the user for a radius and then
 * reporting the area, diameter, and circumference. 
 * 
 * due 6/16/18
*/
import javax.swing.JOptionPane; //imports that class that allows the use of the dialog messages.

public class NorthropCircleClass 
{

	public static void main(String[] args) 
	{
		// The following line prompts user to input the radius of a circle then stores in in inputRadius
		double inputRadius = Double.parseDouble(JOptionPane.showInputDialog("Please enter the radius of a circle."));
		
		// creates a new instance of Circle call this circle with inputRadius being the initial argument.
		Circle thisCircle = new Circle(inputRadius);
		
		//This line reports to the user the area, diameter, and circumference.
		JOptionPane.showMessageDialog(null,"This is your circle's area: "+ thisCircle.getArea() + "\nThis is your circle's diameter: " + thisCircle.getDiameter() + "\nThis is your circle's circumference: " + thisCircle.getCircumference());
	}

}


