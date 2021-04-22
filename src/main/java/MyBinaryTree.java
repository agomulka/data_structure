public class MyBinaryTree<X extends Comparable> {
    Node root;
    int size;

    public MyBinaryTree(){
        this.root = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public void add(X item) {
        Node node = new Node(item);
        if (root == null) {
            this.root = node;
            this.size++;
            }
        else {
            Node x = this.root;
            Node parent = this.root;
            while (x != null) {
                parent = x;
                int val = x.getValue().compareTo(item);
                if (val < 0) x = x.getRight();
                else if(val > 0) x = x.getLeft();
            }
            if(parent.getValue().compareTo(item) < 0)
                parent.setRight(node);
            else if(parent.getValue().compareTo(item) > 0)
                parent.setLeft(node);
            }
        }


    public void addRecursion(X item){
        Node newNode = new Node(item);
        if(size() == 0 ) {
            this.root = newNode;
            this.size++;
        }
        else{
            insert(this.root, newNode);
        }
    }

    private void insert(Node parent, Node child){
        if(child.getValue().compareTo(parent.getValue()) < 0){ //child is less then parent -> left child
            if(parent.getLeft() == null){
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            }
            else{
                insert(parent.getLeft(), child);
            }
        }
        else if(child.getValue().compareTo(parent.getValue()) > 0){
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            } else {
                insert(parent.getRight(), child);
            }
        }
        //no duplicates allowed
    }

    public boolean contain(X item){
        Node currentNode = getNode(item);
        if( currentNode == null) return false;
        else{
            return true;
        }
    }


    private Node getNode(X value){
        Node current = this.root;
        while(current != null){
            int val = value.compareTo(current.getValue());
            if(val == 0)
                return current;
            else if(val < 0){
                current = current.getLeft();
            }
            else{
                current = current.getRight();
            }
        }
        return null;
    }

    public boolean delete(X value){
        boolean deleted = false;
        if(this.root == null) throw new IllegalStateException("Empty tree");
        Node current = getNode(value);
        if(current != null){
            if(current.getLeft() == null && current.getRight() == null){
                unlink(current, null);
                deleted = true;
                this.size--;
            }
            else if(current.getLeft() == null && current.getRight() != null){
                unlink(current, current.getRight());
                deleted = true;
                this.size--;
            }
            else if(current.getLeft() != null && current.getRight() == null){
                unlink(current, current.getLeft());
                deleted = true;
                this.size--;
            }
            else{
                Node child = current.getLeft();
                while(child.getRight() != null && child.getLeft() != null){
                    child = child.getRight();
                }
                child.getParent().setRight(null);
                child.setLeft(current.getLeft());
                child.setRight(current.getRight());
                unlink(current, child);
                deleted = true;
                this.size--;
            }
        }

        return deleted;
    }

    private void unlink(Node current, Node newNode) {
        if(current == this.root){
            newNode.setLeft(current.getLeft());
            newNode.setRight(current.getRight());
            this.root = newNode;
        }
        else if(current == current.getParent().getRight()){
            current.getParent().setRight(newNode);
        }
        else
            current.getParent().setLeft(newNode);

    }


    private class Node{
        private Node parent, left, right;
        private X value;

        public Node( X value){
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public X getValue() {
            return value;
        }

        public void setValue(X value) {
            this.value = value;
        }
    }
}
