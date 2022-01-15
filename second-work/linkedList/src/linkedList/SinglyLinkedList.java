package linkedList;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean add(T data){
        return pushBack(data);
    }

    public T get(int index){
        checkElementIndex(index);
        return node(index).data;
    }

    public boolean contains(Object o){
        Node<T> temp = head;
        for (int i = 0; i < size; i++){
            if(temp.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public boolean remove(Object o) {
        Node<T> current = head;
        Node<T> previous = null;
        for (int i = 0; i < size; i++){
            if(current.data.equals(o)){
                remove(current, previous);
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    private void remove(Node<T> currentNode, Node<T> previousNode){
        if(previousNode == null){//remove first
            head = currentNode.next;
        }else{
            previousNode.next=currentNode.next;
        }
    }

    private boolean pushBack(T data){
        checkIfDataIsNull(data);
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

    private void checkIfDataIsNull(Object data){
        if(data == null)
            throw new NullPointerException("Data is null");
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

        public Node(){}

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

    }}