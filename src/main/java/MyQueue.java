public class MyQueue implements Queue {
    private Object[] data;
    private int start, end;

    public MyQueue() {
        this(1000);
    }

    public MyQueue(int size) {
        data = new Object[size];
        this.start = -1;
        this.end = -1;
    }

    public int size(){
        return end == -1 && start == -1 ? 0 : end-start+1;
    }

    public boolean isEmpty(){
        return size() == 0 ? true : false;
    }

    public void enQueue(Object item){
        if( (end+1) % data.length == start) throw new IllegalStateException("Full queue!");
        else if (size() == 0) {
            start++;
            end++;
            data[end] = item;
        }
        else{
            end++;
            data[end] = item;
        }
    }

    public Object deQueue(){
        Object result = null;
        if( size() == 0) throw new IllegalStateException("Empty queue!");
        else if(start == end){
            result = data[start];
            data[start] = null;
            start = -1;
            end = -1;
        }
        else{
            result = data[start];
            data[start] = null;
            start++;
        }
        return result;
    }

    public boolean contains(Object item){
        int curr = start;
        if(size() == 0) return false;
        while(curr != end+1){
            if(data[curr].equals(item)) return true;
            curr++;
        }
        return false;
    }

    public Object access(int position){
        int curr = start;
        int trueIndex = 0;
        if(size() == 0 || position > size()) throw new IllegalArgumentException("Wrong position or empty queue!");
        while(curr != end+1){
            if(trueIndex == position) return data[curr];
            curr++;
            trueIndex++;
        }
        throw new IllegalArgumentException("Not found!");
    }


}
