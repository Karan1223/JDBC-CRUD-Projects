//Program Without Synchronized
import java.util.concurrent.*;

public class Question2 
{
	//Creating variable s of Integer  
	private Integer s = new Integer(0);
	
	//Main method
	public static void main(String[] args)
	{
		//Creating object of main class to call constructor
		Question2 a = new Question2();
		
	}
	
	//Constructor
	Question2()
	{
		//Creating a fixedThreadPool of 1000
		int pool = 1000;
		ExecutorService e = Executors.newFixedThreadPool(pool);
		
		//Executing loop till size of pool
		for(int i = 0;i<pool;i++) 
		{
			//executing threads
			e.execute(new Sum());
			//System.out.println("At thread "+ i +" , Sum " + s );
		}
		//shutdown the thread
		e.shutdown();

		//Printing the final sum
		System.out.println("Total Sum " + s);
		
	}

	//Sum class which implements Runnable
	class Sum implements Runnable
	{
		//Run method which increments value
		public void run()
		{
			int value = s.intValue() + 1;
			s = new Integer(value);
		}
	}
}