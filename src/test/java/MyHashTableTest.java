import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashTableTest {

    @Test
    public void createEmptyTableAndCheckSize(){
        MyHashTable<Integer, String> hashTable = new MyHashTable<>(10);
        assertEquals(0, hashTable.size());
    }

    @Test
    public void putIntoTableAndCheckSize(){
        MyHashTable<Integer, String> hashTable = new MyHashTable<>(10);
        hashTable.put(3, "ala ma kota");
        assertEquals(1, hashTable.size());
    }

    @Test
    public void checkIfHasKeyAndReturnFalse(){
        MyHashTable<Integer, String> hashTable = new MyHashTable<>(10);
        hashTable.put(3, "ala ma kota");
        hashTable.put(4, "hello");
        assertEquals(false, hashTable.hasKey(1));
    }

    @Test
    public void checkIfHasKeyAndReturnTrue(){
        MyHashTable<Integer, String> hashTable = new MyHashTable<>(10);
        hashTable.put(3, "ala ma kota");
        hashTable.put(4, "hello");
        assertEquals(true, hashTable.hasKey(4));
    }

    @Test
    public void checkIfHasValueAndReturnTrue(){
        MyHashTable<Integer, String> hashTable = new MyHashTable<>(10);
        hashTable.put(3, "ala ma kota");
        hashTable.put(4, "hello");
        assertEquals(true, hashTable.hasValue("ala ma kota"));
    }

    @Test
    public void getFromTable(){
        MyHashTable<Integer, String> hashTable = new MyHashTable<>(10);
        hashTable.put(3, "ala ma kota");
        hashTable.put(4, "hello");
        assertEquals("hello", hashTable.get(4));
    }

    @Test
    public void getFromTableAndCheckSize(){
        MyHashTable<Integer, String> hashTable = new MyHashTable<>(10);
        hashTable.put(3, "ala ma kota");
        hashTable.put(4, "hello");
        hashTable.get(4);
        assertEquals(2, hashTable.size());
    }

    @Test
    public void deleteFromTableAndCheckSize(){
        MyHashTable<Integer, String> hashTable = new MyHashTable<>(10);
        hashTable.put(3, "ala ma kota");
        hashTable.put(4, "hello");
        hashTable.delete(4);
        assertEquals(1, hashTable.size());
    }

    @Test
    public void deleteFromTable(){
        MyHashTable<Integer, String> hashTable = new MyHashTable<>(10);
        hashTable.put(3, "ala ma kota");
        hashTable.put(4, "hello");
        assertEquals("hello", hashTable.delete(4));
    }

    @Test
    public void putTheSameKey(){
        MyHashTable<Integer, String> hashTable = new MyHashTable<>(10);
        hashTable.put(3, "ala ma kota");
        hashTable.put(4, "hello");
        hashTable.put(4, "kwik");
        assertEquals(3, hashTable.size());
    }
}