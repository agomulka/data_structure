public class MyStack<X> implements Stack<X>{
    private X[] data;
    private int stackPointer;

    public MyStack() {
        data = (X[]) new Object[1000];
        stackPointer = 0;
    }

    @Override
    public void push(X item){
        data[stackPointer] = item;
        stackPointer++;
    }

    @Override
    public X pop(){
        if(stackPointer == 0)
            throw new IllegalStateException("Empty stack!");
        return data[--stackPointer];
    }

    @Override
    public boolean contains(X item){
        for(int i = 0; i < stackPointer; i++){
            if(data[i].equals(item)) return true;
        }
        return false;
    }

    @Override
    public X access(X item){
        while(stackPointer > 0){
            X temp = pop();
            if(item.equals(temp)) return temp;
        }
        return null;
    }

    @Override
    public int size(){
        return stackPointer;
    }

    @Override
    public boolean isEmpty(){
        return (stackPointer <= 0);
    }


}
