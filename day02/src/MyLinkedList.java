public class MyLinkedList {

	private Node head;
	private Node tail;
	private int size;

	private class Node {
		Chicken val;
		Node prev;
		Node next;

		private Node(Chicken d, Node prev, Node next) {
			this.val = d;
			this.prev = prev;
			this.next = next;
		}
	}

	public MyLinkedList() {
		head = null;
		tail = null;
		size =0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(Chicken c) {
		addLast(c);
	}

	public Chicken pop() {
		return removeLast();
	}

	public void addLast(Chicken e) {
		Node c = new Node(e,null,null)
		if(size ==0){
			head = c;
			tail = c;
		}else{
			tail.next = c;
			c.prev = tail;
			tail = c;
		}
		size++;
	}

	public void addFirst(Chicken e) {
		Node c = new Node(e,null,null)
		if(size ==0){
			head = c;
			tail = c;
		}else{
			c.next = head;
			head.prev = c;
			head = c;
		}
		size++;
	}

	public Chicken get(int index) {
		if (index < size && index>=0){
			Node ex = head;
			for(int i = 0; i <index;i++){
				ex = ex.next;
			}
			return ex.val;
		}else {
			return null;
		}
	}

	public Chicken remove(int index) {

		if(size > 0) {
			if (index == size - 1) {
				return removeLast();
			} else if (index == 0) {
				return removeFirst();

			} else if (index < size) {
				Node ex = head;
				for (int i = 0; i < index; i++) {
					ex = ex.next;
				}
				ex.prev.next = ex.next;
				ex.next.prev = ex.prev;
				size--;
				return ex.val;
			} else {
				return null;
			}
		}
	}

	public Chicken removeFirst() {
		if(size <=0){
			return null;
		}else{
			head.next.prev = null;
			Node ex = head;
			head = ex.next;
			size--;
			return ex.val;
		}
	}

	public Chicken removeLast() {
		if(size <=0){
			return null;
		}else{
			Node ex = tail;
			ex.prev.next = null;
			tail = ex.prev;
			size--;
			return ex.val;
		}
	}
}