package heaps;

public class Binomial_Heap<T> {
	private BH_Node<T> head;

	public Binomial_Heap() {
		this.head = null;
	}
	
	public BH_Node<T> merge(Binomial_Heap<T> H1, Binomial_Heap<T> H2) {
		Binomial_Heap<T> H = new Binomial_Heap<>();
		
		if (H1.head == null) {
			return H2.head;
		} else if (H2.head == null) {
			return H1.head;
		} else {
			BH_Node<T> a = H1.head;
			BH_Node<T> b = H2.head;
			if (H1.head.degree <= H2.head.degree) {
				H.head = H1.head;
				a = a.sibling;
			} else {
				H.head = H2.head;
				b = b.sibling;
			}
			BH_Node<T> current = H.head;
			while(a != null && b != null) {
				if (a.degree <= b.degree) {
					current.sibling = a;
					a = a.sibling;
				} else {
					current.sibling = b;
					b = b.sibling;
				}
				current = current.sibling;
			}
			
			if (a != null) {
				current.sibling = a;
			} else {
				current.sibling = b;
			}
			return H.head;
		}
	}
	
	public void link(BH_Node<T> y, BH_Node<T> z) {
		y.parent = z;
		y.sibling = z.child;
		z.child = y;
		z.degree += 1;
	}

	public Binomial_Heap<T> union(Binomial_Heap<T> H1, Binomial_Heap<T> H2) {
		Binomial_Heap<T> H = new Binomial_Heap<>();
		H.head = merge(H1, H2);
		if (H.head == null) {
			return H;
		}
		BH_Node<T> prev = null;
		BH_Node<T> x = H.head;
		BH_Node<T> next = x.sibling;
		
		while (next != null) {
			if (x.degree != next.degree || (next.sibling != null && next.sibling.degree == x.degree)) {
				prev = x;
				x = next;
			} else {
				if ((Integer)x.key < (Integer)next.key) {
					x.sibling = next.sibling;
					link(next, x);
			} else {
				if (prev == null) {
					H.head = next;
				} else {
					prev.sibling = next;
				}
				link (x, next);
				x = next;
				}
			}
			next = x.sibling;
		}
		
		return H;
	}
	
	public Binomial_Heap<T> insert(T key) {
		Binomial_Heap<T> H_new = new Binomial_Heap<>();
		BH_Node<T> x = new BH_Node<T>(key);
		H_new.head = x;
		return this.union(this, H_new);
	}
	
	public BH_Node<T> minimum() {
		BH_Node<T> y = null;
		BH_Node<T> x = this.head;
		int minimum = Integer.MAX_VALUE;
		while (x != null) {
			if ((Integer)x.key < minimum) {
				y = x;
				minimum = (Integer)x.key;
			}
			x = x.sibling;
		}
		return y;
	}

	public BH_Node<T> remove_x(BH_Node<T> head, BH_Node<T> x) {
		BH_Node<T> current = head;
		BH_Node<T> prev = null;
		while(current.key != x.key) {
			prev = current;
			current = current.sibling;
		}
		if (prev == null) {
			head = head.sibling;
		} else {
			prev.sibling = current.sibling;
		}
		return head;
	}
	
	public void decreaseKey(BH_Node<T> x, Integer key) {
		if ((Integer)key > (Integer)x.key) {
			System.out.println("Error");
		} else {
			x.key = (T)key;
			BH_Node<T> y = x;
			BH_Node<T> z = y.parent;
			while(z != null && (Integer)y.key < (Integer)z.key) {
				T temp = y.key;
				y.key = z.key;
				z.key = temp;
				y = z;
				z = y.parent;
			}
		}
	}
	
	public BH_Node<T> delete(BH_Node<T> x) {
		this.decreaseKey(x, Integer.MIN_VALUE);
		this.extractMin();
		return this.head;
	}
	
	public BH_Node<T> extractMin() {
		
		BH_Node<T> x = this.minimum();
		
		this.head = remove_x(this.head, x);

		Binomial_Heap<T> H_New = new Binomial_Heap<>();
		
		BH_Node<T> childListHead = x.child;
		if (childListHead != null) {
			BH_Node<T> reversedList = childListHead.reverse();
			H_New.head = reversedList;
			this.head = union(this, H_New).head;
		}
		return x;
	}
	
	public void displayHeap()
    {
        System.out.print("\nHeap : ");
        displayHeap(this.head);
        System.out.println("\n");
    }
	
    private void displayHeap(BH_Node<T> r)
    {
        if (r != null)
        {
            displayHeap(r.child);
            System.out.print(r.key +" ");
            displayHeap(r.sibling);
        }
    }    
	
	static class BH_Node<T> {
		private BH_Node<T> parent;
		private T key;
		private int degree;
		private BH_Node<T> child;
		private BH_Node<T> sibling;
		
		public BH_Node(T key) {
			this.key = key;
			this.parent = null;
			this.child = null;
			this.sibling = null;
			this.degree = 0;
		}
		
		public BH_Node<T> reverse() {			
			BH_Node<T> current = this;
			BH_Node<T> next = null;
			BH_Node<T> prev = null;
			while(current != null) {
				next = current.sibling;
				current.sibling = prev;
				prev = current;
				current = next;
			}
			return prev;
			
//			if (current.sibling == null) {
//				head = current;
//				current.sibling = prev;
//				return null;
//			}
//			BH_Node<T> next = current.sibling;
//			current.sibling = prev;
//			reverse(next, current);
//			return head;
		}
		
	    private BH_Node<T> findNode2(T key)
	    {
	    	BH_Node<T> temp = this, node = null;
	    	 
	        while (temp != null) 
	        {
	            if (temp.key == key) 
	            {
	                node = temp;
	                break;
	            }
	            if (temp.child == null)
	                temp = temp.sibling;
	            else 
	            {
	                node = temp.child.findNode2(key);
	                if (node == null)
	                    temp = temp.sibling;
	                else
	                    break;
	            }
	        }

	        return node;
	    }

				
	}
	
	public static void main(String[] args) {
		Binomial_Heap<Integer> bh = new Binomial_Heap<>();
		bh = bh.insert(10);
		bh = bh.insert(9);
		bh = bh.insert(73);
		bh = bh.insert(34);
		bh = bh.insert(5);
		bh = bh.insert(45);
		bh = bh.insert(12);
		bh = bh.insert(7);
		bh = bh.insert(25);
		bh = bh.insert(2);
		bh = bh.insert(14);
		
		bh.displayHeap();
		BH_Node<Integer> node;
		
		System.out.println((node = bh.head.findNode2(14)) != null ? "Found "+node.key : "Element Does not exist");
		
		bh.delete(bh.head.findNode2(14));
		
		System.out.println((node = bh.head.findNode2(14)) != null ? "Found "+node.key : "Element Does not exist");
		
		bh.delete(bh.head.findNode2(12));
		
		bh.displayHeap();
				
		System.out.println(bh.minimum().key);		
		bh.extractMin();
		System.out.println(bh.minimum().key);	
		bh.extractMin();
		System.out.println(bh.minimum().key);	
		bh.extractMin();
		System.out.println(bh.minimum().key);	
		bh.extractMin();
		System.out.println(bh.minimum().key);	
	}
}
