import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TaskThreadDemo 
{ 
	private static JFrame frame; 							//Object to create main frame
	
	//Creating objects of all the required labels
	private static JLabel output;	

	//Creating objects of display buttin
	private static JButton display;
	
	//Creating objects of textArea
	private static JTextArea tout;

	//Function named GUI with frame, label, button and textArea
	public static void GUI()
	{
		frame = new JFrame("Thread");							//Frame created
		frame.setSize(500,500);									//Frame Size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close Operation
		frame.getContentPane();
		frame.setLayout(null);						//Not using any specific layout
	
	

		//Label for Output along with it's size and location
		output = new JLabel("Output: ");
		output.setFont(new Font("Arial", Font.PLAIN, 14));
		output.setSize(150, 20);
		output.setLocation(60, 200);
		frame.add(output);
		
		 //Code for display button along with size and location
        //It displays data into TextArea
        display = new JButton("Display");
        display.setFont(new Font("Arial", Font.PLAIN, 15));
        display.setSize(100, 20);
        display.setLocation(50, 300);
        frame.add(display);
        
        //Code for TextArea
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(400, 400);
        tout.setLocation(200, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        frame.add(tout);
        
        //Set frame Visibility as true
        frame.setVisible(true);
        
        	
        
        

	}
	
	//Creating a function which appends resultSet to textArea
	public void setText(String result)
	{
		
		tout.append(result);
	}
	
	//Main function
	public static void main(String[] args) 
	{

		//Calling GUI Function
		GUI();
		ActionListener run = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
				{
		// Create tasks

		tout.setText(null);		
		
		Runnable printA = new PrintChar('a', 200); 

		Runnable printB = new PrintChar('b', 200); 

		Runnable print100 = new PrintNum(100); 

		// Create threads

		Thread thread1 = new Thread(printA); 

		Thread thread2 = new Thread(printB); 

		Thread thread3 = new Thread(print100); 

		thread2.setPriority(Thread.MAX_PRIORITY); 

		// Start threads 


		thread2.start(); 

		thread3.start(); 
		
		thread1.start(); 
				}				
		};
		//ClickEvent on button
		display.addActionListener(run);

	} 
} 



// The task for printing a specified character in specified times

class PrintChar implements Runnable 
{ 

	private char charToPrint; 

	// The character to print

	private int times; 

	// The times to repeat

	/** Construct a task with specified character and number of * times to print the character */ 



	public PrintChar(char c, int t)
	{ 
		charToPrint = c; 
		times = t; 
	} 

	@Override 

	/** Override the run() method to tell the system * what the task to perform */ 

	public void run() 
	{ 
// TODO Auto-generated method stub
				for (int i = 0; i < times; i++) 

				{ 
					TaskThreadDemo tt = new TaskThreadDemo();
					tt.setText(Character.toString(charToPrint));
					try {
						if (i>20&&charToPrint=='b')Thread.sleep(1);
					} catch (InterruptedException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					
					
				} 
				
				
				
			

	} 
} 



// The task class for printing number from 1 to n for a given n 

class PrintNum implements Runnable 
{

	private int lastNum; 

	/** Construct a task for printing 1, 2, ... i */ 

	public PrintNum(int n) 
	{ 	
		lastNum = n; 
	} 

	@Override 

	/** Tell the thread how to run */ 

	public void run() 
	{ 

		TaskThreadDemo tt = new TaskThreadDemo();
				for (int i = 1; i <= lastNum; i++)

				{ 
		
					tt.setText(" " + Integer.toString(i));
					if (i>50)Thread.yield();
				} 
		

	} 
}

