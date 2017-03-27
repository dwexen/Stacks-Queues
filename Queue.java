/*
*Queue.java
*
*"I pledge my honor that I have abided by the Stevens Honor System."
*
*Matthew Colozzo (c) 2014
*
*/
package week7;
/**
*Implents a Queue using arrays
*
*@author	Matthew Colozzo
*@version	1.0
*@since		20141016
*/
public class Queue
{
	private int[] myArr;
	private int cap;
	private int front = -1, back = 0;
	/*
	*Shifts all values in the queue up one index and then adds the newest number to the 0 index.
	*and increments front
	*
	*@param  newInt  The number that is to be added to the back of the queue
	*/
	public void enqueue(int newInt)
	{
		if(isFull())
		{
			System.out.println("Queue is full");
			return;
		}
		front++;
		for(int i = front; i > 0; i--)
		{
			myArr[i] = myArr[i - 1];
		}
		myArr[back] = newInt;
		
	}
	/*
	*Removes the number of the highest index from the queue since it is 
	*the oldest value in the queue
	*
	*return  	The number at the front of the queue
	*/
	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Empty");
			return -1;
		}
		return myArr[front--];
	}
	public boolean isEmpty()
	{
		if(front < 0)
		{	
			return true; 
		}
		return false;
			
	}
	public boolean isFull()
	{
		if(front + 1 == cap)
		{
			return true;
		}
		return false;
	}
	/*
	*Checks to ensure that their is a number to be found at the front the queue
	*
	*return 	The number at the front of the queue. -1 if no value exists
	*/
	public int peek()
	{
		if(front >= 0)
		{	
			return myArr[front];
		}
		return -1;
		
	}
	/*
	*@return	The size of the queue
	*/
	public int size()
	{
		return front + 1;
	}
	/*
	*Prints the queue
	*/
	public void printQueue()
	{
		for(int i = 0; i <= front; i++)
		{
			System.out.print(myArr[i]);
		}
	}
	/*
	*Constructor that creates a queue of the size given by the user
	*
	*@param   size 	The size of the queue
	*/
	public Queue(int size)
	{
		cap = size;
		int[] arr = new int[size];
		myArr = arr;
	}
	/*
	*Default constructor
	*/
	public Queue()
	{
		Queue q = new Queue(10);
	}
	/*
	*Main method used for testing
	*/
	public static void main(String[] args)
	{
		Queue q = new Queue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.dequeue();
		q.printQueue();
	}
}