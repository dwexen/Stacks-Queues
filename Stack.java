/*
*Stack.java
*
*"I pledge my honor that I have abided by the Stevens Honor System."
*
*Matthew Colozzo (c) 2014
*
*/
package week7;
/**
*Implents a Stack using arrays
*
*@author	Matthew Colozzo
*@version	1.0
*@since		20141016
*/
public class Stack
{
	private int[] myArr;
	private int cap;
	private int top = -1;
	
	/*
	*Adds to the Stack by incrementing the top variable and then
	*placing the input into the array at that index.
	*
	*@param	newInt	The integer that will be pushed into the stack
	*/
	public void push(int newInt)
	{
		if(top + 1 >= cap)
		{ 
			System.out.println("Error"); 
			return;
		}
		myArr[++top] = newInt;
	}
	/*
	*Shortens the Stack by returning the most recently added value and then 
	*decrementing the top variable. The latest value still exists in the array
	*but not the "stack"
	*
	*@return 	The most recently added integer
	*/
	public int pop()
	{
		if(top < 0)
		{
			System.out.println("It's empty, can't pop");
			return -1;
		}
		return myArr[top--];
	}
	
	/*
	*Prints all the numbers in the stack.
	*/
	public void printStack()
	{
		for(int i = 0; i <= top; i++)
		{
			System.out.print(myArr[i]);
		}
	}
	/*
	*Returns the size of the stack in the array
	*
	*@return 	The size of the stack
	*/
	public int size()
	{
		return top + 1;
	}
	/*
	*Constructor that reads in an integer from the user and 
	*creates a stack of that size.
	*
	*@param	  size	  The size of the stack
	*/
	public Stack(int size)
	{
		if(size < 0)
		{
			System.out.println("Number too small");
			return;
		}
		cap = size;
		int[] arr = new int[size];
		myArr = arr;
	}
	/*
	*Default constructor
	*/
	public Stack()
	{
		Stack s = new Stack(50);
	}
	/*
	*main method used for testing
	*/
	public static void main(String[] args)
	{
		Stack s = new Stack(5);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.pop();
		s.printStack();
	}
}