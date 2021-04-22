import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Node;

import static org.junit.jupiter.api.Assertions.*;

class MyBinaryTreeTest {

    @Test
    void createEmptyTree(){
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        Assertions.assertEquals(0, tree.size());
    }

    @Test
    void addOneElement(){
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.add(5);
        Assertions.assertEquals(1, tree.size());
    }

    @Test
    void addRecursionOneElement(){
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.addRecursion(5);
        Assertions.assertEquals(1, tree.size());
    }


    @Test
    void checkIfContainsElementAndReturnFalse(){
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.addRecursion(5);
        tree.addRecursion(2);
        Assertions.assertEquals(false, tree.contain(3));
    }

    @Test
    void checkIfContainsElementAndReturnTrue(){
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.add(5);
        tree.add(2);
        Assertions.assertEquals(true, tree.contain(2));
    }

    @Test
    void deleteElementAndReturnSize(){
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.add(5);
        tree.add(2);
        tree.delete(2);
        Assertions.assertEquals(1, tree.size());
    }

    @Test
    void printTree(){
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(6);
        Assertions.assertEquals("5(2)(6)", tree.print());
    }


    @Test
    void checkIfBalanced(){
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.add(5);
        tree.add(4);
        tree.add(2);
        tree.add(3);
        tree.add(1);
        tree.add(7);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        Assertions.assertEquals(true, tree.isBalanced());
    }

    @Test
    void checkIfNotBalanced(){
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.add(5);
        tree.add(4);
        tree.add(2);
        tree.add(6);
        Assertions.assertEquals(false, tree.isBalanced());
    }

}