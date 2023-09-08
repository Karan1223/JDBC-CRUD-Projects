import java.sql.*;
public class Database  //Connection class
{
	
	public Connection db_connection() throws ClassNotFoundException, SQLException 
	{
		//Code to connect to database
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
			
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","N01514624","oracle");
		
		//returning connection object
		return conn;
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
