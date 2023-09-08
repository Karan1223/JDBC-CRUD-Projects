//Program With Synchronized
import java.util.concurrent.*;

public class WithSync  
{
	//Creating variable s of Integer  
	int sum = new Integer(0);

	//Main method
	public static void main(String[] args) 
	{
		//Creating object of main class to call constructor
		WithSync  sync = new WithSync ();
		
	}

	//Constructor
	public WithSync () 
	{
		//Creating a fixedThreadPool of 1000
		int pool = 1000;
		ExecutorService executor = Executors.newFixedThreadPool(pool);

		//Executing loop till size of pool
		for (int i = 0; i <pool; i++) 
		{
			//executing threads
			executor.execute(new SumTask());
		}

		
		//Thread Shutdown
		executor.shutdown();

		while(!executor.isTerminated()) 
		{
		}

		//Printing the final sum
		System.out.println("Final sum: " + sum);
  }

	//SumTask class which implements Runnable
  class SumTask implements Runnable 
  {

		//Run method which increments value
	  public void run() 
	  {
		  //increment sum variable
		  incremetNum();
	  }
	  
	  public synchronized void incremetNum() {
		  sum++;
	  }
	  
  }
}