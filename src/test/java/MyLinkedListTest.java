import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    public void checkSizeForEmptyList(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        assertEquals(0, myLinkedList.size());
    }

    @Test
    public void addItemAndReturnSize(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        Integer size = myLinkedList.size();
        assertEquals(1, size);
    }

    @Test
    public void createEmptyListAndCheckIsEmpty(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        assertEquals(true, myLinkedList.isEmpty());
    }

    @Test
    public void addToEmptyListAndCheckIsEmpty(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        assertEquals(false, myLinkedList.isEmpty());
    }



    @Test
    public void addToEmptyListAndPrintElements(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        myLinkedList.add(5);
        myLinkedList.add(7);
        assertEquals("2, 5, 7", myLinkedList.toString());
    }

    @Test
    public void insertAtSpecificPositionAndPrint(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        myLinkedList.add(5);
        myLinkedList.add(7);
        myLinkedList.insert(10, 2);
        assertEquals("2, 10, 5, 7", myLinkedList.toString());
    }

    @Test
    public void insertAtSpecificPositionToEmptyList(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.insert(10, 1);
        assertEquals("10", myLinkedList.toString());
    }

    @Test
    public void insertAtLastPosition(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        myLinkedList.add(5);
        myLinkedList.add(7);
        myLinkedList.insert(10, 4);
        assertEquals("2, 5, 7, 10", myLinkedList.toString());
    }

    @Test
    public void insertAtFirstPosition(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        myLinkedList.add(5);
        myLinkedList.add(7);
        myLinkedList.insert(10, 1);
        assertEquals("10, 2, 5, 7", myLinkedList.toString());
    }


    @Test
    public void insertAtWrongPosition(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        myLinkedList.add(5);
        myLinkedList.add(7);
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                myLinkedList.insert(10, 5);
            }
        });
    }

    @Test
    public void removeFirstElementAndCheckSize(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        myLinkedList.add(5);
        myLinkedList.add(7);
        myLinkedList.remove();
        assertEquals(2, myLinkedList.size());
    }

    @Test
    public void removeSecondElementAndCheckSize(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        myLinkedList.add(5);
        myLinkedList.add(7);
        myLinkedList.removeAt(2);
        assertEquals(2, myLinkedList.size());
    }

    @Test
    public void dontFindElementAndReturnFalse(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        myLinkedList.add(5);
        assertEquals(-1, myLinkedList.find(3));
    }

    @Test
    public void findElementAndReturnPosition(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        myLinkedList.add(5);
        assertEquals(2, myLinkedList.find(5));
    }
    @Test
    public void getElementFromSecondPosition(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        myLinkedList.add(5);
        myLinkedList.add(51);
        assertEquals(5, myLinkedList.get(2));
    }

    @Test
    public void getLastElementFromThirdPosition(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        myLinkedList.add(5);
        myLinkedList.add(51);
        assertEquals(5, myLinkedList.get(2));
    }


}