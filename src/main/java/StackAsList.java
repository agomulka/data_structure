import java.util.ArrayList;
import java.util.List;

public class StackAsList<X> implements Stack<X>{
    private int stackPointer;
    private List<X> data;

    public StackAsList() {
        data = new ArrayList<X>();
        stackPointer = 0;
    }

    @Override
    public void push(X item) {
        data.add(item);
        stackPointer++;
    }

    @Override
    public X pop() {
        if(stackPointer == 0) throw new IllegalStateException("Empty stack!");
        return data.remove(--stackPointer);

    }

    @Override
    public boolean contains(X item) {
        return (data.contains(item));
    }

    @Override
    public X access(X item) {
        try {
            while (stackPointer > 0) {
                X temp = pop();
                if (temp.equals(item)) return temp;
            }
        }
        catch (Exception e) {
            System.out.println("Not found!");
        }
        return null;
    }

    @Override
    public int size() {
        return stackPointer;
    }

    @Override
    public boolean isEmpty() {
        return stackPointer <= 0;
    }
}
