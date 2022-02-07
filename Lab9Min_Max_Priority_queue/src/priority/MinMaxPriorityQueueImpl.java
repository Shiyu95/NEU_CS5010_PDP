package priority;

import java.util.*;

public class MinMaxPriorityQueueImpl<T> implements MinMaxPriorityQueue<T>{
    private final TreeMap<Integer, Queue<T>> treeMap;


    //Constructor
    public MinMaxPriorityQueueImpl() {
        this.treeMap = new TreeMap<>();
    }


    // Add an item with the given priority into the queue.
    @Override
    public void add(T item, int priority) {
        if (!treeMap.containsKey(priority)) {
            Queue<T> queue = new LinkedList<>();
            treeMap.put(priority, queue);
        }
        treeMap.get(priority).add(item);
    }


    //Remove and return the item with the minimum priority
    @Override
    public T minPriorityItem() {
        if (treeMap.size() == 0 || treeMap.isEmpty()) {
            return null;
        }

        int minKeyValue = treeMap.firstKey();
        T minPriorityItem = treeMap.get(minKeyValue).poll();
        if(treeMap.get(minKeyValue).size()==0){
            treeMap.remove(minKeyValue);
        }

        return minPriorityItem;
    }


    // Remove and return the item with the maximum priority
    @Override
    public T maxPriorityItem() {
        if (treeMap.size() == 0 || treeMap.isEmpty()) {
            return null;
        }
        int maxKeyValue = treeMap.lastKey();
        if(treeMap.get(maxKeyValue).size()==0){
            treeMap.remove(maxKeyValue);
        }


        return treeMap.get(maxKeyValue).peek();

    }
}
