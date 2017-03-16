package Linked_List;

public class Linked_list_intersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Linked_List2 headA = create_linked_list1();		
		Linked_List2 headB = create_linked_list2();
		
		System.out.println("Before intersection : ");
		headA.display_linked_list();
		headB.display_linked_list();
		
		int position1 = 0;
		int position2 = 0;
		// create intersection of 2 lists such that linkedList2 node number "position2" is connected 
		// after "position1" in linkedList1 
		// i.e. position1.next = position2 
		create_intersection(headA, headB, position1, position2);		
		System.out.println("After intersection : ");
		headA.display_linked_list();
		headB.display_linked_list();

		// find intersection of 2 lists
		Linked_List_Node2 intersection = find_intersection_node(headA, headB);
		System.out.println("Length of A : " + headA.get_length());
		System.out.println("Length of B : " + headB.get_length());
		System.out.print("The intersection node is : ");
		intersection.display_node();
	}
	
	public static Linked_List2 create_linked_list1()
	{
		Linked_List2 head = new Linked_List2();
		
		head.append_node(11);
		/*head.append_node(5);
		head.append_node(6);
		head.append_node(7);*/
		return head;
	}
	
	public static Linked_List2 create_linked_list2()
	{
		Linked_List2 head = new Linked_List2();
		head.append_node(11);
		/*head.append_node(7);
		head.append_node(8);
		head.append_node(9);
		head.append_node(10);
		head.append_node(11);*/
		
		return head;
	}

	public static Linked_List_Node2 find_intersection_node(Linked_List2 a, Linked_List2 b)
	{
		int length_difference = a.get_length() - b.get_length();
		Linked_List_Node2 longer_list_node;
		Linked_List_Node2 shorter_list_node;
		if (length_difference <= 0)
		{
			length_difference = length_difference * -1;
			longer_list_node = b.get_head();
			shorter_list_node = a.get_head();
		}
		else
		{
			longer_list_node = a.get_head();
			shorter_list_node = b.get_head();
		}
		int i=0;
		while(i < length_difference)
		{
			longer_list_node = longer_list_node.next_node;
			i++;
		}
		while(longer_list_node != shorter_list_node)
		{
			longer_list_node = longer_list_node.next_node;
			shorter_list_node = shorter_list_node.next_node;
		}
		return longer_list_node;
	}
	
	public static void create_intersection(Linked_List2 headA, Linked_List2 headB, 
			int positionA, int positionB)
	{
		Linked_List_Node2 currentA = headA.get_head();
		Linked_List_Node2 currentB = headB.get_head();
		
		int i = 1;
		while(i < positionA)
		{
			currentA = currentA.next_node;
			i++;
		}
		i = 1;
		while(i < positionB)
		{
			currentB = currentB.next_node;
			i++;
		}
		currentA.next_node = currentB;
	}
}

class Linked_List2{
	private Linked_List_Node2 head;
	int length = 0;
	
	public Linked_List_Node2 get_head()
	{
		return this.head;
	}
	public Linked_List2() {
		this.head = null;	
	}
	
	public Linked_List_Node2 append_node(int data)
	{
		Linked_List_Node2 node = new Linked_List_Node2(data);
		if(length == 0)
		{
			head = node;
		}
		else
		{
			Linked_List_Node2 current = head;
			while(current.next_node != null)
			{
				current = current.next_node;
			}
			current.next_node = node;
			
		}				
		length ++;
		return node;
	}
	public void display_linked_list()
	{
		System.out.println("Linked List : ");
		Linked_List_Node2 current = head;
		while(current != null)
		{
			current.display_node();
			if(current.next_node != null)
				System.out.print(" -> ");
			current = current.next_node;
		}
		System.out.println("");
	}
	
	public int get_length()
	{
		int length =0;
		Linked_List_Node2 node = this.get_head();
		while(node != null)
		{
			node = node.next_node;
			length ++;
		}	
		return length;
	}
}

class Linked_List_Node2{
	private int data;
	public Linked_List_Node2 next_node;
	
	public Linked_List_Node2(int data) {
		this.data = data;
		this.next_node = null;
	}
	public void display_node()
	{
		System.out.print(this.data);
	}
}