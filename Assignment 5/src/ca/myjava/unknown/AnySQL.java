package ca.myjava.unknown;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AnySQL 
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Country cs = new Country(); 

	}

}


class Country extends JFrame implements ActionListener
{
	private static JFrame frame; 							//Object to create main frame
	
	//Creating objects of all the required labels
	JLabel lbquery;
	

	//Creating object of TextField to take input tquery user and store in the file 
	JTextField tquery; 

	
	JButton display;
	JButton clear;
	
	JTextArea tout;
	
	public Connection db_connection() throws ClassNotFoundException, SQLException 
	{
		//Code to connect to database
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
			
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","N01514624","oracle");
		
		//returning connection object
		return conn;
	}
	
	public Country() throws Exception
	{
		frame = new JFrame("Country Table");							//Frame created
		frame.setSize(500,500);									//Frame Size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close Operation
		frame.getContentPane();
		frame.setLayout(null);						//Not using any specific layout
		
		

		//Label for ID along with it's size and location
	    lbquery = new JLabel("Enter Query: ");
	    lbquery.setFont(new Font("Arial", Font.PLAIN, 14));
        lbquery.setSize(150, 20);
        lbquery.setLocation(50, 200);
        frame.add(lbquery);
 
        //TextField for ID to take input tquery user
        tquery = new JTextField();
        tquery.setFont(new Font("Arial", Font.PLAIN, 15));
        tquery.setSize(200, 20);
        tquery.setLocation(150, 200);
        frame.add(tquery);
        
        
        //Code for display button along with size and location
        //It displays data into TextArea
        display = new JButton("Display");
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
        clear.setLocation(250, 300);
        clear.addActionListener(this);
        frame.add(clear);
        
        //Code for TextArea
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(600, 600);
        tout.setLocation(600, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        frame.add(tout);
        
        //Display data tquery table into textFields.
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
	
	public void viewData() throws ClassNotFoundException, SQLException 
	{
		tout.setText("");
		Connection conn = db_connection();
		try
		{
		//Creating connection with database.
			
			
			Statement statement = conn.createStatement();
		
			if(tquery.getText().isEmpty())		//Condition to check if id textField is empty.
			{
	
				JOptionPane.showMessageDialog(null,
						"Enter query.");
			}
			else
			{
				
				String query = tquery.getText();
				
				System.out.print(query);
				
				ResultSet resultSet = statement.executeQuery(query);
				tout.setText("");
				while (resultSet.next())				  //Condition to check if resultSet is empty or not 
				{
						String rid = resultSet.getString("id");
						String name = resultSet.getString("name");
						String ccode = resultSet.getString("ccode");
						String continent = resultSet.getString("continent");
						String life = resultSet.getString("lifeexpec");
						tout.append("ID: "+rid.trim()+", Country Name: "+name+", Country Code: "+ccode+", Continent: "+continent+", Life Expectancy: "+life+"\n");
						
						
				}
				
				
			}
							
		}catch(Exception e)
		{

			JOptionPane.showMessageDialog(null, "Invalid query.");
			 clearData();
		}
		conn.close();
	}
	
	

	public void clearData() 
	{

		JOptionPane.showMessageDialog(null, "Clear All Fields?");
		tquery.setText("");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}




