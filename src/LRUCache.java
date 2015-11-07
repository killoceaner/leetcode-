import java.awt.HeadlessException;
import java.nio.charset.MalformedInputException;
import java.util.HashMap;

class Node {
	int key;
	int value;
	Node pre;
	Node next;

	Node(int key, int value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
	}
}

public class LRUCache {
	private int capacity;
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}

	/**
	 * 移除双向链表的节点
	 * 
	 * @param n
	 */
	public void remove(Node n) {
		if (n.pre != null) {
			n.pre.next = n.next;
		} else {
			head = n.next;
		}

		if (n.next != null) {
			n.next.pre = n.pre;
		} else {
			end = n.pre;
		}

	}

	public void setHead(Node n) {
		if (head != null) {
			n.next = head;
			head.pre = n;
		} else {
			head = n;
		}

		if (end == null) {
			end = head;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node oldval = map.get(key);
			remove(oldval);
			oldval.value = value ;
			setHead(oldval);
		}else{
			Node n = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				end = end.pre;
				//end.next = null ;
				setHead(n);				
			}else{
				setHead(n);
			}
			map.put(key, n);
		}
	}
	
	public static void main(String[] args) {
		LRUCache c = new LRUCache(1);
		c.set(2, 1);
		System.out.println(c.get(2));
		c.set(3, 2);
		System.out.println(c.get(2));
		System.out.println(c.get(3));
	}
}
