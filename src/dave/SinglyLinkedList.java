package dave;


/*
 *	CLASS FEATURES:
 *
 getHeadNode() Returns the first node in the list
 getTailNode() Returns the last node in the list
 isEmpty() Determines if the list is empty or not. Returns true if is empty, false otherwise.
 getSize() Returns the size of the list, or number of nodes
 clear() Clears the list of all nodes/data
 insert(data) Inserts a node (with the provided data) to the end of the list
 insertFirst(data) Inserts a node (with the provided data) to the front of the list
 insertAt(data, index) Inserts a node (with the provided data) at the index indicated.
### insertBefore(nodeData, dataToInsert) Inserts a node (with the dataToInsert) before the first node containing nodeData
### insertAfter(nodeData, dataToInsert) Inserts a node (with the dataToInsert) after the first node containing nodeData
 remove() Removes the tail node from the list
 removeFirst() Removes the head node from the list
### removeAt(index) Removes the node at the index provided
### removeNode(nodeData) Removes the first node that contains the nodeData provided
### indexOf(nodeData) Returns the index of the first node containing the provided nodeData. If a node cannot be found containing the provided data, -1 is returned.
### contains(nodeData) Determines whether or not the list contains the provided nodeData
### find(nodeData) Returns the fist node containing the provided nodeData. If a node cannot be found containing the provided data, -1 is returned.
### findAt(index) Returns the node at the location provided by index
### forEach(fn) Utility function to iterate over the list and call the fn provided on each node, or element, of the list
### toArray() Returns an array of all the data contained in the list
 printList() Prints to the console the data property of each node in the list
 * 
 */


public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    
    // get head node
    public Node<T> getHead() {
    		return this.head;
    }
    
    // get tail node
    public Node<T> getTail() {
    		return this.tail;
    }
    
    public void test() {
    		//if (this.getHead() == getTail()) System.out.println("BINGO!");
    		if (isEmpty() == true) System.out.println("BINGO!");
    }
    
    // return true if the list is empty
    public boolean isEmpty() {
    		if (head == null) return true;
    		return false;
    }
    
    // return the size of the list
    public int getSize() {
    		return this.size;
    }
    
    // clear the list
    public void clear() {
    		head = tail = null;
    		size = 0;
    }
    
    // insert a node at the end of the list
    public void insert(T data) {
        Node<T> node = new Node<T>();
        node.setData(data);
        System.out.println("inserting at tail: "+data);

        if (head == null) head = tail = node;
        else {
        		tail.setNext(node);
        		tail = node;
        }
        ++size;
    }
    
    // insert a node at the front of the list
    public void insertFirst(T data) {
    		Node<T> node = new Node<T>();
    		node.setData(data);
    		System.out.println("inserting at head: "+data);
    		
    		if (head == null) head = tail = node;
    		else {
    			Node<T> current = head;
    			head = node;
    			head.setNext(current);
    		}
    		++size;
    }
    
    // insert a node at an index
    public int insertAt(T data, int index) {
    	    if (index == 1) {
			this.insertFirst(data);
			return 0;
    		} else if (index < 1 || size < index) {
    			System.out.println("error: index is out of bounds");
    			return -1;
    		}

    		Node<T> node = new Node<T>();
		node.setData(data);
		System.out.println("inserting at index: "+index);
		
		Node<T> temp = head;
		Node<T> current = null;
		int i;
		for (i=0; i<index-1; ++i) {
			current = temp;
			temp = temp.getNext();
		}
		(current.setNext(node)).setNext(temp);
		++size;
		return 0;
    }
    
    // remove the tail node
    public void remove() {
        if (head == null) {
        		System.out.println("Empty");
        		return;
        } else if (head == tail) {
        		head = tail = null;
        		return;
        }

        Node<T> current = head;
        while (current.getNext() != tail) {
        		current = current.getNext();
        }        
        System.out.println("Deleted: "+(current.getNext()).getData());
        current.setNext(null);
        tail = current;
    }
    
    // remove the head node
    public void removeFirst() {
        if (head == null) {
        		System.out.println("Empty");
        		return;
        } else if (head == tail) {
        		head = tail = null;
        		return;
        }
        
        System.out.println("Deleted: "+head.getData());
        head = head.getNext();
    }
    
    // remove node that has matching data
    public Node<T> removeNode(T data) {
            if (head == null) return null;
            else if (head == tail) {
                head = tail = null;
                --size;
            }

            Node<T> current = head;
        for (int index=1; index<size+1; ++index) {
        		if (current.compareTo(data) == 0) {
                    //this.removeAt(index);
                    System.out.println("i: "+index);
                    return current;
                }
                current = current.getNext();
        }
        return null;
    }
     
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getData()+" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
     
    public static void main(String args[]){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        int[] input = {2, 32, 54, 89, 235};
        int[] input2 = {5, 10, 15, 20};
        
        for (int i: input) sll.insert(i);
        for (int i: input2) sll.insertFirst(i);
        
        sll.insertAt(888, 0);
        sll.insertAt(888, 1);
        sll.insertAt(999, 2);
        sll.insertAt(111, 12);
        
        sll.printList();
        for (int i=-1; i<sll.getSize(); ++i) {
        		sll.printList();
        		sll.removeFirst();
        }
        
        sll.printList();
        sll.clear();
        System.out.println(sll.getSize());
        sll.test();
	}
}
