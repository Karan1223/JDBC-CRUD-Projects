package ca.myjava.update;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateTableStaticSQL 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		CountryS cs = new CountryS();

	}

}


class CountryS extends JFrame implements ActionListener
{
	JFrame frame; 							//Object to create main frame
	
	//Creating objects of all the required labels
	JLabel lid;	
	
	//Creating objects of all the required buttons
	JButton delete; 
	JButton clear;
	
	
	//Creating object of TextField to take input from user and store in the file 
	JTextField tid; 
				//Object of database connection class
	
	public Connection db_connection() throws ClassNotFoundException, SQLException 
	{
		//Code to connect to database
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
			
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","N01514624","oracle");
		
		//returning connection object
		return conn;
	}
	public CountryS()							//Simple Constructor
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
    	
        //Code for update Button along with size and location
		delete = new JButton("Delete");
        delete.setFont(new Font("Arial", Font.PLAIN, 15));
        delete.setSize(100, 20);
        delete.setLocation(110, 350);
        delete.addActionListener(this);
        frame.add(delete);

        //Code for clear button along with size and location
        //This button is used to clear data in TextField Manually
        clear = new JButton("Clear");
        clear.setFont(new Font("Arial", Font.PLAIN, 15));
        clear.setSize(100, 20);
        clear.setLocation(230, 350);
        clear.addActionListener(this);
        frame.add(clear);
		        

        //updating data into SQL Table
        delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
				  
					deleteData();
               	   
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
		public void deleteData() throws ClassNotFoundException, SQLException 
		{
			//creating connection with database.
			Connection conn = db_connection();
			try
			{
				Statement statement = conn.createStatement();
				
				//take data from textFields into variables
				String id = tid.getText();
				
				//condition to check if any textField is empty or not 
				if(id.isEmpty())
				{
					JOptionPane.showMessageDialog(null,
							"Textfield cannot empty while deleting the data. Enter complete Data.");
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
						String query = "delete from country  where id = '"+id+"'";
						statement.execute(query);
						JOptionPane.showMessageDialog(null,
								"Country table updated Successfully. To view information click on Display.");
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
			
	}







	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}


