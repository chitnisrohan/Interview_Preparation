package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    Map<Integer, Node> map;
    Node head;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (head == null || !map.containsKey(key)) {
            return -1;
        }
        moveToTail(key);
        return map.get(key).value;
    }

    private void moveToTail(int key) {
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        node.next = head;
    }

    public void put(int key, int value) {
        if (this.head == null) {
            head = new Node(key, value);
            head.prev = head;
            head.next = head;
            map.put(key, head);
            return;
        }
        if (map.keySet().size() == this.capacity) {
            removeFromHead();
            map.remove(head.key);
        }
        if (map.get(key) != null) {
            map.get(key).value = value;
            moveToTail(key);
            return;
        }
        Node newNode = new Node(key, value);
        head.prev.next = newNode;
        newNode.prev = head.prev;
        newNode.next = head;
        head.prev = newNode;
        map.put(key, newNode);
        //moveToTail(key);
    }

    private void removeFromHead() {
        head.next.prev = head.prev;
        head.prev.next = head.next;
        head = head.next;
    }

    class Node {
        Node prev = null;
        Node next = null;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
