package stack;

import java.util.EmptyStackException;

public class Stack_Implementation {

	public static void main(String[] args) {
		
		MyStack<String> s = new MyStack<>();
		String data = "Item1";
		s.push(data);
		s.push("Item2");
		while (!s.isEmpty())
		{
			System.out.println(s.pop());
		}
	}
}

class MyStack<T>{
	
	StackNode<T> top;
	
	private class StackNode<T>{
		T data;
		StackNode<T> next = null;
		public StackNode(T data)
		{
			this.data = data;
		}
	}
	
	public MyStack()
	{
		top = null;
	}	
	public void push(T data)
	{
		StackNode<T> node = new StackNode<T>(data);
		if(top == null)
		{
			top = node;
		}
		else
		{
			node.next = top;
			top = node;
		}
	}
	public boolean isEmpty()
	{
		return top == null;		
	}
	public T peek()
	{
		if(top == null)
			throw new EmptyStackException();
		else
			return top.data;
	}
	public T pop()
	{
		if(top == null)
			throw new EmptyStackException();
		else
		{
			T data = top.data;
			top = top.next;
			return data;
		}
	}
}

