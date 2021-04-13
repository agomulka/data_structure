import java.util.ArrayList;
import java.util.List;

public class QueueList implements Queue{

    private List<Object> data;
    private int start, end;

    public QueueList() {
        this(1000);
    }

    public QueueList(int size) {
        data = new ArrayList<>(size);
        this.start = -1;
        this.end = -1;
    }

    public int size(){
        return data.size();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void enQueue(Object item){
        if (size() == 0) {
            start++;
        }
        end++;
        data.add(end, item);
    }

    public Object deQueue(){
        Object result;
        if( size() == 0) throw new IllegalStateException("Empty queue!");
        else if(start == end){
            result = data.get(start);
            data.remove(start);
            start = -1;
            end = -1;
        }
        else{
            result = data.get(start);
            data.remove(start);
            start++;
        }
        return result;
    }

    public boolean contains(Object item){
        int curr = start;
        if(size() == 0) return false;
        while(curr != end+1){
            if(data.get(curr).equals(item)) return true;
            curr++;
        }
        return false;
    }

    public Object access(int position){
        int curr = start;
        int trueIndex = 0;
        if(size() == 0 || position > size()) throw new IllegalArgumentException("Wrong position or empty queue!");
        while(curr != end+1){
            if(trueIndex == position) return data.get(curr);
            curr++;
            trueIndex++;
        }
        throw new IllegalArgumentException("Not found!");
    }


}
