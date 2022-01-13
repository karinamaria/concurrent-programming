package linkedList;

public class main {
    public static void main(String[] args) {
        System.out.println("==============");
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.push_back("Ana");
        linkedList.push_back("Maria");
        linkedList.push_back("Anny");
        linkedList.push_front("Gabriela");
        System.out.println(linkedList.get(2));
    }
}
