public interface Stack<E> {
    public void push(E item);
    public E pop();
    public boolean contains(E item);
    public E access(E item);
    public int size();
    public boolean isEmpty();

}
