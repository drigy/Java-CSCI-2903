/*Charles Northrop
 * 
 * NorthropCellPhone
 * 
 * This program demonstrates the use of lists and combo boxes
 * 
 * due 7/15/2018
*/
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*;
import java.text.DecimalFormat;
import java.awt.*;

public class NorthropCellPhone extends JFrame

{
	private JLabel label; // label explains what the out put is
	private JPanel northPanel; //Panel for the north label.
	private JLabel northLabel; //label that goes in northPanel explains program
	
	private static DecimalFormat df2 = new DecimalFormat(".##"); //created to format doubles to two significant digits
	private JPanel westPanel; //west panel handles list of minutes options
	private JPanel eastPanel; //east panel handles the other list options
	
	private JList listMinutes; // JList to handle the amount of minutes option
	private double minTotal; // keeps running total of the amount of money for minutes
	
	private JPanel centralPanel; // central panel handles combo box
	private JComboBox phoneBox; // combo box to select phone model
	
	private JPanel southPanel; // south panel handles the output text field.
	private JTextField total; // directly handles the out put.
	private double runningTotal = 0; // stores overall running total
	private double cellTotal =0; // stores cellphone total
	private double otherTotal =0;// stores the other option total.

	
	private JList other; // list created for the other options
	
	//creates the string array required for the minutes list
	private String[] minutes = {"300 minutes per month","800 minutes per month","1500 minutes per month"};
	//creates the string array required for the phonebox combo box.
	private String[] models = {"Model 100","Model 110","Model 200"};
	//creates the string array required for the other list
	private String[] otherOptions = {"250MB Data Plan","3GB Data Plan", "Unlimited text messaging"};
	
	//constructor that builds the JFrame that becomes the user interface.
	public NorthropCellPhone() 
	{
		setTitle("Cell Phone Picker");//sets title
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows program to be exit out be clicking the x
		
		setLayout(new BorderLayout()); //changes layout to border layout.
		buildNorthPanel();//builds the north panel
		buildWestPanel();//builds the west panel
		
		buildCentralPanel();//builds the central panel
		
		buildSouthPanel();// builds the south panel
		
		buildEastPanel();// builds the east panel.
		
		add(northPanel,BorderLayout.NORTH); //adds northPanel to the north section of the Jframe.
		add(westPanel, BorderLayout.WEST); //adds westPanel to the west section of the Jframe.
		add(southPanel, BorderLayout.SOUTH);//adds southPanel to the south section of the Jframe.
		add(centralPanel,BorderLayout.CENTER);//adds centralPanel to the central section of the Jframe.
		add(eastPanel, BorderLayout.EAST);//adds eastPanel to the east section of the Jframe.
		
		pack(); // packs Jframe
		setVisible(true);// makes Jframe visible
	}
	//builds the west panel
	private void buildWestPanel() 
	{
		westPanel = new JPanel(); //creates the west panel.
		
		listMinutes = new JList(minutes); //creates listMinutes and initializes with string array minutes.
		
		listMinutes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//sets selection mode to single select
		
		listMinutes.addListSelectionListener(new listListener()); //Registers it with first listListener
		
		westPanel.add(listMinutes);//adds list to west panel
	}
	//builds central panel
	private void buildCentralPanel() 
	{
		centralPanel = new JPanel(); //creates the central panel.
		
		phoneBox = new JComboBox(models); //creates the comboBox called phoneBox.
		
		phoneBox.addActionListener(new ComboBoxListener()); //Registers phoneBox with the ComboBoxListener
		
		centralPanel.add(phoneBox); //adds phoneBox to the central panel.
		
	}
	//builds east panel
	private void buildEastPanel()
	{
		eastPanel = new JPanel(); //creates east panel.
		
		other = new JList(otherOptions); //creates Jlist called other and initializes it with the String array otherOptions
		other.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);// sets the other list selection mode as multiple interval selection
		other.addListSelectionListener(new secondlistListener());//registers other with the second list listener
		
		eastPanel.add(other); //add other to the east panel.
		
	}
	//builds south panel.
	private void buildSouthPanel()
	{
		southPanel = new JPanel();//creates south panel.
		
		label = new JLabel("Your Total is: $"); //creates JLabel that lables the output.
		
		total = new JTextField(10); //creates Text field that out put is displayed in.
		
		total.setEditable(false); //prevents user from screwing up the text field.
		
		southPanel.add(label);// adds label to southPanel
		southPanel.add(total);//adds total to southPanel.
		
	}
	//builds north panel.
	private void buildNorthPanel()
	{
		northPanel = new JPanel();//creates northPanel.
		northLabel = new JLabel("Please selection options for you cellphone below."); //creats northLabel and gives initializes with a string.
		
		northPanel.add(northLabel);//adds northLabel to northPanel.
	}
	//creates listSelectionListener class for listMinutes
	private class listListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent e)
		{
			//if statement checks which one is selected, then upadtes minTotal and then running total. It then formats and sents it the text field
			if (listMinutes.getSelectedValue()== minutes[0])
			{
				minTotal = 45;
				runningTotal = minTotal + cellTotal+otherTotal;
				total.setText(df2.format(runningTotal));
			}
			else if (listMinutes.getSelectedValue()== minutes[1])
			{
				minTotal = 65;
				runningTotal = minTotal + cellTotal+otherTotal;
				total.setText(df2.format(runningTotal));
			}
			else if (listMinutes.getSelectedValue()== minutes[2])
			{
				minTotal = 99;
				runningTotal = minTotal + cellTotal+otherTotal;
				total.setText(df2.format(runningTotal));
			}
		}
	}
	//action listener created for phoneBox 
	private class ComboBoxListener implements ActionListener
	{

	
		public void actionPerformed(ActionEvent b) 
		{
		
			//determines which phone is selected, then adds price and calculates price and adds sales tax.
			if (phoneBox.getSelectedItem()== models[0])
			{
				cellTotal = 29.95*1.06;
				
				runningTotal = minTotal + cellTotal+otherTotal;
				total.setText(df2.format(runningTotal));
			}
			else if (phoneBox.getSelectedItem()== models[1])
			{
				cellTotal = 49.95*1.06;
				runningTotal = minTotal + cellTotal+otherTotal;
				total.setText(df2.format(runningTotal));
			}
			else if (phoneBox.getSelectedItem()== models[2])
			{
				cellTotal = 99.95*1.06;
				runningTotal = minTotal + cellTotal+otherTotal;
				total.setText(df2.format(runningTotal));
			}
			
		}		
	}
//creates listSelectionListener 
	private class secondlistListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent e)
		{
			
		Object obj[]= other.getSelectedValues(); //creates object array store selected values
		// loop runs through obj checking if statement condition are meet. If statements check to see which list items are selected.
		//and updates the other total.
		for (int i =0; i<obj.length; i++)
		{
			if((String) obj[i] == otherOptions[0])
			{
				otherTotal += 15;
			}
			else if((String) obj[i] == otherOptions[1])
			{
				otherTotal += 30;
			}
			else if((String) obj[i] == otherOptions[2])
			{
				otherTotal +=10;
			}
		}
		runningTotal = minTotal + cellTotal+otherTotal;//updates other total.
		total.setText(df2.format(runningTotal));//formats and changes text on the total field.
		otherTotal =0;//reset other total so it doesn't over accumulate.
		
		}
	}
	
	public static void main(String[] args) 
	{
		new NorthropCellPhone();//activates constuctor which builds frame and runs program.
	}

}
