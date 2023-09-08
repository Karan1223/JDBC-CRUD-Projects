
import java.util.HashSet;
import java.util.Iterator;

public class Question3 
{

	//Creating a HashSet named set which is not Synchronized
	public static HashSet<Integer> set = new HashSet<>();

	//Main method
	public static void main(String[] args) 
	{
		//two threads
		new Thread1();
		new Thread2();
	}

	//Code for class Thread1 which implements Runnable
	static class Thread1 implements Runnable 
	{
		//Constructor
		public Thread1() 
		{
			//Creating a Thread and setting it as this Thread
			Thread thread = new Thread(this);
			
			//Start the thread
			thread.start();
		}

		@Override
		//Run menthod
		public void run() 
		{
			//setting the loop to 100000
			for (int i = 0; i < 100000; i++) 
			{
				//Adding value to HashSet
				set.add(i);
			}
		}
	}
 
	//Code for class Thread2 which implements Runnable
	static class Thread2 implements Runnable 
	{
		//Constructor
		public Thread2() 
		{
			//Creating a Thread and setting it as this Thread
			Thread thread = new Thread(this);
			thread.start();
		}

		//Run method
		@Override
		public void run() 
		{
			//Try Catch block
			try 
			{
				//While loop 
				while (true) 
				{
					//Using for loop to set iterator of HashSet to next
					for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) 
					{
						iterator.next();      
					}   
					//Thread sleep time set to 1 seconds
					Thread.sleep(1000);
				}
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}