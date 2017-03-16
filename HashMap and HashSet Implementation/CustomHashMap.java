package hashmap;

public class CustomHashMap<K, V>{
	private Entry<K,V>[] hashtable;
	private int capacity;
	private int size;
	
	public CustomHashMap() {
		this.capacity = 20;
		this.hashtable = new Entry[20];
		this.size = 0;
	}
	
	public CustomHashMap(int capacity) {
		this.capacity = capacity;
		this.hashtable = new Entry[capacity];
		this.size = 0;
	}
	
	public boolean contains(K key) {
		int keyHash = hash(key);
		Entry<K,V> entry = this.hashtable[keyHash];
		while(entry != null) {
			if(entry.key == key)
				return true;
			entry = entry.next;
		}
		return false;
	}
	
	public boolean put(K key, V value) {
		int keyHash = hash(key);
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		Entry<K, V> entry = this.hashtable[keyHash];
		if (entry == null) {
			this.hashtable[keyHash] = newEntry;
			this.size++;
			return true;
		}
		Entry<K, V> previousEntry = null;
		while(entry != null) {
			if (entry.key == key) {
				entry.value = value;
				return true;
			}
			previousEntry = entry;
			entry=entry.next;
		}
		this.size++;
		previousEntry.next = newEntry;
		return true;	
	}
	
	public boolean remove(K key) {
		if (! this.contains(key)) {
			return false;
		}
		else {
			this.size--;
			int keyHash = hash(key);
			Entry<K, V> entry = this.hashtable[keyHash];
			if (entry.key == key) {
				this.hashtable[keyHash] = null;
				return true;
			}
			Entry<K, V> previousEntry = null;
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
		for(int i = 0 ; i < this.capacity ; i++) {
			Entry<K, V> entry = this.hashtable[i];
			while(entry != null) {
				System.out.println("Key : " + entry.key + " Value : " + entry.value);
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
	
	static class Entry<K, V> {
		private K key;
		private V value;
		private Entry<K,V> next;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		CustomHashMap<String, Integer> myHashMap = new CustomHashMap<>();
		
		// put values with same key - value should get updated.
		myHashMap.put("A", 10);
		myHashMap.put("A", 20);
		myHashMap.put("A", 30);
		myHashMap.put("A", 40);
		myHashMap.put("A", 50);
		myHashMap.put("B", 30);
		myHashMap.put("C", 40);
		myHashMap.put("D", 50);
		myHashMap.put("D", 60);
		System.out.println("Hashmap Size : "+myHashMap.size);
		myHashMap.display();

		//remove a key
		myHashMap.remove("A");
		System.out.println("\nHashmap Size : "+myHashMap.size);
		myHashMap.display();

		// put keys with same hash - collision handling
		// "a" and "AH" has same hash value
		myHashMap.put("a", 60);
		myHashMap.put("AH", 70);
		System.out.println("\nHashmap Size : "+myHashMap.size);
		myHashMap.display();		
	}
}
