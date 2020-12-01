package com.zgx.mymap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K,V> implements MyMap<K,V>{
    private static int DEFAULT_CAPACITY = 16;

    private static float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size;

    private MyEntry[] myEntryTable = new MyEntry[DEFAULT_CAPACITY];

    @Override
    public V put(K key, V value) {
        if (size == DEFAULT_CAPACITY * DEFAULT_LOAD_FACTOR) {
            List<MyEntry<K, V>> entryList = new ArrayList<>();
            for (int i = 0; i < myEntryTable.length; i++) {
                reHash(entryList, myEntryTable[i]);
            }
            myEntryTable = new MyEntry[DEFAULT_CAPACITY * 2];
            DEFAULT_CAPACITY += DEFAULT_CAPACITY;
            entryList.forEach(entry -> put(entry.getKey(), entry.getValue()));
        }
        int index = getIndex(key);
        if (myEntryTable[index] != null) {
            size ++;
            return putRepeatHashCode(key, value, myEntryTable[index]);
        }
        size ++;
        myEntryTable[index] = getEntry(key, value, null);
        return (V) myEntryTable[index].getValue();
    }

    private void reHash(List<MyEntry<K, V>> entryList, MyEntry<K, V> myEntry) {
        if(myEntry == null) {
            return;
        }
        entryList.add(myEntry);
       if (myEntry.nextEntry != null) {
           reHash(entryList, myEntry.nextEntry);
       }
    }

    private V putRepeatHashCode(K key, V value, MyEntry myEntry) {
        MyEntry<K, V> kvMyEntry = new MyEntry<>(key, value, null);
        if (myEntry.nextEntry == null) {
            myEntry.nextEntry = kvMyEntry;
            return (V) myEntry.nextEntry.getValue();
        }
        return (V) putRepeatHashCode(key, value, myEntry.nextEntry);
        //return null;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (myEntryTable[index] == null) {
            return null;
        }
        return findValueByKey(key, myEntryTable[index]);
    }

    @Override
    public int size() {
        System.out.println(myEntryTable.length);
        System.out.println(DEFAULT_CAPACITY);
        return this.size;
    }

    private V findValueByKey(K key, MyEntry myEntry) {
        if (myEntry.getKey().equals(key)) {
            return (V)myEntry.getValue();
        } else {
            if (myEntry.nextEntry != null) {
                return (V) findValueByKey(key, myEntry.nextEntry);
            }
            return null;
        }
    }

    private int getIndex(K k) {
        int hashCode = k.hashCode();
        int index = hashCode % DEFAULT_CAPACITY;
        return index;
    }
    private MyEntry getEntry(K k, V v, MyEntry<K, V> nextEntry) {
        return new MyEntry(k, v, nextEntry);
    }

    class MyEntry<K,V> implements Entry<K,V>  {
        private K k;

        private V v;

        private MyEntry<K, V> nextEntry;

        public MyEntry(K k, V v, MyEntry<K, V> nextEntry){
            this.k = k;
            this. v = v;
            this.nextEntry = nextEntry;
        }

        @Override
        public K getKey() {
            return this.k;
        }

        @Override
        public V getValue() {
            return this.v;
        }
    }
}
