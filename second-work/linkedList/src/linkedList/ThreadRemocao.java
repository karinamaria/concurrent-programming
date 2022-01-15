package linkedList;

public class ThreadRemocao extends Thread{
    private SinglyLinkedList singlyLinkedList;
    private Object data;

    public ThreadRemocao(String name, SinglyLinkedList singlyLinkedList, Object data){
        super(name);
        this.singlyLinkedList = singlyLinkedList;
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("Thread ["+ this.getName() +"] adicionando "+data);
        System.out.println("\tRemovido? "+singlyLinkedList.remove(data));
        System.out.println("============================================");
    }
}
