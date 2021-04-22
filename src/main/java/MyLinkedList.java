public class MyLinkedList<X> {
    private Node first;
    private Node last;
    private int nodeCount;

    public MyLinkedList() {
        first = null;
        last = null;
        nodeCount = 0;
    }

    public int size(){
        return nodeCount;
    }

    public boolean isEmpty(){
        return size() == 0 ? true : false;
    }

    @Override
    public String toString() {
        StringBuffer values = new StringBuffer();
        Node curr = first;
        while(curr != null){
            values.append(curr.getNodeValue());
            curr = curr.getNextNode();

            if(curr != null) values.append(", ");
        }
        return values.toString();
    }

    public void add(X item){
        Node node = new Node(item);
        if( size() == 0){
            first = node;
            last = first;
        }
        else{
            last.setNextNode(node);
            last = node;
        }
        nodeCount++;
    }

    /**
     *
     * @param item
     * @param position - indexed from 1
     */
    public void insert(X item, int position){
        if(size()+1 < position) throw  new IllegalArgumentException("Wrong position");

        Node newNode = new Node(item);
        Node curr = first;
        if(position == 1) {
            newNode.setNextNode(curr);
            first = newNode;
        }
        else if(position == size()+1){
            add(item);
        }
        else{
            for(int i = 1; i < (position - 1) && curr != null; i++){
                curr = curr.getNextNode();
            }
            Node nextNode = curr.getNextNode();
            curr.setNextNode(newNode);
            newNode.setNextNode(nextNode);
            nodeCount++;
        }
    }

    public X remove(){ //remove first item
        X result;
        if (size() == 0) throw new IllegalStateException("Empty list!");

        result = first.getNodeValue();
        first = first.getNextNode();
        nodeCount--;
        return result;
    }

    public X removeAt(int position){
        if(size() < position) throw  new IllegalArgumentException("Wrong position");
        if(first == null) throw new IllegalStateException("Empty list");

        Node curr = first;
        Node prev = first;

        for(int i = 1; i < position && curr != null; i++){
            prev = curr;
            curr = curr.getNextNode();
        }
        X value = curr.getNodeValue();
        prev.setNextNode(curr.getNextNode());
        nodeCount--;
        return value;
    }

    public X get(int position){
        if(size()+1 < position) throw  new IllegalArgumentException("Wrong position");
        if(first == null) throw new IllegalStateException("Empty list");

        Node curr = first;
        for(int i = 1; i <= size() && curr != null; i++){
            if( i == position) return curr.getNodeValue();
            curr = curr.getNextNode();
        }
        return null;
    }

    public int find(X item){ //returns position
        if(first == null) throw new IllegalStateException("Empty list");
        Node curr = first;
        for(int i = 1; i <= size() && curr != null; i++){
            if(curr.getNodeValue().equals(item)) {return i;}
            curr = curr.getNextNode();
        }
        return -1;
    }

    private class Node {
        private Node next;
        private X value;

        public Node(X value) {
            this.next = null;
            this.value = value;
        }

        public void setNextNode(Node nextNode){
            this.next = nextNode;
        }

        public Node getNextNode(){
            return next;
        }

        public X getNodeValue(){
            return value;
        }
    }
}
