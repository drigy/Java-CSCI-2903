/*Charles Northrop
 * 
 * NorthropVacationRental
 * 
 * This program demonstrates radio buttons used in GUI.
 * 
 * due 7/8/2018
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.BorderLayout;


public class NorthropVacationRental extends JFrame
{
	//main outside panel to help organize 
	private JPanel totalPanel;
	
	//panel and components to go in the top part of window.
	private JPanel north;
	private JLabel messageLable;
	private JLabel messageOutput;
	
	//panel created to help organize center components
	private JPanel panelCenter;
	
	//center west components and panel
	private JPanel panelCenterWest;
	private JRadioButton parkSide;
	private JRadioButton poolSide;
	private JRadioButton lakeSide;
	private ButtonGroup location;
	
	
	//center center components and panel
	private JPanel panelCenterCenter;
	private JRadioButton oneRoom;
	private JRadioButton twoRoom;
	private JRadioButton threeRoom;
	private ButtonGroup roomSize;
	
	//center east  components and  panel
	private JPanel panelCenterEast;
	private JRadioButton meal;
	private ButtonGroup mealChoice;
	
	
	//south panel and components 
	private JPanel south;
	private JButton calculate;
	
	
	//sizes window
	private final int windowWidth = 560;
	private final int windowHeight = 350;
	
	
	//constructor that builds the window.
	public NorthropVacationRental()
	{
		
			setTitle("Vacation Rental Calculator");
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			buildPanel();
			
			add(totalPanel);
			
			setSize(windowWidth,windowHeight);
			setVisible(true);
		
		
		
	}
	
	
	//creates panels and components and organism them
	public void buildPanel() 
	{
		//Northern components that handles initial instruction and output.
		messageLable = new JLabel ("Please Select the following options for you rental.");
		messageOutput = new JLabel ("Prices are based per week.");
		north = new JPanel();
		north.setLayout(new BorderLayout());
		north.add(messageLable,BorderLayout.WEST);
		north.add(messageOutput,BorderLayout.EAST);
		
		//radio butons for location options on the center west panel as well as button group
		parkSide = new JRadioButton("Parkside rentals are $600.");
		poolSide = new JRadioButton("Poolside rentals are $750.");
		lakeSide = new JRadioButton("Lakeside rentals are $825.");
		location = new ButtonGroup();
		panelCenterWest = new JPanel();
		
		//added to button group
		location.add(parkSide);
		location.add(poolSide);
		location.add(lakeSide);
		
		//components added to center west panel.
		panelCenterWest.setLayout(new BorderLayout());
		panelCenterWest.add(parkSide,BorderLayout.NORTH);
		panelCenterWest.add(poolSide,BorderLayout.CENTER);
		panelCenterWest.add(lakeSide,BorderLayout.SOUTH);
		
		//number of room radio buttons created along with corresponding button group and panel.
		oneRoom = new JRadioButton("One room is $75.");
		twoRoom = new JRadioButton("Two rooms are $150.");
		threeRoom = new JRadioButton("Three rooms are $225.");
		roomSize = new ButtonGroup();
		panelCenterCenter = new JPanel();
		
		//number of rooms radio buttons added to button group
		roomSize.add(oneRoom);
		roomSize.add(twoRoom);
		roomSize.add(threeRoom);
		
		//number of rooms radio buttons added to panel
		panelCenterCenter.setLayout(new BorderLayout());
		panelCenterCenter.add(oneRoom, BorderLayout.NORTH);
		panelCenterCenter.add(twoRoom, BorderLayout.CENTER);
		panelCenterCenter.add(threeRoom, BorderLayout.SOUTH);
		
		//meal choice button, button group and panel made
		meal = new JRadioButton("Meals are $200 extra.");
		mealChoice = new ButtonGroup();
		panelCenterEast = new JPanel();
		
		//meal added to button group
		mealChoice.add(meal);
		
		//meal added to panel
		panelCenterEast.add(meal);
		
		//all sub center panels added to center panel and organized according to name.
		panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(panelCenterWest,BorderLayout.WEST);
		panelCenter.add(panelCenterCenter,BorderLayout.CENTER);
		panelCenter.add(panelCenterEast,BorderLayout.EAST);
		
		
		//Calculate button created, listener added, south panel created.
		calculate = new JButton("Calculate price");
		calculate.addActionListener(new calculateListener());
		south = new JPanel();
		south.add(calculate);
		
		//totalPanel created and all sub panels organized accordingly
		totalPanel =new JPanel();
		totalPanel.setLayout(new BorderLayout());
		totalPanel.add(north, BorderLayout.NORTH);
		totalPanel.add(panelCenter, BorderLayout.CENTER);
		totalPanel.add(south, BorderLayout.SOUTH);
		
		
	}
	//button listener made to allow the calculate button to click.
	private class calculateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int price = 0;
			//Validation flags made to make sure at least one option from location and number of rooms selected.
			boolean flagLoc = false;
			boolean flagSiz = false;
			
			//if statement determines which radio button are active and added corresponding price.
			if(parkSide.isSelected())
			{
				price += 600;
				flagLoc =true;
			}
			else if(poolSide.isSelected())
			{
				price += 750;
				flagLoc =true;
			}
			else if(lakeSide.isSelected())
			{
				price += 825;
				flagLoc =true;
			}
			if(oneRoom.isSelected())
			{
				price += 75;
				flagSiz = true;
			}
			else if(twoRoom.isSelected())
			{
				price += 150;
				flagSiz = true;
			}
			else if (threeRoom.isSelected())
			{
				price += 225;
				flagSiz =true;
			}
			if(meal.isSelected())
			{
				price +=200;
			}
			if(flagLoc && flagSiz) 
			{
				messageOutput.setText("Your price for one week is: $" + price +".");
			}
			else //Validation if they didn't chose at least one location and number of room option.
			{
				JOptionPane.showMessageDialog(null, "You need to select at least one option from the locations and one option for number of rooms.");
			}
			}
		}
	
	public static void main(String[] args) 
	{
		NorthropVacationRental stw = new NorthropVacationRental(); //trigger the constuctor and runs the program.

	}

}
