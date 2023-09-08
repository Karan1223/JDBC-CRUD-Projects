package ca.myjava.query;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

import javax.swing.*;

public class QueryTablePreparedStm2 
{


	public static void main(String[] args) throws Exception 
	{
		Country c =new Country();
	}

}


class Country extends JFrame implements ActionListener
{
	private static JFrame frame; 							//Object to create main frame
	
	//Creating objects of all the required labels
	JLabel life;
	JLabel range;	

	//Creating object of TextField to take input from user and store in the file 
	JTextField from; 
	JTextField to;
	
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
		frame = new JFrame("Life Expectancy");							//Frame created
		frame.setSize(500,500);									//Frame Size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close Operation
		frame.getContentPane();
		frame.setLayout(null);						//Not using any specific layout
		
		

		//Label for ID along with it's size and location
	    life = new JLabel("Life Expectancy: ");
	    life.setFont(new Font("Arial", Font.PLAIN, 14));
        life.setSize(150, 20);
        life.setLocation(50, 200);
        frame.add(life);
 
        //TextField for ID to take input from user
        from = new JTextField();
        from.setFont(new Font("Arial", Font.PLAIN, 15));
        from.setSize(100, 20);
        from.setLocation(170, 200);
        frame.add(from);
        
        
        //Label for LastName
        range = new JLabel("to");
	    range.setFont(new Font("Arial", Font.PLAIN, 14));
        range.setSize(80, 20);
        range.setLocation(280, 200);
        frame.add(range);
 
        //TextField for LastName to take input from user
        to = new JTextField();
        to.setFont(new Font("Arial", Font.PLAIN, 15));
        to.setSize(100, 20);
        to.setLocation(310, 200);
        frame.add(to);
        

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
	
	public void viewData() throws ClassNotFoundException, SQLException 
	{

		Connection conn = db_connection();
		try
		{
		//Creating connection with database.
		tout.setText("");
		String from1 = from.getText();
		String to1 = to.getText();
		if(from.getText().isEmpty() || to.getText().isEmpty())		//Condition to check if id textField is empty.
		{

			JOptionPane.showMessageDialog(null,
					"Enter range of life Expectancy.");
		}
		else
		{
			
			PreparedStatement pstmt =
					  conn.prepareStatement("select * from country where lifeexpec BETWEEN ? AND ?");
					  
					  pstmt.setString(1, from1); 
					  pstmt.setString(2, to1);
					  
					  ResultSet resultSet = pstmt.executeQuery(); 
			while (resultSet.next()) 	//Condition to check if resultSet is empty or not
			{
				String rid = resultSet.getString("id");
				String name = resultSet.getString("name");
				String ccode = resultSet.getString("ccode");
				String continent = resultSet.getString("continent");
				String life = resultSet.getString("lifeexpec");
				
				
				tout.append("ID: "+rid.trim()+", Country Name: "+name+", Country Code: "+ccode+", Continent: "+continent+", Life Expectancy: "+life+"\n");
			}
		}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Data dosen't exists.");
			 clearData();
		}	

		conn.close();

	

		}

	

	public void clearData() 
	{

		JOptionPane.showMessageDialog(null, "Clear All Fields?");
		from.setText("");
		to.setText("");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
