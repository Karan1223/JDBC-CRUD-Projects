import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class Customer extends JFrame implements ActionListener
{

	//Variable Created
		private int id;                         //Customer ID variable to take input from user
		private String name;					//Customer Name variable to take input from user
		private String phone;					//Customer Phone Number variable to take input from user
		private String email;					//Email variable to take input from user
		private String code;					//Postal Code variable to take input from user
		
		private int uid;                        //Updated Customer ID variable to take input from user
		private String uname;					//Updated Customer Name variable to take input from user
		private String uphone;					//Updated phone number variable to take input from user
		private String uemail;					//Updated Email ID variable to take input from user
		private String ucode;					//Updated Postal code variable to take input from user
		
	
	JFrame frame; 							//Object to create main frame
	
	//Creating objects of all the required labels
	JLabel cid;	
	JLabel cname; 
	JLabel cphone;
	JLabel cemail; 
	JLabel ccode;
	
	JLabel ucid;	
	JLabel ucname; 
	JLabel ucphone;
	JLabel ucemail; 
	JLabel uccode;
		
	//Creating objects of all the required buttons
	JButton sub; 
	JButton reset; 
	JButton display;
	
	//Creating TextArea object to display contents of the file
	JTextArea  tout;
	
	//Creating object of TextField to take input from user and store in the file 
	JTextField tcid; 
	JTextField tcname;
	JTextField tcphone;
	JTextField tcemail; 
	JTextField tccode; 
	
	JTextField utcid; 
	JTextField utcname;
	JTextField utcphone;
	JTextField utcemail; 
	JTextField utccode; 
	
	
	public Customer()		//Constructor which gets called automatically when object is created
	{

		
		frame = new JFrame("Customer Management Application");		//Frame created
		frame.setSize(1000,1000);									//Frame Size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	    //Close Operation
		frame.getContentPane();
		frame.setLayout(null);   									//Not using any specific layout
	    
		//Label for ID along with it's size and location
	    cid = new JLabel("Customer Id: ");
	    cid.setFont(new Font("Arial", Font.PLAIN, 14));
        cid.setSize(190, 20);
        cid.setLocation(50, 50);
        frame.add(cid);
 
        //TextField for ID to take input from user
        tcid = new JTextField();
        tcid.setFont(new Font("Arial", Font.PLAIN, 15));
        tcid.setSize(190, 20);
        tcid.setLocation(200, 50);
        frame.add(tcid);
        
        //Dosen't let user enter characters for ID
        tcid.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                    JOptionPane.showMessageDialog(null,
                	"Can't enter string. Enter Number.");
                }
             }
        });
 
		//Label for Name along with it's size and location
        cname = new JLabel("Customer Name: ");
        cname.setFont(new Font("Arial", Font.PLAIN, 14));
        cname.setSize(210, 20);
        cname.setLocation(50, 100);
        frame.add(cname);

        //TextField for Name to take input from user
        tcname = new JTextField();
        tcname.setFont(new Font("Arial", Font.PLAIN, 15));
        tcname.setSize(190, 20);
        tcname.setLocation(200, 100);
        frame.add(tcname);

		//Label for Phone Number along with it's size and location
        cphone = new JLabel("Phone Number: ");
        cphone.setFont(new Font("Arial", Font.PLAIN, 14));
        cphone.setSize(190, 20);
        cphone.setLocation(50, 150);
        frame.add(cphone);

        //TextField for Phone Number to take input from user
        tcphone = new JTextField();
        tcphone.setFont(new Font("Arial", Font.PLAIN, 15));
        tcphone.setSize(190, 20);
        tcphone.setLocation(200, 150);
        frame.add(tcphone);
              
		//Label for Email ID along with it's size and location
	    cemail = new JLabel("Email: ");
	    cemail.setFont(new Font("Arial", Font.PLAIN, 14));
        cemail.setSize(200, 20);
        cemail.setLocation(50, 200);
        frame.add(cemail);

        //TextField for Email ID to take input from user
        tcemail = new JTextField();
        tcemail.setFont(new Font("Arial", Font.PLAIN, 15));
        tcemail.setSize(190, 20);
        tcemail.setLocation(200, 200);
        frame.add(tcemail);
        
     


		//Label for Postal Code along with it's size and location
        ccode = new JLabel("Postal Code: ");
        ccode.setFont(new Font("Arial", Font.PLAIN, 14));
        ccode.setSize(200, 20);
        ccode.setLocation(50, 250);
        frame.add(ccode);

        //TextField for Postal code to take input from user
        tccode = new JTextField();
        tccode.setFont(new Font("Arial", Font.PLAIN, 15));
        tccode.setSize(190, 20);
        tccode.setLocation(200, 250);
        frame.add(tccode);
        

		//Label for New ID along with it's size and location
	    ucid = new JLabel("Update Customer Id: ");
	    ucid.setFont(new Font("Arial", Font.PLAIN, 14));
        ucid.setSize(190, 20);
        ucid.setLocation(400, 50);
        frame.add(ucid);
 
        //TextField for New ID to take input from user
        utcid = new JTextField();
        utcid.setFont(new Font("Arial", Font.PLAIN, 15));
        utcid.setSize(190, 20);
        utcid.setLocation(600, 50);
        frame.add(utcid);
        
        //Dosen't let user enter characters for ID
        utcid.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                    JOptionPane.showMessageDialog(null,
                	"Can't enter string. Enter Number.");
                }
             }
        });
        

		//Label for New Name along with it's size and location
        ucname = new JLabel("Update Customer Name: ");
        ucname.setFont(new Font("Arial", Font.PLAIN, 14));
        ucname.setSize(210, 20);
        ucname.setLocation(400, 100);
        frame.add(ucname);

        //TextField for New Name to take input from user
        utcname = new JTextField();
        utcname.setFont(new Font("Arial", Font.PLAIN, 15));
        utcname.setSize(190, 20);
        utcname.setLocation(600, 100);
        frame.add(utcname);

		//Label for new Phone Number along with it's size and location
        ucphone = new JLabel("Update Phone Number: ");
        ucphone.setFont(new Font("Arial", Font.PLAIN, 14));
        ucphone.setSize(190, 20);
        ucphone.setLocation(400, 150);
        frame.add(ucphone);

        //TextField for new Phone Number to take input from user
        utcphone = new JTextField();
        utcphone.setFont(new Font("Arial", Font.PLAIN, 15));
        utcphone.setSize(190, 20);
        utcphone.setLocation(600, 150);
        frame.add(utcphone);
              
		//Label for New Email ID along with it's size and location
	    ucemail = new JLabel("Update Email: ");
	    ucemail.setFont(new Font("Arial", Font.PLAIN, 14));
        ucemail.setSize(200, 20);
        ucemail.setLocation(400, 200);
        frame.add(ucemail);

        //TextField for New Email ID to take input from user
        utcemail = new JTextField();
        utcemail.setFont(new Font("Arial", Font.PLAIN, 15));
        utcemail.setSize(190, 20);
        utcemail.setLocation(600, 200);
        frame.add(utcemail);
        

		//Label for New Postal code along with it's size and location
        uccode = new JLabel("Update Postal Code: ");
        uccode.setFont(new Font("Arial", Font.PLAIN, 14));
        uccode.setSize(200, 20);
        uccode.setLocation(400, 250);
        frame.add(uccode);

        //TextField for New Postal Code to take input from user
        utccode = new JTextField();
        utccode.setFont(new Font("Arial", Font.PLAIN, 15));
        utccode.setSize(190, 20);
        utccode.setLocation(600, 250);
        frame.add(utccode);

  
        //Code for submit button along with size and location
        //This submits data into the Data.dat file
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        frame.add(sub);

        //Code for update button along with size and location
        reset = new JButton("Update");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(600, 450);
        reset.addActionListener(this);
        frame.add(reset);

        //Code for display button along with size and location
        //It displays data into TextArea
        display = new JButton("Display");
        display.setFont(new Font("Arial", Font.PLAIN, 15));
        display.setSize(100, 20);
        display.setLocation(300, 450);
        display.addActionListener(this);
        frame.add(display);

        //Code for TextArea
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(450, 550);
        tout.setLocation(800, 50);
        tout.setLineWrap(true);
        tout.setEditable(false);
        frame.add(tout);
        
        sub.addActionListener( new ActionListener()  //Object of submit button used to call addActionListener Function
                {    
                    public void actionPerformed(ActionEvent e)
                    {
                    	try {  //To catch any exception
                    		
                    		EmailValidator emailValidator = new EmailValidator();     //Class to check email validation.
                     	   if(!emailValidator.validate(tcemail.getText().trim())) {   //Compared data from Email Textbox
                     		   JOptionPane.showMessageDialog(null,
                                    	"Invalid Email.");}
                     	   else
                     	   {
                     		   addData();   //This Methods takes data from TextField and transfers it to Data.dat file 
                     		   clearData(); //Method to clear textBox after submission. 
                     		  frame.getContentPane().setBackground( Color.yellow );  //Background color gets changed when submit button is clicked
                     	   }
        				} catch (Exception e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
                    	
                    	
                    }
                });
                
          display.addActionListener( new ActionListener() //This method is called when clicked on display
          {
                    public void actionPerformed(ActionEvent e)
                    {
                    	
                    	try {
                    		
        					displayData();  //Method to display contents of Data.dat file into textArea.
                    		frame.getContentPane().setBackground( Color.white );  //Code to change background color to white 
        				} catch (Exception e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
                    }
           });
          
          reset.addActionListener( new ActionListener() //This method is called when clicked on display
          {
                    public void actionPerformed(ActionEvent e)
                    {
                    	
                    	try {
                    		EmailValidator emailValidator = new EmailValidator();    //Code to check the validation of new Email ID Entered
                      	   if(!emailValidator.validate(utcemail.getText().trim())) {
                      		   JOptionPane.showMessageDialog(null,
                                     	"Invalid Email.");}
                      	   else
                      	   {
                      		   updateData();    //This Methods takes data from TextFields and update contents of the Data.dat file
                      		   clearData();		//Method to clear textBox after submission. 

                      		  frame.getContentPane().setBackground( Color.red ); //To change background color 
                      	   }
        				
        				} catch (Exception e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
                    }
           });
                
              
                
                
        
        frame.setVisible(true);  //Visibility is set to true. So that frame is visible to us.
	}

	//Code to get data from TextBox and insert it to Data.dat file.
	public void addData() throws Exception
	{
		try
		{
			//In and Out Stream Created to set and get data from the file.
			DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("C:\\Users\\kpkar\\eclipse-workspace\\Assignment2\\src/Data.dat", true));
			DataInputStream dataIn = new DataInputStream(new FileInputStream("C:\\Users\\kpkar\\eclipse-workspace\\Assignment2\\src/Data.dat"));
			
			//Data from textBoxs stored into the variable.
			id = Integer.parseInt(tcid.getText()) ;
			name = tcname.getText(); 
			phone = tcphone.getText(); 
			email = tcemail.getText(); 
			code = tccode.getText(); 
			
			int count=0;
			//Validating that id should not be less than or equal to 0
			 if(id<=0)
			 {
				 JOptionPane.showMessageDialog(null,
							"Id should be greater than zero. Enter Data again.");
				 clearData();
			 }
			 else
			 { 
					while(dataIn.available()>0)
					{
						//Get already existing data from the file to variables.
						int Getid = dataIn.readInt();
						String name = dataIn.readUTF();
						String phone = dataIn.readUTF();
						String email = dataIn.readUTF();
						String code = dataIn.readUTF();
						//Compare the two ID, to validate that there cannot be two id with the same number in the file.
						if(Getid==id)
						{
							JOptionPane.showMessageDialog(null,
									"Customer ID already exists.");
							 count=1;
							 //If ID already exists data is not entered.
						}					
					}
					//If ID doesn't exist Data is entered into the file.
					if(count!=1)
					{	 dataOut.writeInt(id);
						 dataOut.writeUTF(name);
						 dataOut.writeUTF(phone);
						 dataOut.writeUTF(email);
						 dataOut.writeUTF(code);   	
		
						 JOptionPane.showMessageDialog(null,
							"Customer Information submitted Successfully. To view information click on Display.");
					}
			 }
		}catch (Exception exc) 
		{
			JOptionPane.showMessageDialog(null, "Error! Please enter correct data.");
			exc.printStackTrace();
		}
}
	
	
	public void displayData() throws Exception
	{
		//InputStream to get data from the file 
		DataInputStream dataIn = new DataInputStream(new FileInputStream("C:\\Users\\kpkar\\eclipse-workspace\\Assignment2\\src/Data.dat"));
		 
		tout.setText(""); //To clear the textArea.
		while(dataIn.available()>0)
		{
			//gets data from the file into the variable
			int id = dataIn.readInt();
			String name = dataIn.readUTF();
			String phone = dataIn.readUTF();
			String email = dataIn.readUTF();
			String code = dataIn.readUTF();
		
		//Displays data into the textArea
		tout.append("\n"+"Customer ID: "+Integer.toString(id));
		tout.append(", Name: "+name);
		tout.append(", Phone: "+phone);
		tout.append(", Email: "+email);
		tout.append(", Postal Code: "+code);
		}
		dataIn.close();
		
	
	}
	
	public void clearData() //Method to clear the textBox
	{

        tcid.setText("");
        tcname.setText("");
        tcphone.setText("");
        tcemail.setText("");
        tccode.setText("");

        utcid.setText("");
        utcname.setText("");
        utcphone.setText("");
        utcemail.setText("");
        utccode.setText("");
	}
	
	public void updateData() throws Exception  //Method to update the existing data
	{
		//Creating stream to read and write data from the files.
		DataInputStream dataIn = new DataInputStream(new FileInputStream("C:\\Users\\kpkar\\eclipse-workspace\\Assignment2\\src/Data.dat"));

		DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("C:\\Users\\kpkar\\eclipse-workspace\\Assignment2\\src/Copy.dat"));
	     
		//gets data from the textBox into the variable
		uid = Integer.parseInt(utcid.getText()) ;
		uname = utcname.getText(); 
		uphone = utcphone.getText(); 
		uemail = utcemail.getText(); 
		ucode = utccode.getText(); 
		
			if(uid<=0)
			 {
				 JOptionPane.showMessageDialog(null,
							"Id should be greater than zero. Enter Data again.");
				 clearData();
			 }
			else
			{
			
				while(dataIn.available()>0)
				{
					//gets data from the file into variable
					int id = dataIn.readInt();
					String name = dataIn.readUTF();
					String phone = dataIn.readUTF();
					String email = dataIn.readUTF();
					String code = dataIn.readUTF();
					
					
					if(id == uid)
					{
						//If id is same it writes data from textBox into our temp file  
						dataOut.writeInt(uid);
					      dataOut.writeUTF(uname);
					      dataOut.writeUTF(uphone);
					      dataOut.writeUTF(uemail);
					      dataOut.writeUTF(ucode);
					    
					}
					else {
						//if id is different data from original file is transfered to temp file.
						dataOut.writeInt(id);
					      dataOut.writeUTF(name);
					      dataOut.writeUTF(phone);
					      dataOut.writeUTF(email);
					      dataOut.writeUTF(code);
					}
		
				
				}
				JOptionPane.showMessageDialog(null,
						"Customer Information updated Successfully. To view information click on Display.");
			}
		
		
		//Reading data from temp file into main file.

		DataInputStream dataInC = new DataInputStream(new FileInputStream("C:\\Users\\kpkar\\eclipse-workspace\\Assignment2\\src/Copy.dat"));
		DataOutputStream dataOutC = new DataOutputStream(new FileOutputStream("C:\\Users\\kpkar\\eclipse-workspace\\Assignment2\\src/Data.dat"));


		while(dataInC.available()>0)
		{
			int id = dataInC.readInt();
			String name = dataInC.readUTF();
			String phone = dataInC.readUTF();
			String email = dataInC.readUTF();
			String code = dataInC.readUTF();
			
			
			

				dataOutC.writeInt(id);
			      dataOutC.writeUTF(name);
			      dataOutC.writeUTF(phone);
			      dataOutC.writeUTF(email);
			      dataOutC.writeUTF(code);
			    

		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		
	}


	
	

}
