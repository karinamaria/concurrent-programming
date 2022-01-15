package linkedList;

public class ThreadInsercao extends Thread{
    private SinglyLinkedList singlyLinkedList;
    private Object data;

    public ThreadInsercao(String name, SinglyLinkedList singlyLinkedList, Object data){
        super(name);
        this.singlyLinkedList = singlyLinkedList;
        this.data = data;
    }

    @Override
    public void run() {
        singlyLinkedList.add(data);
    }
}
