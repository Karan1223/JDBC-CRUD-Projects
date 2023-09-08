
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Question4 
{

	//Creating a HashSet named set which is Synchronized
	public static Set<Integer> set = Collections.synchronizedSet(new HashSet<Integer>());

	//Main method
	public static void main(String[] args) 
	{
		new Thread1();
		new Thread2();
	}

	//class Thread1 which implements Runnable
	static class Thread1 implements Runnable 
	{
		//Thread Constructor 
		public Thread1() 
		{
			//Creating a Thread initializing it as this class using this
			Thread thread = new Thread(this);
			
			//Starting the thread
			thread.start();
		}

		@Override
		public void run() 
		{
			for (int i = 0; i < 100000; i++) 
			{
				set.add(i);
			}
		}
	}
 /*
  * creating the thread here
  * it will add the number to the hashSet
  * */
static class Thread2 implements Runnable 
{

	//this constructor create the thread start it
	public Thread2() 
	{
		Thread thread = new Thread(this);
		thread.start();
	}

	
	//overriding the interface method here
	@Override
	public void run() 
	{
		try 
		{
			while (true) 
			{
				//here we are using the synchronized keyword it will iterate through the set 
				//in synchronization
				synchronized (set) 
				{
					//creating the iterator here
					for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) 
					{
						System.out.println(iterator.next());      
					}      
				}
				//thread will sleep for 1 second, and read will be stop for 1 second
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