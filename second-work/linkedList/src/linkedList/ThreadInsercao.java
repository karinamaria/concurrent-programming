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
        System.out.println("Thread ["+ this.getName() +"] adicionando "+data);
        System.out.println("\tAdicionado? "+singlyLinkedList.add(data));
        System.out.println("============================================");
    }
}
