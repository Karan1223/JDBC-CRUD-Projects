package ca.myjava.update;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class UpdateTableUpdateResultSet 
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Countrystatic c = new Countrystatic();

	}

}

class Countrystatic extends JFrame implements ActionListener
{
	JFrame frame; 							//Object to create main frame
	
	//Creating objects of all the required labels
	JLabel lid;	
	JLabel lcname; 
	JLabel lccode; 
	JLabel llife;
	JLabel lcontinent;
	
	//Creating objects of all the required buttons
	JButton update; 
	JButton clear;
	
	
	//Creating object of TextField to take input from user and store in the file 
	JTextField tid; 
	JTextField tcname;
	JTextField tccode; 
	JTextField tlife; 
	JTextField tcontinent;
				//Object of database connection class
	
	public Connection db_connection() throws ClassNotFoundException, SQLException 
	{
		//Code to connect to database
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
			
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","N01514624","oracle");
		
		//returning connection object
		return conn;
	}
	public Countrystatic()							//Simple Constructor
	{
		frame = new JFrame("Staff");							//Frame created
		frame.setSize(500,500);									//Frame Size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close Operation
		frame.getContentPane();
		frame.setLayout(null);						//Not using any specific layout
		
		

		//Label for ID along with it's size and location
	    lid = new JLabel("ID");
	    lid.setFont(new Font("Arial", Font.PLAIN, 14));
        lid.setSize(50, 20);
        lid.setLocation(100, 100);
        frame.add(lid);
 
        //TextField for ID to take input from user
        tid = new JTextField();
        tid.setFont(new Font("Arial", Font.PLAIN, 15));
        tid.setSize(150, 20);
        tid.setLocation(210, 100);
        frame.add(tid);
        
        //Dosen't let user enter characters for ID
        tid.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                    JOptionPane.showMessageDialog(null,
                	"Can't enter string. Enter Number.");
                }
             }
        });
        
        //Label for LastName
        lcname = new JLabel("Country Name");
	    lcname.setFont(new Font("Arial", Font.PLAIN, 14));
        lcname.setSize(100, 20);
        lcname.setLocation(100, 150);
        frame.add(lcname);
 
        //TextField for LastName to take input from user
        tcname = new JTextField();
        tcname.setFont(new Font("Arial", Font.PLAIN, 15));
        tcname.setSize(150, 20);
        tcname.setLocation(210, 150);
        frame.add(tcname);
		frame.setVisible(true);
		   
	    //Label for Gender
	    lccode = new JLabel("Country Code");
		lccode.setFont(new Font("Arial", Font.PLAIN, 14));
	    lccode.setSize(100, 20);
	    lccode.setLocation(100, 200);
	    frame.add(lccode);
	 
	    //TextField for Gender to take input from user
	    tccode = new JTextField();
	    tccode.setFont(new Font("Arial", Font.PLAIN, 15));
	    tccode.setSize(150, 20);
	    tccode.setLocation(210, 200);
	    frame.add(tccode);
	    
	    //Label for Address
	    lcontinent = new JLabel("Continent");
	    lcontinent.setFont(new Font("Arial", Font.PLAIN, 14));
		lcontinent.setSize(100, 20);
		lcontinent.setLocation(100, 250);
		frame.add(lcontinent);
		 
		//TextField for Address to take input from user
		tcontinent = new JTextField();
		tcontinent.setFont(new Font("Arial", Font.PLAIN, 15));
		tcontinent.setSize(150, 20);
		tcontinent.setLocation(210, 250);
		frame.add(tcontinent);
		
		//Label for city
		llife = new JLabel("Life Expectancy");
	    llife.setFont(new Font("Arial", Font.PLAIN, 14));
		llife.setSize(100, 20);
		llife.setLocation(100, 300);
		frame.add(llife);
		 
		//TextField for city to take input from user
		tlife = new JTextField();
		tlife.setFont(new Font("Arial", Font.PLAIN, 15));
		tlife.setSize(150, 20);
		tlife.setLocation(210, 300);
		frame.add(tlife);
		
		//Code for update Button along with size and location
		update = new JButton("Update");
        update.setFont(new Font("Arial", Font.PLAIN, 15));
        update.setSize(100, 20);
        update.setLocation(110, 350);
        update.addActionListener(this);
        frame.add(update);

        //Code for clear button along with size and location
        //This button is used to clear data in TextField Manually
        clear = new JButton("Clear");
        clear.setFont(new Font("Arial", Font.PLAIN, 15));
        clear.setSize(100, 20);
        clear.setLocation(230, 350);
        clear.addActionListener(this);
        frame.add(clear);
		        

        //updating data into SQL Table
        update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
				  
					updateData();
               	   
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        	
        });
        

        //Clear all textFields.
        clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearData();
			}
        	
        });

	    
		frame.setVisible(true);
	    
		
		
	}
	//method to update existing data
		public void updateData() throws ClassNotFoundException, SQLException 
		{
			//creating connection with database.
			Connection conn = db_connection();
			try
			{
				Statement statement = conn.createStatement();
				
				//take data from textFields into variables
				String id = tid.getText();
				String name = tcname.getText();
				String code = tccode.getText();
				String continent = tcontinent.getText();
				String life = tlife.getText();
				
				//condition to check if any textField is empty or not 
				if(id.isEmpty() || name.isEmpty() || code.isEmpty() || continent.isEmpty() || life.isEmpty())
				{
					JOptionPane.showMessageDialog(null,
							"Textfield cannot empty while updateing the data. Enter complete Data.");
				}
				
				else
				{
					//condition to check that id should not be negative and 0.
					int i = Integer.parseInt(id);
					if(i<=0)
					{
						JOptionPane.showMessageDialog(null,
								"Id should be greater than zero. Enter Data again.");
						clearData();
					}
					else
					{
						String query = "update country set id = '"+id+"', name = '"+name+"', ccode = '"+code+"', continent = '"+continent+"', lifeexpec = '"+life+"' where id = '"+id+"'";
						statement.execute(query);
						JOptionPane.showMessageDialog(null,
								"Staff Information updated Successfully. To view information click on Display.");
						clearData();
						conn.close();
					}
				}
			}catch(NumberFormatException ne)
			{
				JOptionPane.showMessageDialog(null, "Error! Enter id in correct format.");
				ne.printStackTrace();
			}
			catch (Exception exc) 
			{
				JOptionPane.showMessageDialog(null, "Error! Please enter correct data.");
				exc.printStackTrace();
			}
			
		}		//method to clear all the textFields
	public void clearData() 
	{

		JOptionPane.showMessageDialog(null, "All fields cleared.");
		tid.setText("");
		tcname.setText("");
		tccode.setText("");
		tcontinent.setText("");
		tlife.setText("");
		
	}







	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

/*
/*************************************************************************************************
*  Course_Name � Assignment x                                                                                                                                *

*  I declare that this assignment is my own work in accordance with Humber Academic Policy.        *

*  No part of this assignment has been copied manually or electronically from any other source       *

*  (including web sites) or distributed to other students/social media.                                                       *
                                                                                                                                                                             
*  Name: Karan Punjabi and Richu Thankachan Student ID: N01514624 & N01516068 Date: 05-07-2022 
*/



