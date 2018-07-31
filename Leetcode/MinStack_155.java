package leetcode;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class MinStack_155 {
	private static int minElement;
	private int[] stack;
	private int top=-1;
    /** initialize your data structure here. */
    public MinStack_155() {
    	this.stack = new int[100];
        this.top = 0;
    }
    
    public void push(int x) {
    	minElement = (x < minElement) ? x : minElement; 
        this.stack[this.top++] = x;
    }
    
    public void pop() {
        if (top < 0)
        	throw new EmptyStackException();
        else 
        	this.top--;
    }
    
    public int top() {
        return this.stack[top];
    }
    
    public int getMin() {
        return minElement;
    }
}

