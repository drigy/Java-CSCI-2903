/*Charles Northrop
 * 
 * NorthropCheckBoxes
 * 
 * This program demonstrates the use of sliders and JApplet.
 * 
 * due 7/22/2018
*/
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
public class NorthropThermometer extends JApplet
{
	private JLabel tempChooser, tempGraphic, tempReadout; //message labels	
	
	private JTextField tempFieldReadout; //temperature will be read out here.
	
	private JSlider tempAdjuster; // allows user to adjust temperature.
	
	private JPanel westPanel; //panel for slider component and its label. to be displayed one left side of GUI.
	
	private JPanel eastPanel; //stores tempFieldReadout and its label displayed on right side of gui.
	
	private int temperature = 0; //stores actually temperature to be manipulated easier
	
	private Color thermoColor;
	
	//void function where gui is built
	public void init()
	{
		buildWest();
		buildEast();
		setSize(600,517);
		setLayout(new BorderLayout());
		add(westPanel,BorderLayout.WEST);
		add(eastPanel, BorderLayout.EAST);
		add(new thermometer(),BorderLayout.CENTER );
	}
	
	private void buildWest()
	{
		westPanel = new JPanel(); //creates westPanel
		tempChooser = new JLabel("Please choose temperature in Fahrenheit");
		
		tempAdjuster =new JSlider(JSlider.VERTICAL, 0, 100,0);// creates a slider in vertical position to allow user to indicate temperature
		tempAdjuster.setMajorTickSpacing(10); //sets major tick spacing
		tempAdjuster.setMinorTickSpacing(1); // sets minor tick spacing
		tempAdjuster.setPaintTicks(true); //allows slider to show ticks
		tempAdjuster.setPaintLabels(true); // allows slider to show labels.
		tempAdjuster.addChangeListener(new tempListener()); // registers the slider with its listener
		
		westPanel.setLayout(new GridLayout(2,1)); //sets panel for gridlayout that is two rows and one coloum.
		
		westPanel.add(tempChooser, 0,0); //adds label to top grid
		westPanel.add(tempAdjuster, 0,1); // adds slider to second grid
		
		
	}
	
	private void buildEast()
	{
		eastPanel = new JPanel(); //creates the right panel.
		
		tempReadout = new JLabel("Your temperature in Fahrenheit is: "); //tells people what the number being displayed is
		
		tempFieldReadout = new JTextField(3);//creates text field for tempeture to be read out.
		tempFieldReadout.setEditable(false); // prevents user from editing text field.
		eastPanel.setLayout(new GridLayout( 2,1) ); //sets a grid layout. this two row and one colloumn
		
		eastPanel.add(tempReadout, 0,0); //adds label to top grid slot.
		eastPanel.add(tempFieldReadout, 0,1);//adds text field t bottom layout.
		
		
	}
	// changelistener made for thempAdjuster
	private class tempListener implements ChangeListener
	{

		//this function gets value from slider and then sets the text to it.
		public void stateChanged(ChangeEvent e) 
		{
			temperature = tempAdjuster.getValue(); //gets value from slider.
			tempFieldReadout.setText(Integer.toString(temperature));//adds temperature to text field
			repaint(); //updates the thermoColor
			
		}
		
	}
	
	//private classes draws themoColor and updates them based on Thermo adjuster.
	private class thermometer extends JPanel
	{
		 public void paintComponent(Graphics g) 
		 {
		        super.paintComponent(g);
		        float doubleTemp = temperature; //converts temperature to a float.
		        //if statement handles color transistion 
		        if (temperature < 25)
		        {	
		        	thermoColor =new Color(doubleTemp/100,1-doubleTemp/100,1-(doubleTemp*4)/100);
		        }
		     
		        else 
		        {
		        	thermoColor =new Color(doubleTemp/100,1-doubleTemp/100,0);
		        }
		        g.setColor(thermoColor);//sets color
		        g.drawOval(0, 500, 15, 15); //draws base of thermometer
		        g.fillOval(0, 500, 15, 15); //fills base of thermometer
		        g.drawRect(3, 505-(temperature*5)/2, 10, (temperature*5)/2); //draws stem of thermometer
		        g.fillRect(3, 505-(temperature*5)/2, 10, (temperature*5)/2);// fills stem of thermometer
		 }
	}
}
