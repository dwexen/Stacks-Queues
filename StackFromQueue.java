/*
*StackFromQueue.java
*
*"I pledge my honor that I have abided by the Stevens Honor System."
*
*Matthew Colozzo (c) 2014
*
*/
package week7;
/**
*Implents a Stack using two Queues
*
*@author	Matthew Colozzo
*@version	1.0
*@since		20141016
*/
public class StackFromQueue
{
	private Queue q;
	private Queue f;
	/*
	*Emulates the push method used in a Stack by simplying using enqueue if the "stack" is empty
	*or it first stores the values into the second queue, adds the new number, and then
	*re-adds the old numbers into the first queue so that the pop method can easily mimic the stack
	*pop function by only calling dequeue and remove the most recently added value.
	*
	*@param   newInt	The number to be added to the "stack"
	*/
	public void push(int newInt)
	{
		if(q.isEmpty())
		{	
			q.enqueue(newInt);
		}
		else 
		{
			for(int i = q.size(); i > 0; i--)
			{
				f.enqueue(q.dequeue());
			}
			q.enqueue(newInt);
			for(int j = f.size(); j > 0; j--)
			{
				q.enqueue(f.dequeue());
			}
		}
	}
	/*
	*Emulates the pop method of a stack by simply calling dequeue for the first queue
	*since the swapping of storage was handled in the push method
	*
	*@return	The most recently pushed value
	*/
	public int pop()
	{
		if(q.isEmpty())
		{
			System.out.println("Empty");
			return -1;
		}
		else	
			return q.dequeue();
	}
	/*
	*Prints the stack
	*/
	public void printStack()
	{
		q.printQueue();
	}
	/*
	*Constructor that sets both queues equal to the given size
	*
	*@param   size   The size of the stack
	*/
	public StackFromQueue(int size)
	{
		q = new Queue(size);
		f = new Queue(size);
	}
	/*
	*Default constructor 
	*/
	public StackFromQueue()
	{ 
		q = new Queue(5);
		f = new Queue(5);
	}
	/*
	*Main method used for testing
	*/
	public static void main(String[] args)
	{
		StackFromQueue sq = new StackFromQueue(5);
		sq.push(1);
		sq.push(2);
		sq.push(3);
		sq.push(4);
		sq.push(5);
		sq.pop();
		sq.printStack();
	}
}