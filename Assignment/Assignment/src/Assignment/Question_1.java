package Assignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Question_1 {
	//public static String output = "";

	public static JTextArea text;
	
	public static void GUI()
	{
		//GUI Creation
				JTextArea text = new JTextArea();
				JFrame framewindow = new JFrame("Output");
				framewindow.setSize(800,800);		
				framewindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close Operation
				text.setLineWrap(true);  //wrapping the content of textarea
				framewindow.setVisible(true);
				framewindow.add(text);
				text.setSize(400,500);
	}
	public void setText(String result)
	{
		text.append(result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		GUI();
		
			// Create tasks

			Runnable printA = new PrintChar('a', 5000, text); 

			Runnable printB = new PrintChar('b', 2000, text); 

			Runnable print100 = new PrintNum(1000); 

			// Create threads

			Thread thread1 = new Thread(printA); 

			Thread thread2 = new Thread(printB); 

			Thread thread3 = new Thread(print100); 

			thread1.setPriority(Thread.MAX_PRIORITY); 

			// Start threads 

			thread1.start(); 

			thread2.start(); 

			thread3.start(); 
		} 
	} 



	// The task for printing a specified character in specified times

	class PrintChar implements Runnable 
	{ 

		private char charToPrint; 

		private int times; 

		public JTextArea text;
		

		/** Construct a task with specified character and number of * times to print the character */ 



		public PrintChar(char c, int t,JTextArea ta)
		{ 
			charToPrint = c; 
			times = t;
			text = ta;
		} 

		@Override 

		/** Override the run() method to tell the system * what the task to perform */ 

		public void run() 
		{ 

			//new GUI();
			for (int i = 0; i < times; i++) 

			{ 
				Question_1 q = new Question_1();
				//Question_1.output = Question_1.output +  charToPrint;
				//System.out.print(charToPrint); 
				q.setText(" " + charToPrint);
			} 
		} 
	} 



	// The task class for printing number from 1 to n for a given n 

	class PrintNum implements Runnable 
	{
		public JTextArea ta;

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

			for (int i = 1; i <= lastNum; i++)

			{ 
			
				Question_1 q = new Question_1();
				//Question_1.output = Question_1.output +  i;
				q.setText(" " + i); 
				Thread.yield(); 
			} 
		} 
	}

	/* class GUI extends JFrame implements ActionListener
	{
		private static JFrame frame; 	//Object to create main frame
		
		//Creating objects of all the required labels
		JLabel output;	

		
		JButton display;
		
		
		JTextArea tout;
		
		public GUI()
		{
			frame = new JFrame("OUTPUT");							//Frame created
			frame.setSize(500,500);		
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close Operation
			frame.getContentPane();
			frame.setLayout(null);		
		
		

			//Label for Output
			output = new JLabel("Output: ");
			output.setFont(new Font("Arial", Font.PLAIN, 14));
			output.setSize(150, 20);
			output.setLocation(50, 200);
			frame.add(output);
			
			 //Code for display button along with size and location
	        //It displays data into TextArea
	        display = new JButton("Show");
	        display.setFont(new Font("Arial", Font.PLAIN, 15));
	        display.setSize(100, 300);
	        display.setLocation(100, 300);
	        display.addActionListener((ActionListener) this);
	        frame.add(display);
	        
	        //Code for TextArea
	        tout = new JTextArea();
	        tout.setFont(new Font("Arial", Font.PLAIN, 15));
	        tout.setSize(600, 600);
	        tout.setLocation(600, 100);
	        tout.setLineWrap(true);
	        tout.setEditable(false);
	        frame.add(tout);
	        
	        frame.setVisible(true);

		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			if(e.getSource() == display) {
				tout.setText(Question_1.output);
			
		}
	}

} */