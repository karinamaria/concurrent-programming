package linkedList;

public class ThreadBusca extends Thread{
    private SinglyLinkedList singlyLinkedList;
    private Object data;

    public ThreadBusca(String name, SinglyLinkedList singlyLinkedList, Object data){
        super(name);
        this.singlyLinkedList = singlyLinkedList;
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("Thread ["+ this.getName() +"] iniciando busca por "+data);
        System.out.println("\tEncontrado? "+singlyLinkedList.contains(data));
        System.out.println("============================================");
    }
}
