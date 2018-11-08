/*Charles Northrop
 * 
 * NorthropSalesTax
 * 
 * This program demonstrates buttons used in GUI.
 * 
 * due 7/8/2018
*/

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.text.DecimalFormat;

public class NorthropSalesTax extends JFrame
{
	//panels made to organize the components
	private JPanel panelCenter;
	private JPanel panelSouth;
	private JPanel panelTotal;
	
	//receives text input
	private JTextField totalSales;
	
	//buttons which name based on 
	private JButton totalButton;
	private JButton countButton;
	private JButton stateButton;
	
	//these members set tax rate
	private final double countyRate = 0.04;
	private final double stateRate= 0.06;
	
	//determines size of window
	private final int windowWidth = 560;
	private final int windowHeight = 150;
	
	//constructor it builds window and runs gui
	public NorthropSalesTax() 
	{
		setTitle("Monthly Sales Tax Calculator");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		
		add(panelTotal);
		
		setSize(windowWidth,windowHeight);
		setVisible(true);
	}
	
	
	private void buildPanel() 
	{
		//label created for intstructions
		JLabel totalSalesMsg = new JLabel("Enter the total sales for this month: ");
		
		//text box to recieve input
		totalSales =new JTextField(10);
		
		//buttons created and named based on which tax rate they calculate.
		totalButton = new JButton("Calculate Total Sales Tax");
		stateButton = new JButton("Calculate Sales Tax");
		countButton = new JButton("Calculate County Tax");
		
		//add listeners to corresponding button
		totalButton.addActionListener(new totalButtonListener());
		countButton.addActionListener(new countButtonListener());
		stateButton.addActionListener(new stateButtonListener());
		
		//creates panel for objects to be added too.
		panelCenter = new JPanel();
		panelSouth = new JPanel();
		panelTotal = new JPanel();
		
		//Components added to panels
		panelCenter.add(totalSalesMsg);
		panelCenter.add(totalSales);
		panelSouth.add(countButton);
		panelSouth.add(stateButton);
		panelSouth.add(totalButton);
		
		//sub panels added to main panel and organized based on BorderLayout.
		panelTotal.setLayout(new BorderLayout());
		panelTotal.add(panelCenter, BorderLayout.CENTER);
		panelTotal.add(panelSouth,BorderLayout.SOUTH);
	}
	
	//button listener created for the total tax button.
	private class totalButtonListener implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			double totalSalesAmount;
			double countyTaxAmount;
			double stateTaxAmount;
			double totalTaxAmount;
			
			DecimalFormat dollar = new DecimalFormat("#,##0.00");
			//Validation that executes if a valid double value was entered. 
			try
			{	
				if(Double.parseDouble(totalSales.getText())>=0)
				{
					totalSalesAmount = Double.parseDouble(totalSales.getText());
			
					countyTaxAmount = totalSalesAmount * countyRate;
			
					stateTaxAmount = totalSalesAmount * stateRate;
			
					totalTaxAmount =countyTaxAmount + stateTaxAmount;
			
					JOptionPane.showMessageDialog(null, "Total Sales Tax: $" + dollar.format(totalTaxAmount));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please enter a postive decimal number.");
				}
			
			
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Please enter a postive decimal number.");
			}
		}
		
	}
	
	// Button listener for county tax rate.
	private class countButtonListener implements ActionListener
	{
		//Validation that executes if a valid double value was entered.
		public void actionPerformed(ActionEvent e) 
		{
			double totalSalesAmount;
			double countyTaxAmount;
			
			DecimalFormat dollar = new DecimalFormat("#,##0.00");
			try
			{
				if(Double.parseDouble(totalSales.getText())>=0)
				{
					totalSalesAmount = Double.parseDouble(totalSales.getText());
			
					countyTaxAmount = totalSalesAmount * countyRate;
			
			
					JOptionPane.showMessageDialog(null, "County Sales Tax: $" + dollar.format(countyTaxAmount));
				}
				else
				{	
					JOptionPane.showMessageDialog(null, "Please enter a postive decimal number.");
				}
			}
			catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Please enter a postive decimal number.");
			}
		}
	}
	//button listener for state tax.
	private class stateButtonListener implements ActionListener
	{
		//Validation that executes if a valid double value was entered.
		public void actionPerformed(ActionEvent e) 
		{
			double totalSalesAmount;
			double stateTaxAmount;
			
			DecimalFormat dollar = new DecimalFormat("#,##0.00");
			try
			{
				if(Double.parseDouble(totalSales.getText())>=0)
				{
					totalSalesAmount = Double.parseDouble(totalSales.getText());
			
					stateTaxAmount = totalSalesAmount * stateRate;
			
			
					JOptionPane.showMessageDialog(null, "County Sales Tax: $" + dollar.format(stateTaxAmount));
				}
				else
				{	
					JOptionPane.showMessageDialog(null, "Please enter a postive decimal number.");
				}
			}
			catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Please enter a postive decimal number.");
			}
		}
	}


	public static void main(String[] args) 
	{
		// activates the constructor and runs the program.
		NorthropSalesTax stw = new NorthropSalesTax();
		
	}
}

