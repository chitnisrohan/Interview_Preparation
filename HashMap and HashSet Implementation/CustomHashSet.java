package hashmap;

public class CustomHashSet<K>{
	private Entry<K>[] hashtable;
	private int capacity;
	private int size;
	
	public CustomHashSet() {
		this.capacity = 20;
		this.hashtable = new Entry[20];
		this.size = 0;
	}
	
	public CustomHashSet(int capacity) {
		this.capacity = capacity;
		this.hashtable = new Entry[capacity];
		this.size = 0;
	}
	
	public boolean contains(K key) {
		int keyHash = hash(key);
		Entry<K> entry = this.hashtable[keyHash];
		while(entry != null) {
			if(entry.key == key)
				return true;
			entry = entry.next;
		}
		return false;
	}
	
	public boolean add(K key) {
		if (this.contains(key)) {
			return false;
		}
		else {
			this.size++;
			int keyHash = hash(key);
			Entry<K> newEntry = new Entry<K>(key);
			Entry<K> entry = this.hashtable[keyHash];
			if (entry == null) {
				this.hashtable[keyHash] = newEntry;
				return true;
			}
			while(entry.next != null) {
				entry=entry.next;
			}
			entry.next = newEntry;
			return true;
		}
	}
	
	public boolean remove(K key) {
		if (! this.contains(key)) {
			return false;
		}
		else {
			this.size--;
			int keyHash = hash(key);
			Entry<K> entry = this.hashtable[keyHash];
			if (entry.key == key) {
				this.hashtable[keyHash] = null;
				return true;
			}
			Entry<K> previousEntry = null;
			while(entry.next != null) {
				if(entry.key == key) {
					previousEntry.next = entry.next;
					break;
				}
				previousEntry = entry;
				entry=entry.next;
			}
			return true;
		}
	}
	
	public void display() {
		int count = 0;
		for(int i = 0 ; i < this.capacity ; i++) {
			Entry<K> entry = this.hashtable[i];
			while(entry != null) {
				count++;
				if(count == this.size) {
					System.out.print(entry.key);
				} else {
					System.out.print(entry.key + ", ");
				}
				entry = entry.next;
			}
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public int hash(K key) {
		char[] a = key.toString().toCharArray();
		int sum = 0;
		for(int i=0 ; i<a.length ; i++) {
			sum += (int)a[i];
		}
		return sum % this.capacity;
	}
	
	static class Entry<K> {
		private K key;
		private Entry<K> next;
		
		public Entry(K key) {
			this.key = key;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		CustomHashSet<String> myHashSet = new CustomHashSet<>();
		
		// "a" and "AH" has same hash - test collision
		String[] A = {"A", "B", "A", "a", "AH"};
		
		for(String str : A) {
			myHashSet.add(str);
		}
		
		System.out.println("HashSet : ");
		myHashSet.display();		
	}
}
