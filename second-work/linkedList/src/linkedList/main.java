package linkedList;

public class main {
    public static void main(String[] args) {
        System.out.println("==============");
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("Ana");
        linkedList.add("Maria");
        linkedList.add("Anny");
        linkedList.add("Gabriela");
        System.out.println(linkedList.get(2));
    }
}
