public interface Queue {

    public int size();
    boolean isEmpty();
    void enQueue(Object item);
    Object deQueue();
    boolean contains(Object item);
    Object access(int position);


}
