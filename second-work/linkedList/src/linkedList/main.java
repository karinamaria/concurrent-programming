package linkedList;

public class main {
    private static final int NUM_THREADS = 5;
    private static final Integer[] NUMBERS_TO_INSERT = {3,5,9,11,13};
    private static final Integer[] NUMBERS_TO_SEARCH = {2,5,40,11,13};
    private static final Integer[] NUMBERS_TO_REMOVE = {3,26,9,22,13};

    public static void main(String[] args) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        ThreadInsercao threadInsercao[] = new ThreadInsercao[NUM_THREADS];
//        ThreadBusca threadBusca[] = new ThreadBusca[NUM_THREADS];
        ThreadRemocao threadRemocao[] = new ThreadRemocao[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threadInsercao[i] = new ThreadInsercao("Thread Inserção "+(i+1), linkedList, NUMBERS_TO_INSERT[i]);
//            threadBusca[i] = new ThreadBusca("Thread Busca "+(i+1), linkedList, NUMBERS_TO_SEARCH[i]);
            threadRemocao[i] = new ThreadRemocao("Thread Remoção "+(i+1), linkedList, NUMBERS_TO_REMOVE[i]);
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threadInsercao[i].start();
//            threadBusca[i].start();
            threadRemocao[i].start();
        }

        try {
            for (int i = 0; i < NUM_THREADS; i++) {
                threadInsercao[i].join();
//                threadBusca[i].join();
                threadRemocao[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
