import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Staff extends JFrame implements ActionListener
{
	JFrame frame; 							//Object to create main frame
	
	//Creating objects of all the required labels
	JLabel sinfo;
	JLabel sid;	
	JLabel lname; 
	JLabel fname;
	JLabel mi; 
	JLabel address;
	JLabel city;
	JLabel state;
	JLabel tel;
	JLabel email;
	
	//Creating objects of all the required buttons
	JButton insert; 
	JButton update; 
	JButton display;
	JButton clear;
	
	
	//Creating object of TextField to take input from user and store in the file 
	JTextField tid; 
	JTextField tlname;
	JTextField tfname;
	JTextField tmi; 
	JTextField taddress; 
	JTextField tcity;
	JTextField tstate; 
	JTextField ttel;
	JTextField temail;
	
	Database db = new Database();			//Object of database connection class
	
	public Staff()							//Simple Constructor
	{
		frame = new JFrame("Staff");							//Frame created
		frame.setSize(500,500);									//Frame Size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close Operation
		frame.getContentPane();
		frame.setLayout(null);						//Not using any specific layout
		
		
		//Label to give title for the panel
	    sinfo = new JLabel("Staff Information:");
	    sinfo.setFont(new Font("Arial", Font.PLAIN, 14));
        sinfo.setSize(200, 20);
        sinfo.setLocation(50, 50);
        frame.add(sinfo);
 

		//Label for ID along with it's size and location
	    sid = new JLabel("ID");
	    sid.setFont(new Font("Arial", Font.PLAIN, 14));
        sid.setSize(50, 20);
        sid.setLocation(50, 100);
        frame.add(sid);
 
        //TextField for ID to take input from user
        tid = new JTextField();
        tid.setFont(new Font("Arial", Font.PLAIN, 15));
        tid.setSize(150, 20);
        tid.setLocation(80, 100);
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
        lname = new JLabel("Last Name");
	    lname.setFont(new Font("Arial", Font.PLAIN, 14));
        lname.setSize(80, 20);
        lname.setLocation(50, 140);
        frame.add(lname);
 
        //TextField for LastName to take input from user
        tlname = new JTextField();
        tlname.setFont(new Font("Arial", Font.PLAIN, 15));
        tlname.setSize(150, 20);
        tlname.setLocation(120, 140);
        frame.add(tlname);
		frame.setVisible(true);
		
		//Label for firstName
		fname = new JLabel("First Name");
		fname.setFont(new Font("Arial", Font.PLAIN, 14));
	    fname.setSize(80, 20);
	    fname.setLocation(275, 140);
	    frame.add(fname);
	 
	    //TextField for firstName to take input from user
	    tfname = new JTextField();
	    tfname.setFont(new Font("Arial", Font.PLAIN, 15));
	    tfname.setSize(150, 20);
	    tfname.setLocation(350, 140);
	    frame.add(tfname);
	    
	    //Label for Gender
	    mi = new JLabel("mi");
		mi.setFont(new Font("Arial", Font.PLAIN, 14));
	    mi.setSize(80, 20);
	    mi.setLocation(510, 140);
	    frame.add(mi);
	 
	    //TextField for Gender to take input from user
	    tmi = new JTextField();
	    tmi.setFont(new Font("Arial", Font.PLAIN, 15));
	    tmi.setSize(40, 20);
	    tmi.setLocation(535, 140);
	    frame.add(tmi);
	    
	    //Label for Address
	    address = new JLabel("Address");
	    address.setFont(new Font("Arial", Font.PLAIN, 14));
		address.setSize(80, 20);
		address.setLocation(50, 180);
		frame.add(address);
		 
		//TextField for Address to take input from user
		taddress = new JTextField();
		taddress.setFont(new Font("Arial", Font.PLAIN, 15));
		taddress.setSize(200, 20);
		taddress.setLocation(110, 180);
		frame.add(taddress);
		
		//Label for city
		city = new JLabel("City");
	    city.setFont(new Font("Arial", Font.PLAIN, 14));
		city.setSize(80, 20);
		city.setLocation(50, 220);
		frame.add(city);
		 
		//TextField for city to take input from user
		tcity = new JTextField();
		tcity.setFont(new Font("Arial", Font.PLAIN, 15));
		tcity.setSize(200, 20);
		tcity.setLocation(87, 220);
		frame.add(tcity);
		
		//Label for state
		state = new JLabel("State");
	    state.setFont(new Font("Arial", Font.PLAIN, 14));
		state.setSize(80, 20);
		state.setLocation(290, 220);
		frame.add(state);
		 
		//TextField for state to take input from user
		tstate = new JTextField();
		tstate.setFont(new Font("Arial", Font.PLAIN, 15));
		tstate.setSize(40, 20);
		tstate.setLocation(330, 220);
		frame.add(tstate);
		
		
		//Label for telephone
		tel = new JLabel("Telephone");
	    tel.setFont(new Font("Arial", Font.PLAIN, 14));
		tel.setSize(80, 20);
		tel.setLocation(50, 260);
		frame.add(tel);
		 
		//TextField for Telephone to take input from user
		ttel = new JTextField();
		ttel.setFont(new Font("Arial", Font.PLAIN, 15));
		ttel.setSize(180, 20);
		ttel.setLocation(120, 260);
		frame.add(ttel);
	
		//Label for Email
		email = new JLabel("Email");
	    email.setFont(new Font("Arial", Font.PLAIN, 14));
		email.setSize(80, 20);
		email.setLocation(305, 260);
		frame.add(email);
		 
		//TextField for Email to take input from user
		temail = new JTextField();
		temail.setFont(new Font("Arial", Font.PLAIN, 15));
		temail.setSize(150, 20);
		temail.setLocation(350, 260);
		frame.add(temail);
		    
		//Code for Insert Button along with size and location
		insert = new JButton("Insert");
        insert.setFont(new Font("Arial", Font.PLAIN, 15));
        insert.setSize(100, 20);
        insert.setLocation(210, 300);
        insert.addActionListener(this);
        frame.add(insert);

        //Code for update button along with size and location
        update = new JButton("Update");
        update.setFont(new Font("Arial", Font.PLAIN, 15));
        update.setSize(100, 20);
        update.setLocation(320, 300);
        update.addActionListener(this);
        frame.add(update);

        //Code for display button along with size and location
        //It displays data into 
        display = new JButton("View");
        display.setFont(new Font("Arial", Font.PLAIN, 15));
        display.setSize(100, 20);
        display.setLocation(100, 300);
        display.addActionListener(this);
        frame.add(display);

        //Code for clear button along with size and location
        //This button is used to clear data in TextField Manually
        clear = new JButton("Clear");
        clear.setFont(new Font("Arial", Font.PLAIN, 15));
        clear.setSize(100, 20);
        clear.setLocation(430, 300);
        clear.addActionListener(this);
        frame.add(clear);
		        

        //Inserting data into SQL Table
        insert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
				   EmailValidator emailValidator = new EmailValidator();    //Code to check the validation of new Email ID Entered
               	   if(!emailValidator.validate(temail.getText().trim())) 
               	   {
               		   JOptionPane.showMessageDialog(null,
                              	"Invalid Email.");
               	   }
               	   else
               	   {
					insertData();
               	   }
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        	
        });
        
        //Update existing data
        update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
					EmailValidator emailValidator = new EmailValidator();    //Code to check the validation of new Email ID Entered
	               	if(!emailValidator.validate(temail.getText().trim())) 
	               	{
	               	   JOptionPane.showMessageDialog(null,
	                            	"Invalid Email.");
	               	}
	               	else
	               	{
	               		updateData();
	               	}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        	
        });
        
        //Display data from table into textFields.
        display.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					viewData();
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

	//Method to display data from table into textFields.
	public void viewData() throws ClassNotFoundException, SQLException 
	{
		//Creating connection with database.
		Connection conn = db.db_connection();
		Statement statement = conn.createStatement();
		
		
		String id = tid.getText();
		if(tid.getText().isEmpty())		//Condition to check if id textField is empty.
		{

			JOptionPane.showMessageDialog(null,
					"Enter staff id whose data you wanna display.");
		}
		else
		{
		
			String query = "select * from staff where id = '"+id+"'";
			
			ResultSet resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) 	//Condition to check if resultSet is empty or not
			{
				String rid = resultSet.getString("id");
					tid.setText(rid);
					tlname.setText(resultSet.getString("lastName"));		
					tfname.setText(resultSet.getString("firstName"));
					tmi.setText(resultSet.getString("mi"));
					taddress.setText(resultSet.getString("address"));
					tcity.setText(resultSet.getString("city"));
					tstate.setText(resultSet.getString("state"));
					ttel.setText(resultSet.getString("telephone"));
					temail.setText(resultSet.getString("email"));
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ID dosen't exists.");
				clearData();
			}
			
			conn.close();
		}
	}
	
	//Method to insert data into Table
	public void insertData() throws ClassNotFoundException, SQLException 
	{

		//Creating connection with database.
		Connection conn = db.db_connection();
		
		//try catch block to handle exception
		try
		{
			Statement statement = conn.createStatement();
			
			//take data from textFields into variables
			String id = tid.getText();
			String lastName = tlname.getText();
			String firstName = tfname.getText();
			String mi = tmi.getText();
			String address = taddress.getText();
			String city = tcity.getText();
			String state = tstate.getText();
			String tel = ttel.getText();
			String email = temail.getText();
			
			//condition to check if any textField is empty or not 
			if(id.isEmpty() || lastName.isEmpty() || firstName.isEmpty() || mi.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || tel.isEmpty() || email.isEmpty())
			{
				JOptionPane.showMessageDialog(null,
						"Textfield cannot be empty while inserting the data. Enter complete Data.");
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
					//code to insert data into table from textFields.
					PreparedStatement pstmt = conn.prepareStatement("INSERT INTO staff(id, lastname, firstname, mi, address, city, state, telephone, email) VALUES (?,?,?,?,?,?,?,?,?)");
					pstmt.setString(1, id );
					pstmt.setString(2, lastName);
					pstmt.setString(3, firstName);
					pstmt.setString(4, mi);
					pstmt.setString(5,address);
					pstmt.setString(6, city);
					pstmt.setString(7, state);
					pstmt.setString(8, tel);
					pstmt.setString(9,email);
				
					pstmt.executeUpdate();
		
					 JOptionPane.showMessageDialog(null,
						"Staff information submitted Successfully. To view information click on Display.");
					 clearData();
		
				}
			}
		} //Handling different exception 
		catch(SQLIntegrityConstraintViolationException ex)
		{
			JOptionPane.showMessageDialog(null, "Error! Data already Exsists.");
			ex.printStackTrace();
		}
		catch(NumberFormatException ne)
		{
			JOptionPane.showMessageDialog(null, "Error! Enter id in correct format.");
			ne.printStackTrace();
		}
		catch (Exception exc) 
		{
			JOptionPane.showMessageDialog(null, "Error! Please enter correct data.");
			exc.printStackTrace();
		}
		
		
		conn.close();
		
	}
	
	//method to update existing data
	public void updateData() throws ClassNotFoundException, SQLException 
	{
		//creating connection with database.
		Connection conn = db.db_connection();
		try
		{
			Statement statement = conn.createStatement();
			
			//take data from textFields into variables.
			String id = tid.getText();
			String lastName = tlname.getText();
			String firstName = tfname.getText();
			String mi = tmi.getText();
			String address = taddress.getText();
			String city = tcity.getText();
			String state = tstate.getText();
			String tel = ttel.getText();
			String email = temail.getText();
			
			//condition to check if any textField is empty or not 
			if(id.isEmpty() || lastName.isEmpty() || firstName.isEmpty() || mi.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || tel.isEmpty() || email.isEmpty())
			{
				JOptionPane.showMessageDialog(null,
						"Textfield cannot empty while inserting the data. Enter complete Data.");
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
					String query = "update staff set id = '"+id+"', lastName = '"+lastName+"', firstName = '"+firstName+"', mi = '"+mi+"', address = '"+address+"', city = '"+city+"', state = '"+state+"', telephone = '"+tel+"', email = '"+email+"' where id = '"+id+"'";
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
		
	}
	
	//method to clear all the textFields
	public void clearData() 
	{

		JOptionPane.showMessageDialog(null, "All fields cleared.");
		tid.setText("");
		tlname.setText("");
		tfname.setText("");
		tmi.setText("");
		taddress.setText("");
		tcity.setText("");
		tstate.setText("");
		ttel.setText("");
		temail.setText("");
		
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

/*
/*************************************************************************************************
*  Course_Name – Assignment x                                                                                                                                *

*  I declare that this assignment is my own work in accordance with Humber Academic Policy.        *

*  No part of this assignment has been copied manually or electronically from any other source       *

*  (including web sites) or distributed to other students/social media.                                                       *
                                                                                                                                                                             
*  Name: Karan Punjabi and Richu Thankachan Student ID: N01514624 & N01516068 Date: 05-07-2022 
*/

