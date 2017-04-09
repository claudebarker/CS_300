package dave;


public class Node<T> implements Comparable<T> {
    private T data;
    private Node<T> next = null;
     
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Node<T> getNext() {
        return next;
    }
    public Node<T> setNext(Node<T> next) {
        this.next = next;
        return this.next;
    }
    @Override  // annotation
    public int compareTo(T data) {
        if (data == this.data) return 0;
        else return 1;
    }
}