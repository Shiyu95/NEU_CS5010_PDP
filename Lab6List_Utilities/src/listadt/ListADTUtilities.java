package listadt;

import java.util.*;

public class ListADTUtilities<T>{
    //This method should throw a IllegalArgumentException if elements contains one or more null values.
    // Otherwise,appeared elements
    public static<T> ListADT<T> toList(T[] elements){
        ListADT list = new ListADTImpl();
        for(T element: elements){
            if(element!=null){
                list.addBack(element);
            }else {
                throw new IllegalArgumentException("The element can't be null");
            }
        }
        return list;
    }

    //This method should throw a IllegalArgumentException if elments contains one more more null values.
    //adds the specified elements to the end of the specified list
    public static<T> void addAll(ListADT<T> list, T... elements){
        for(T element: elements){
            if(element!=null){
                list.addBack(element);
            }else {
                throw new IllegalArgumentException("The element can't be null");
            }
        }

    }

    //This method will return the number of elements in the specified list equal to the specified element
    public static<T> int frequency(ListADT<T> list, T element){
        int count = 0;
        for(int i = 0; i<list.getSize();i++) {
            if(list.get(i).equals(element)){
                count++;
            }
        }
        return count;
    }

    //This method should throw a IllegalArgumentException if either list is null or if either list contains a null element.
    //Otherwise, the method should return true if the two lists have no elements in common
    public static<T>  boolean disjoint(ListADT<?> one, ListADT<?> two){
        if(one==null||two == null){
            throw new IllegalArgumentException("list is null or list contains a null element");
        }
        Map<T, Integer> map = new HashMap<>();
        for(int i = 0; i<one.getSize();i++){
            map.put((T)one.get(i),1);
        }
        for (int i =0; i<two.getSize();i++){
           if(null!= map.get(two.get(i))){
               continue;
           }
           return true;
        }
        return false;
    }


    //This method that returns true if the two lists are equal
    public static<T>  boolean equals(ListADT<?> one, ListADT<?> two){
        if(one==null||two == null){
            throw new IllegalArgumentException("list is null or list contains a null element");
        }
        if(one.getSize()==two.getSize()){
            for(int i = 0; i<one.getSize();i++){
                if(two.get(i).equals(one.get(i))){
                    return true;
                    }
                }
            }
        return false;
    }


    //This method reverses the order of the elements in the specified list.
    public static<T> void reverse(ListADT<?> list){
        ArrayList reversed= new ArrayList();
        for (int i=list.getSize()-1;i>=0;i--){
            T t = (T) list.get(i);
            reversed.add(t);
        }
    }


    //This method that swaps the elements at the specified position in the specified list.
    public static<T>  void swap(ListADT<?> list, int i, int j){
        if(i<0||j<0||i>=list.getSize()||j>=list.getSize()){
            throw new IndexOutOfBoundsException("i or j are out of range.");
        }
        ListADT<T> list1 = (ListADT<T>) list;
        T element1 = list1.get(i);
        T element2 = list1.get(j);
        list1.remove(element1);
        list1.remove(element2);
        list1.add(i, element2);
        list1.add(j, element1);



    }
}
