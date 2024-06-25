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
        int hash = hash(Objects.hashCode(key));
        int index = indexFor(hash);
        if (count >= capacity * LOAD_FACTOR) {
            expand();
            index = indexFor(hash);
        }
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
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                K key = entry.key;
                int newIndex = indexFor(hash(Objects.hashCode(key)));
                newTable[newIndex] = entry;
            }
        }

        table = newTable;
    }

    @Override
    public V get(K key) {
        V result = null;
        int hash = Objects.hashCode(key);
        int index = indexFor(hash);

        MapEntry<K, V> entry = table[index];
        if (entry != null && Objects.equals(entry.key, key)) {
            result = entry.value;
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int hash = Objects.hashCode(key);
        int index = indexFor(hash);

        MapEntry<K, V> entry = table[index];
        if (entry != null && Objects.equals(entry.key, key)) {
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
            findNextValidSlot();
        }

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return currentIndex < table.length;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            K key = table[currentSlotIndex].key;
            findNextValidSlot();

            return key;
        }

        private void findNextValidSlot() {
            currentIndex++;
            while (currentIndex < table.length) {
                if (table[currentIndex] != null && table[currentIndex].key != null) {
                    currentSlotIndex = currentIndex;
                    return;
                } else if (table[currentIndex] != null && table[currentIndex].key == null && table[currentIndex].value != null) {
                    currentSlotIndex = currentIndex;
                    return;
                }
                currentIndex++;
            }
            expectedModCount = modCount;
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
