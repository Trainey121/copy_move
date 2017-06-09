package queue;

public class LinkList {
	private Node head;

	public int size() {
		int n = 0;
		Node current = this.head;
		while (current != null) {
			n++;
			current = current.next;
		}
		return n;
	}
	
	public Object get(int idx) {
		if (idx < 0) {
			throw new IndexOutOfBoundsException();
		}
		int n = 0;
		Node current = this.head;
		while (current != null) {
			if (n == idx) {
				return current.val;
			}
			n++;
			current = current.next;
		}
		throw new IndexOutOfBoundsException();
	}
	
	public void set(int idx, Object o) {
		if (idx < 0) {
			throw new IndexOutOfBoundsException();
		}
		int n = 0;
		Node current = this.head;
		while (current != null) {
			if (n == idx) {
				current.val = o;
				return;
			}
			n++;
			current = current.next;
		}
		throw new IndexOutOfBoundsException();
	}
	
	private Node getNode(int idx) {
		if (idx < 0) {
			throw new IndexOutOfBoundsException();
		}
		int n = 0;
		Node current = this.head;
		while (current != null) {
			if (n == idx) {
				return current;
			}
			n++;
			current = current.next;
		}
		throw new IndexOutOfBoundsException();
	}
	// Append
	public int append(Object o) {
		if (this.head == null) {
			this.head = new Node();
			this.head.val = o;
			return 1;
		}
		int n = 1;
		Node current = this.head;
		Node prev = null;
		while (current != null) {
			n++;
			prev = current;
			current = current.next;
		}
		prev.next = new Node();
		prev.next.val = o;
		return n;
	}
	// Insert
	public void insert(int idx, Object o) {
		if (idx == 0) {
			Node n = new Node();
			n.val = o;
			n.next = this.head;
			this.head = n;
			return;
		}
		Node prev = this.getNode(idx -1);
		Node next = prev.next;
		prev.next = new Node();
		prev.next.val = o;
		prev.next.next = next;
	}
	
	
	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.append("hi");
		list.append("yo");
		list.append("bye");
		list.set(1, "au revoir");
		list.insert(1, "inserted");
		list.insert(1,"hello");
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
	}

	//public int get() {
		// TODO Auto-generated method stub
	//	return 0;
	//}

}

class Node {
	public Object val;
	public Node next;
}