import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueListTest {


    @Test
    public void checkSizeForEmptyQueue(){
        Queue myQueue = new QueueList();
        assertEquals(0, myQueue.size());
    }

    @Test
    public void enQueueItemAndReturnSize(){
        Queue myQueue = new QueueList();
        myQueue.enQueue("hello");
        Integer size = myQueue.size();
        assertEquals(1, size);
    }

    @Test
    public void createEmptyQueueAndCheckIsEmpty(){
        Queue myQueue = new QueueList();
        assertEquals(true, myQueue.isEmpty());
    }

    @Test
    public void enQueueToEmptyQueueAndCheckIsEmpty(){
        Queue myQueue = new QueueList();
        myQueue.enQueue("hello");
        assertEquals(false, myQueue.isEmpty());
    }

    @Test
    public void checkIfQueueContainsElementAndReturnTrue(){
        Queue myQueue = new QueueList();
        myQueue.enQueue("hello");
        assertEquals(true, myQueue.contains("hello"));
    }

    @Test
    public void checkIfQueueContainsElementAndReturnFalse(){
        Queue myQueue = new QueueList();
        myQueue.enQueue("hello");
        assertEquals(false, myQueue.contains("hi"));
    }

    @Test
    public void deQueueAndCheckSize(){
        Queue myQueue = new QueueList();
        myQueue.enQueue("hello");
        myQueue.enQueue("sun");
        myQueue.deQueue();
        assertEquals(1,myQueue.size());
    }

    @Test
    public void returnLastElement(){
        Queue myQueue = new QueueList();
        myQueue.enQueue("hello");
        myQueue.enQueue("sun");
        assertEquals("sun",myQueue.access(myQueue.size()-1));
    }

    @Test
    public void returnFirstElement(){
        Queue myQueue = new QueueList();
        myQueue.enQueue("hello");
        myQueue.enQueue("sun");
        assertEquals("hello",myQueue.access(0));
    }

}