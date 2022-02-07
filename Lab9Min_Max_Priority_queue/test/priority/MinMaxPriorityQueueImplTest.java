package priority;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MinMaxPriorityQueueImplTest {

    MinMaxPriorityQueue<String> queue;

    @org.junit.Before
    public void setUp(){
        queue = new MinMaxPriorityQueueImpl<>();
        queue.add( "apple", 3);
        queue.add( "banana", 1);
        queue.add( "pear", 2);
        queue.add( "watermelon", 4);
    }

    @org.junit.Test
    public void add() {
        queue.add((String) "cherry", 5);
        assertEquals("cherry", queue.maxPriorityItem());
    }

    @org.junit.Test
    public void minPriorityItem() {
        assertEquals("banana", queue.minPriorityItem());
    }

    @org.junit.Test
    public void maxPriorityItem() {
        assertEquals("watermelon", queue.maxPriorityItem());
    }

    @org.junit.Test
    public void sameMaxPriorityItem() {
        queue = new MinMaxPriorityQueueImpl<>();
        queue.add( "apple", 1);
        queue.add( "banana", 1);
        queue.add( "pear", 1);
        queue.add( "watermelon", 1);
        assertEquals("apple", queue.maxPriorityItem());
        assertEquals("apple", queue.minPriorityItem());
    }
}