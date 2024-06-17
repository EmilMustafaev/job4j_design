package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int[] counts = new int[nodes.size()];
        int currentIndex = 0;
        while (source.hasNext()) {
            Integer value = source.next();
            nodes.get(currentIndex).add(value);
            counts[currentIndex]++;
            currentIndex = (currentIndex + 1) % nodes.size();
        }
    }
}
