package linkedList;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;
    private ReadWriteLock lock;

    public SinglyLinkedList() {
        head = null;
        size = 0;
        lock = new ReentrantReadWriteLock(true);
    }

    public boolean add(T data){
        return pushBack(data);
    }

    public boolean contains(Object o){
        lock.readLock().lock();
        System.out.println("[" + Thread.currentThread().getName() + "] Buscando por " + o);

        Node<T> temp = head;
        for (int i = 0; i < size; i++){
            if(temp.data.equals(o)) {
                System.out.println("[" + Thread.currentThread().getName() + "] Item encontrado");
                lock.readLock().unlock();
                return true;
            }
            temp = temp.next;
        }

        System.out.println("[" + Thread.currentThread().getName() + "] Item não encontrado");
        lock.readLock().unlock();
        return false;
    }

    public boolean remove(Object o) {
        lock.writeLock().lock();
        System.out.println("[" + Thread.currentThread().getName() + "] Tentando remover " + o);

        Node<T> current = head;
        Node<T> previous = null;
        for (int i = 0; i < size; i++){
            if(current.data.equals(o)){
                remove(current, previous);
                size--;

                System.out.println("[" + Thread.currentThread().getName() + "] Item removido");
                lock.writeLock().unlock();
                return true;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("[" + Thread.currentThread().getName() + "] Item não existe");
        lock.writeLock().unlock();
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

        lock.writeLock().lock();
        System.out.println("[" + Thread.currentThread().getName() + "] Adicionando " + data);
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
        System.out.println("[" + Thread.currentThread().getName() + "] Item adicionado");
        lock.writeLock().unlock();

        return true;
    }

    private void checkIfDataIsNull(Object data){
        if(data == null)
            throw new NullPointerException("Data is null");
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