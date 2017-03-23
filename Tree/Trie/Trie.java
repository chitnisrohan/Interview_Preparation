package tree_problems;

import java.util.HashMap;

public class Trie {
	private HashMap<Character, Trie> node;
	private boolean isWord;
	
	public Trie() {
		this.node = new HashMap<>();
		this.isWord = false;
	}
		
	public void addString(String str) {
		if (str.isEmpty()) {
			this.isWord = true;
			return;
		}
		char c = str.charAt(0);
		if(this.node.containsKey(c)) {
			this.node.get(c).addString(str.substring(1));
		} else {
			Trie newNode = new Trie();
			this.node.put(c, newNode);
			newNode.addString(str.substring(1));
		}
	}
	
	public boolean containWord(String str) {
		if (str.isEmpty()) {
			return this.isWord;
		}
		char c = str.charAt(0);
		if (this.node.containsKey(c)) {
			return this.node.get(c).containWord(str.substring(1));
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Trie root = new Trie();
		root.addString("Alice");
		root.addString("Wonderland");
		root.addString("Wonder");
		System.out.println(root.containWord("Alice"));
		System.out.println(root.containWord("Wonderland"));
		System.out.println(root.containWord("Wonder"));
		System.out.println(root.containWord("Alicee"));
	}	
}
