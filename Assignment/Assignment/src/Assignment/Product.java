package Assignment;
import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Product extends JFrame implements ActionListener
{
	//Variable Created
	private int id;                         //Product ID variable to take input from user
	private String name;					//Product Name variable to take input from user
	private Double price;					//Product price variable to take input from user
	
	private int uid;						//Updated Product Id variable to take input from user
	private String uname;					//Updated Product Name variable to take input from user
	private double uprice;					//Updated Product price variable to take input from user
	
	
	
	JFrame frame; 							//Object to create main frame
	
	//Creating objects of all the required labels
	JLabel pid;	
	JLabel pname; 
	JLabel pprice;
	JLabel upid; 
	JLabel upname;
	JLabel upprice;
	
	//Creating objects of all the required buttons
	JButton sub; 
	JButton reset; 
	JButton display;
	JButton clear;
	
	//Creating TextArea object to display contents of the file
	JTextArea  tout;
	
	//Creating object of TextField to take input from user and store in the file 
	JTextField tid; 
	JTextField tname;
	JTextField tprice;
	JTextField utid; 
	JTextField utname; 
	JTextField utprice; 
	
	public Product()		//Constructor which gets called automatically when object is created
	{
		frame = new JFrame("Products");							//Frame created
		frame.setSize(500,500);									//Frame Size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close Operation
		frame.getContentPane();
		frame.setLayout(null);									//Not using any specific layout
	    
		//Label for ID along with it's size and location
	    pid = new JLabel("Product Id: ");
	    pid.setFont(new Font("Arial", Font.PLAIN, 14));
        pid.setSize(190, 20);
        pid.setLocation(100, 100);
        frame.add(pid);
 
        //TextField for ID to take input from user
        tid = new JTextField();
        tid.setFont(new Font("Arial", Font.PLAIN, 15));
        tid.setSize(190, 20);
        tid.setLocation(300, 100);
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
 
		//Label for Name along with it's size and location
        pname = new JLabel("Product Name: ");
        pname.setFont(new Font("Arial", Font.PLAIN, 14));
        pname.setSize(210, 20);
        pname.setLocation(100, 150);
        frame.add(pname);

        //TextField for Name to take input from user
        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(300, 150);
        frame.add(tname);

		//Label for Price along with it's size and location
        pprice = new JLabel("Product Price: ");
        pprice.setFont(new Font("Arial", Font.PLAIN, 14));
        pprice.setSize(190, 20);
        pprice.setLocation(100, 200);
        frame.add(pprice);

        //TextField for Price to take input from user
        tprice = new JTextField();
        tprice.setFont(new Font("Arial", Font.PLAIN, 15));
        tprice.setSize(190, 20);
        tprice.setLocation(300, 200);
        frame.add(tprice);
        

        //Dosen't let user enter characters for Price
        tprice.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                    JOptionPane.showMessageDialog(null,
                	"Can't enter string. Enter Number.");
                }
             }
        });
      
		//Label for New ID along with it's size and location
	    upid = new JLabel("Update Product Id: ");
	    upid.setFont(new Font("Arial", Font.PLAIN, 14));
        upid.setSize(200, 20);
        upid.setLocation(100, 250);
        frame.add(upid);

        //TextField for New ID to take input from user
        utid = new JTextField();
        utid.setFont(new Font("Arial", Font.PLAIN, 15));
        utid.setSize(190, 20);
        utid.setLocation(300, 250);
        frame.add(utid);
        

        //Dosen't let user enter characters for New ID
        utid.addKeyListener(new KeyAdapter() {
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
        upname = new JLabel("Update Product Name: ");
        upname.setFont(new Font("Arial", Font.PLAIN, 14));
        upname.setSize(200, 20);
        upname.setLocation(100, 300);
        frame.add(upname);

        //TextField for New Name to take input from user
        utname = new JTextField();
        utname.setFont(new Font("Arial", Font.PLAIN, 15));
        utname.setSize(190, 20);
        utname.setLocation(300, 300);
        frame.add(utname);

		//Label for New Price along with it's size and location
        upprice = new JLabel("Update Product Price: ");
        upprice.setFont(new Font("Arial", Font.PLAIN, 14));
        upprice.setSize(200, 20);
        upprice.setLocation(100, 350);
        frame.add(upprice);

        //TextField for New Price to take input from user
        utprice = new JTextField();
        utprice.setFont(new Font("Arial", Font.PLAIN, 15));
        utprice.setSize(190, 20);
        utprice.setLocation(300, 350);
        frame.add(utprice);
        

        //Dosen't let user enter characters for New Price
        utprice.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                    JOptionPane.showMessageDialog(null,
                	"Can't enter string. Enter Number.");
                }
             }
        });
        
        //Code for submit button along with size and location
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(100, 450);
        sub.addActionListener(this);
        frame.add(sub);

        //Code for update button along with size and location
        reset = new JButton("Update");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(220, 450);
        reset.addActionListener(this);
        frame.add(reset);

        //Code for display button along with size and location
        //It displays data into TextArea
        display = new JButton("Display");
        display.setFont(new Font("Arial", Font.PLAIN, 15));
        display.setSize(100, 20);
        display.setLocation(340, 450);
        display.addActionListener(this);
        frame.add(display);

        //Code for clear button along with size and location
        //This button is used to clear data in TextField Manually
        clear = new JButton("Clear");
        clear.setFont(new Font("Arial", Font.PLAIN, 15));
        clear.setSize(100, 20);
        clear.setLocation(460, 450);
        clear.addActionListener(this);
        frame.add(clear);
        
        //Code for TextArea
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(600, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        frame.add(tout);
        
        //Main code for submit button
        sub.addActionListener( new ActionListener()  //Object of submit button used to call addActionListener Function
        {    
            public void actionPerformed(ActionEvent e)
            {
            	try {
					inputData();   //This Methods takes data from TextField and transfers it to Data.txt file 
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	clearData();  //function to clear the textField
            	
            }
        });
        
        display.addActionListener( new ActionListener() //This method is called when clicked on display
        {
            public void actionPerformed(ActionEvent e)
            {
            	
            	try {
					displayData();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        clear.addActionListener(new ActionListener() //This method is called when clicked on clear button
        {
            public void actionPerformed(ActionEvent e)
            {
                
                clearData(); //Method to clear TextField
            }
        });
             
        
        reset.addActionListener(new ActionListener() //This method is called when clicked on update button
                {
                    public void actionPerformed(ActionEvent a)
                    { 
                    	String FilePath = "src/Data.txt";
        				String FileContent = "";
        				String modifiedFileContentName = "";
        				String modifiedFileContent = "";
        				File productfile = new File(FilePath); //object creation for file 
        				

        				//Here, we'll make the buffer reader and writer null.
        				BufferedReader reader = null;
        				PrintStream writer = null;
        				
        				//Data from TextFeilds
        				int findid = Integer.parseInt(utid.getText());
        				String name1 = utname.getText();
        				double price1 = Double.parseDouble(utprice.getText());

        				//exception handling
        				try {

        					
        					reader = new BufferedReader(new FileReader(FilePath)); 
        					// object creation for buffer reader.

        	
        					String currentReadingLine = reader.readLine();

        					
        					while (currentReadingLine != null) {
        						FileContent += currentReadingLine + System.lineSeparator();
        						currentReadingLine = reader.readLine();
        					}

        					
        					 //This code will update the price of the product for a specific product Id.
        					 
        					try (Scanner getResult = new Scanner(productfile);) {
        						while (getResult.hasNextLine()) {
        							int id = getResult.nextInt();
        							String name = getResult.next();
        							Double price = getResult.nextDouble();
        							

        						
        							if (id == findid) {
        								modifiedFileContentName = FileContent.replaceAll(name, name1);
        								modifiedFileContent = modifiedFileContentName.replaceAll(Double.toString(price),
        										Double.toString(price1));
        							}
        						}
        					} catch (Exception exc) {
        						JOptionPane.showMessageDialog(null, "Error!!, Opening file to write data.");
        						exc.printStackTrace();
        					}
        					
        					writer = new PrintStream(new FileOutputStream(FilePath)); 
        					//object for buffer writer
        					System.setOut(writer);
        					writer.append("\n"+"ID: "+findid+", Product: "+modifiedFileContentName+", Price: $"+modifiedFileContent);

                            //updating product message box.
        					JOptionPane.showMessageDialog(null,
        					"Product updated Successfully. To view updated prodcut list click on Display.");

        				} catch (IOException e1) {
        					//exception handling
        					JOptionPane.showMessageDialog(null, "Error!!, Opening file to write data.");
        				} finally {
        					
        					try {
        						if (reader != null) {
        							reader.close();
        						}

        						if (writer != null) {
        							writer.close();
        						}

        					} catch (IOException e2) {
        						
        					}
        				}

        			}
        		});
        frame.setVisible(true);
        
        
	}	
	
	//Method to take data from textField and store it in the file.
	public void inputData() throws Exception
	{
		 //Data from textField stored into variables
		 id = Integer.parseInt(tid.getText()) ;
		 name = tname.getText(); 
		 price = Double.parseDouble(tprice.getText());
		 
		 if(id<=0 || price<=0)
		 {
			 JOptionPane.showMessageDialog(null,
						"Price and Id should be greater than zero. Enter Data again.");
			 clearData();
		 }
		 else
		 {
		 
		 //outFile is object of FileOutputStream when has path of the file in which data needs to be stored
		 //true represents that it can append
		 FileOutputStream outFile = new FileOutputStream("src/Data.txt", true);
		    
		 //creating outStream objects 
		 PrintStream outStream = new PrintStream(outFile);
		 
		 //Converting id and price to String from integer and double, respectively.
		 String sid = Integer.toString(id);
		 String sprice = Double.toString(price);
		   
		 //Transferring Data to Data.txt file using outStream 
		 System.setOut(outStream);
		 outStream.append("\n"+"ID: "+sid+", Product: "+name+", Price: $"+sprice);
		 
		 outStream.close();
		 //To display a DialogBox to user which says data was added successfully 
     	
     	JOptionPane.showMessageDialog(null,
			"Product submitted Successfully. To view submitted product list click on Display.");
     	
		 }

	}
	
	//Method to display data from file to user using TextArea
	public void displayData() throws Exception
	{
		//Object of FileReader class has location of file
		FileReader reader = new FileReader( "src/Data.txt" );
		
		//BufferedReader object is used to read contents of the file.
        BufferedReader br = new BufferedReader(reader);
        tout.read( br, null );
        br.close();
        tout.requestFocus();
	}
	
	//Method to clear data from TextArea
	public void clearData()
	{
        tid.setText("");
        tname.setText("");
        tprice.setText("");
        utid.setText("");
        utname.setText("");
        utprice.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
