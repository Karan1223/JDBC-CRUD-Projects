import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Product extends JFrame implements ActionListener
{

	//Variable Created
	private int id;                         //Product ID variable to take input from user
	private String name;					//Product Name variable to take input from user
	private Double price;					//Product price variable to take input from user
	
	int records = 0;
	
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
		try {
			updateRecords();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
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
        clear = new JButton("Delete");
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
        
        display.addActionListener( new ActionListener()  //Object of submit button used to call addActionListener Function
                {    
                    public void actionPerformed(ActionEvent e)
                    {
                    	try {
        					displayData();   //This Methods takes data from TextField and transfers it to Data.txt file 
        				} catch (Exception e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
                    	
                    	clearData();  //function to clear the textField
                    	
                    }
                });
                
        reset.addActionListener( new ActionListener()  //Object of submit button used to call addActionListener Function
                {    
                    public void actionPerformed(ActionEvent e)
                    {
                    	try {
        					updateData();   //This Methods takes data from TextField and transfers it to Data.txt file 
        					clearData();
                    	} catch (Exception e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
                    	
                    	clearData();  //function to clear the textField
                    	
                    }
                });
        
        clear.addActionListener( new ActionListener()  //Object of submit button used to call addActionListener Function
                {    
                    public void actionPerformed(ActionEvent e)
                    {
                    	try {
        					deleteData();   //This Methods takes data from TextField and transfers it to Data.txt file 
        					clearData();
                    	} catch (Exception e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
                    	
                    	clearData();  //function to clear the textField
                    	
                    }
                });
                
        
        frame.setVisible(true);
        


	}
	public void inputData() throws Exception
	{
	
		id = Integer.parseInt(tid.getText());
		name = tname.getText();
		price = Double.parseDouble(tprice.getText());
		
		RandomAccessFile raf = new RandomAccessFile("src/File.dat", "rw");
		RandomAccessFile num = new RandomAccessFile("src/Num.dat", "rw");
		
		 if(id<=0)
		 {
			 JOptionPane.showMessageDialog(null,
						"Id should be greater than zero. Enter Data again.");
			 clearData();
		 }
		 else
		 {
		raf.seek(raf.length());
		raf.writeInt(id);
		raf.writeUTF(name);
		raf.writeDouble(price);
		
		records++;
		
		num.seek(0);
		num.writeInt(records);
		
		 }
	
	}
	public void clearData()
	{
        tid.setText("");
        tname.setText("");
        tprice.setText("");
        utid.setText("");
        utname.setText("");
        utprice.setText("");
	}
	
	public void displayData() throws Exception 
	{
		
		String product="";
		try
		{
		RandomAccessFile raFile = new RandomAccessFile("src/File.dat", "rw");
		
		raFile.seek(0);
		for(int i = 0; i<records; i++) 
		{
		product += "ID: " + raFile.readInt() + ", Name: " + raFile.readUTF() + ", Price: " + raFile.readDouble() + "\n";
		}
		
		tout.setText(product);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void updateRecords() throws IOException 
	{
		File file = new File("src/Num.dat");
		RandomAccessFile numberFile = new RandomAccessFile(file, "rw");
		if(numberFile.read()==-1) 
		{
			records = 0;
		}else 
		{
			numberFile.seek(0);
		    records = numberFile.readInt();
		    //System.out.println(numberOfRecords);
		}
	}
	
	public void updateData() throws Exception
	{
		File file = new File("src/File.dat");
		File file2 = new File("src/copy.dat");
		try {
			RandomAccessFile raFile = new RandomAccessFile(file, "rw");
			RandomAccessFile copyFile = new RandomAccessFile(file2, "rw");
			
			int flag = 0;
			int size=0;
			uid = Integer.parseInt(utid.getText()); 
			uname = utname.getText();
			uprice = Double.parseDouble(utprice.getText());
			
			for(int i = 0; i<records; i++) {
				
				int id = raFile.readInt();
				String name  = raFile.readUTF();
				double price = raFile.readDouble();
				
				if(uid == id) {
					copyFile.seek(size);
					copyFile.writeInt(id);
					copyFile.writeUTF(uname);
					copyFile.writeDouble(uprice);
					size += 14 + uname.length();
					flag = 1;
				}else {
					copyFile.seek(size);
					copyFile.writeInt(id);
					copyFile.writeUTF(name);
					copyFile.writeDouble(price);
					size += 14 + name.length();
				}
			}
			
			if(flag == 1) {
				JOptionPane.showMessageDialog(null, "Product updated successfully.");
			}else {
				JOptionPane.showMessageDialog(null, "Error! Couldn't find Product with the provided ID.");
			}
			
			int size2 = 0;
			for(int i = 0; i<records; i++) {
				raFile.seek(size2);
				copyFile.seek(size2);
				
				int id = copyFile.readInt();
				String name  = copyFile.readUTF();
				double price = copyFile.readDouble();
				raFile.writeInt(id);
				raFile.writeUTF(name);
				raFile.writeDouble(price);
				size2 += 14 + name.length();
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void deleteData() throws Exception
	{
		File file = new File("src/File.dat");
		File file2 = new File("src/copy.dat");
		File file3 = new File("src/Num.dat");
		
		try {
			RandomAccessFile raFile = new RandomAccessFile(file, "rw");
			RandomAccessFile copyFile = new RandomAccessFile(file2, "rw");
			
			int flag = 0;
			int psize = 0;
			int csize = 0;
            int targetId = Integer.parseInt(JOptionPane.showInputDialog("Enter the product id: "));
			
			for(int i = 0; i<records; i++) {
				
				int id = raFile.readInt();
				String name  = raFile.readUTF();
				double price = raFile.readDouble();
				
				if(targetId == id) {
					psize += 14 + name.length();
					raFile.seek(psize);
					flag = 1;
				}else {
					copyFile.seek(csize);
					copyFile.writeInt(id);
					copyFile.writeUTF(name);
					copyFile.writeDouble(price);
					csize += 14 + name.length();
					psize += 14 + name.length();
				}
			}
			
			if(flag == 1) {
				records--;
				int psize2 = 0;

				copyFile.seek(0);
				raFile.setLength(0);
				RandomAccessFile numberFile = new RandomAccessFile(file3, "rw");
				
				for(int i = 0; i<records; i++) {
					int id = copyFile.readInt();
					String name  = copyFile.readUTF();
					double price = copyFile.readDouble();
					raFile.seek(psize2);
					raFile.writeInt(id);
					raFile.writeUTF(name);
					raFile.writeDouble(price);
					psize2 += 14 + name.length();
				}
				
				JOptionPane.showMessageDialog(null, "Product deleted successfully.");
				
				numberFile.seek(0);
				numberFile.writeInt(records);
			}else {
				JOptionPane.showMessageDialog(null, "Error! Couldn't find Product with the provided ID.");
			}
			} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}