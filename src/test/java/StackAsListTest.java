import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackAsListTest {

    @Test
    public void checkSizeForEmptyStack(){
        Stack<Integer> myStack = new StackAsList<>();
        assertEquals(0, myStack.size());
    }

    @Test
    public void pushItemToStackAndReturnSize(){
        Stack<Integer> myStack = new StackAsList();
        myStack.push(11);
        Integer size = myStack.size();
        assertEquals(1, size);
    }

    @Test
    public void createEmptyStackAndCheckIsEmpty(){
        Stack<Integer> myStack = new StackAsList();
        assertEquals(true, myStack.isEmpty());
    }

    @Test
    public void pushToEmptyStackAndCheckIsEmpty(){
        Stack<Integer> myStack = new StackAsList();
        myStack.push(5);
        assertEquals(false, myStack.isEmpty());
    }

    @Test
    public void checkIfStackContainsElementAndReturnTrue(){
        Stack<Integer> myStack = new StackAsList();
        myStack.push(5);
        assertEquals(true, myStack.contains(5));
    }

    @Test
    public void checkIfStackContainsElementAndReturnFalse(){
        Stack<Integer> myStack = new StackAsList();
        myStack.push(5);
        assertEquals(false, myStack.contains(15));
    }

    @Test
    public void popFromStackAndCheckSize(){
        Stack<Integer> myStack = new StackAsList();
        myStack.push(5);
        myStack.push(2);
        myStack.pop();
        assertEquals(1,myStack.size());
    }

    @Test
    public void returnLastElement(){
        Stack<Integer> myStack = new StackAsList();
        myStack.push(5);
        myStack.push(66);
        assertEquals(66,myStack.access(66));
    }

    @Test
    public void returnFirstElement(){
        Stack<Integer> myStack = new StackAsList();
        myStack.push(5);
        myStack.push(66);
        assertEquals(5,myStack.access(5));
    }

}