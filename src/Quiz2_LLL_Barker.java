/*
 * Claude Barker, CS300, Quiz 2
 * 
 * This is a LLL implementation using an array as the data structure
 * 
 */

public class Quiz2_LLL_Barker {
	private int array_size = 100;
	private Node[] array;
	
	public Quiz2_LLL_Barker(){
		array = new Node[array_size];
	}
	
	public Object getData(int index){
		if(index >= 0 && index < array_size){
			return array[index].getData();
		}else{
			return null;
		}
	}
	
	public void insert(int index, Object obj){
		if(index >= 0 && index < array_size){
			System.out.println("Shifting LLL to the right");
			shiftRight(index, array_size - 1);
		}
		array[index] = new Node(obj);
	}
	
	public void delete(int index){
		if(index >= 0 && index < array_size){
			shiftLeft(index);
		}
	}
	
	// Recursive left shift
	public void shiftLeft(int index){
		if(index + 1 < array_size){
			array[index] = array[index + 1];
			shiftLeft(index + 1);
		}else{
			array[index] = null;
		}
	}
	
	// Recursive right shift
	// Start at the end of the array
	public void shiftRight(int stop, int start){
		if(start > stop){
			array[start] = array[start - 1];
			shiftRight(stop, --start);
		}else{
			array[start] = null;
		}
	}
	
	public void display(){
		System.out.println("Displaying LLL");
		
		boolean empty = true;
		
		for(int i = 0; i < array_size; ++i){
			
			if(null != array[i]){
				
				empty = false;
				System.out.print(array[i].getData() + " ");
			}
			
		}
		
		if(empty){
			System.out.println("List is empty!");
		}
		
		System.out.println();
	}
	
	// Node class
	private class Node{
		private Object data;
		
		public Node(Object data){
			this.data = data;
		}
		
		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}
		
	}
}


