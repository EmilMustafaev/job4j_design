package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int index = getIndexForKey(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            result = true;
        }

        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private int getIndexForKey(K key) {
        int hash = Objects.hashCode(key);
        return indexFor(hash);
    }

    private boolean equalsForKey(K keyOne, K keyTwo) {
        return Objects.hashCode(keyOne) == Objects.hashCode(keyTwo)
                && Objects.equals(keyOne, keyTwo);
    }


    private void expand() {
        capacity = capacity * 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int newIndex = getIndexForKey(entry.key);
                newTable[newIndex] = entry;
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        V result = null;
        int index = getIndexForKey(key);

        MapEntry<K, V> entry = table[index];
        if (entry != null && equalsForKey(key, entry.key)) {
            result = entry.value;
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = getIndexForKey(key);

        MapEntry<K, V> entry = table[index];
        if (entry != null && equalsForKey(key, entry.key)) {
            table[index] = null;
            modCount++;
            count--;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new NonCollisionMapIterator();
    }

    private class NonCollisionMapIterator implements Iterator<K> {

        private int currentIndex = -1;
        private int currentSlotIndex = -1;
        private int expectedModCount = modCount;

        public NonCollisionMapIterator() {
        }

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            boolean result = false;
            int tempIndex = currentIndex + 1;
            while (tempIndex < table.length) {
                if (table[tempIndex] != null
                        && (table[tempIndex].key != null
                        || table[tempIndex].value != null)) {
                    result = true;
                }
                tempIndex++;
            }
            return result;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            currentIndex++;
            while (currentIndex < table.length) {
                if (table[currentIndex] != null
                        && (table[currentIndex].key != null
                        || table[currentIndex].value != null)) {
                    currentSlotIndex = currentIndex;
                    break;
                }
                currentIndex++;
            }
            return table[currentSlotIndex].key;
        }
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

