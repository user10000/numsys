/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package num;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 *
 * @author Guest
 */
public class IntList {
    public int[] list;
    
    private int size;
    
    public IntList() {
        this(10);
    }
    
    public IntList(int initSize) {
        list = new int[initSize];
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean add(final int e) {
        add(e, size);
        return true;
    }
    
    public boolean add(final int index, final int e) {
        accomodateNewElements(1);
        for (int i = index ; i < size ; i++) {
            list[i + 1] = list[i];
        }
        
        list[index] = e;
        
        size++;
        return true;
    }
    
    public boolean addAll(int... e) {
        accomodateNewElements(e.length);
        for (int i : e) {
            list[size++] = i;
        }
        return true;
    }
    
    private void accomodateNewElements(int amt) {
        if (size + amt > list.length) {
            int[] newList = new int[(size + amt) * 2];
            System.arraycopy(list, 0, newList, 0, size);
            list = newList;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf = buf.append("{");
        for (int i = 0 ; i < size - 1 ; i++) {
            buf = buf.append(list[i]).append(", ");
        }
        buf = buf.append(list[size - 1]);
        return buf.append("};").toString();
    }
    
    public int[] toArray() {
        int[] sizedList = new int[size];
        System.arraycopy(list, 0, sizedList, 0, size);
        return sizedList;
    }
}
