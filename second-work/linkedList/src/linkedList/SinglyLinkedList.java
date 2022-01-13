package linkedList;

public class SinglyLinkedList<T> {
    Node<T> head;
    int size;

    public SinglyLinkedList() {
    }

    public boolean push_front(T data){
        Node<T> newNode = new Node(data);

        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean push_back(T data){
        Node<T> newNode = new Node(data);

        if(head == null){
            head = newNode;
        }else{
            Node<T> current = head;

            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;

        return true;
    }

    public T get(int index){
        checkElementIndex(index);
        return node(index).data;
    }

    private Node<T> node(int index) {
        Node<T> x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private void checkElementIndex(int index){
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

    }}
