/*Charles Northrop
 * 
 * NorthropCheckBoxes
 * 
 * This program demonstrates the use of checkboxes and menu items.
 * 
 * due 7/15/2018
*/

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class NorthropCheckBoxes extends JFrame
{
	
	private JMenuBar menuBar; // menu bar
	
	private JMenu file; //menu called file
	private JMenu color; // menu call color
	
	private JMenuItem exit; // menu item of file. Exits program.
	
	private JCheckBoxMenuItem blue; //menu item of color. Helps determine color.
	private JCheckBoxMenuItem pink; //menu item of color. Helps determine color.
	private JCheckBoxMenuItem yellow; //menu item of color. Helps determine color.
	
	
	private Color circleColor=Color.BLACK; //sets default color of circle
	
	private static int windowWidth = 1000; //sets width of window
	private static int windowHeight = 1000; // sets Height of window
	
	//constructor where the window is built and displayed
	public NorthropCheckBoxes() 
	{
		setTitle("Color Circle"); //sets  title.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// allows program to end when you click the x in corner

		buildMenuBar();//call of function that builds menu bar
	
		getContentPane().add(new customCircle()); //creates a panel and draws a circle in it.
		pack(); // packs the program.
		setSize(windowWidth,windowHeight); // sets programs size.
		setVisible(true); // allows program to be built.
		
		
	}
	//function that builds the menu bar
	private void buildMenuBar() 
	{
		menuBar = new JMenuBar(); //creates menu bar object
		
		buildFileMenu(); //function call of item that builds file menu.
		buildColorMenu();//function call of item that builds file menu.
		
		menuBar.add(file); //adds file menu to menu bar.
		menuBar.add(color);//adds color menu to menu bar.
		
		
		setJMenuBar(menuBar); //sets menuBar as programs menu.
	}
	
	private void buildFileMenu()
	{
		exit = new JMenuItem("Exit"); //creates exit menu item
		exit.setMnemonic(KeyEvent.VK_X); //allows exit menu item to be activated with alt x
		exit.addActionListener(new exitListener());//registers correct action listener with exit
		
		file = new JMenu("File"); // creates the file menu
		file.setMnemonic(KeyEvent.VK_F); // allows the file menu to be opened with alt F
		
		file.add(exit);//adds the exit menu item to file.
	}
	
	private void buildColorMenu() 
	{
		blue = new JCheckBoxMenuItem("Blue"); //creates the blue color checkBox menu item
		blue.setMnemonic(KeyEvent.VK_B);// allows the check box to be selected with the B key.
		blue.addItemListener(new colorListener());// registers checkbox menu item with the colorListener
		
		
		
		pink = new JCheckBoxMenuItem("Pink"); //creates the pink color checkBox menu item
		pink.setMnemonic(KeyEvent.VK_P);// allows the check box to be selected with the alt p combination.
		pink.addItemListener(new colorListener());// registers checkbox menu item with the colorListener
		
		yellow = new JCheckBoxMenuItem("Yellow");//creates the yellow color checkBox menu item
		yellow.setMnemonic(KeyEvent.VK_Y);// allows the check box to be selected with the alt y combination.
		yellow.addItemListener(new colorListener());// registers checkbox menu item with the colorListener
		
		color = new JMenu("Color"); //creates the color menu
		color.setMnemonic(KeyEvent.VK_C);// allows the color menu to be activate with the letter combination alt c
		color.add(blue); //adds the blue menu checkbox item to the color menu
		color.add(pink); //adds the pink menu checkbox item to the color menu
		color.add(yellow); //adds the yellow menu checkbox item to the color menu
		
	}
	//this class allows the exit menu item to exit the program when it is selected.
	private class exitListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
	}
	//this class allows the color menu check boxes to know what to do when they are selected
	private class colorListener implements ItemListener
	{

		
		public void itemStateChanged(ItemEvent arg0) 
		{
			//if statement determines which colors are selected, then the color is set and the repaint function is called to trigger a redrawing of the circle.
			if(blue.isSelected() && pink.isSelected()&& yellow.isSelected()) 
			{
				circleColor = Color.BLACK; 
				repaint();
			}
			else if(blue.isSelected()&& yellow.isSelected())
			{
				circleColor = Color.BLACK;
				repaint();
			}
			else if(blue.isSelected() && pink.isSelected())
			{
				circleColor = new Color(150, 0, 255);
				repaint();
				
			}
			else if(pink.isSelected() && yellow.isSelected())
			{
				circleColor = new Color(255, 0, 0);
				repaint();
				
			}
			else if(blue.isSelected())
			{
				circleColor = new Color(0, 0, 255);
				repaint();
				
			}
			
			else if(pink.isSelected()) 
			{
				circleColor = Color.PINK;
				repaint();
				
			}
			else if(yellow.isSelected())
			{
				circleColor = Color.YELLOW;
				repaint();
			}
			else
			{
				circleColor = Color.BLACK;
				repaint();
			}
			
		}

		

		
		
	}
	//draws, colors and fills circle, it is only redrawn when window is resized or repaint() is called.
	class customCircle extends JPanel {
		   public void paintComponent(Graphics g) {
		        super.paintComponent(g);
				 g.setColor(circleColor);
			     g.drawOval(100,100,200,200);
			     g.fillOval(100,100, 200, 200);
		    }
		}

	public static void main(String[] args) 
	{
		NorthropCheckBoxes excute = new NorthropCheckBoxes(); // activates constructor which calls the program.
		
	}

}
