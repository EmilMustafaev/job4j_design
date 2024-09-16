package ru.job4j.ood.parking;

public class Track implements Vehicle {
    private int size;

    public Track(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return 0;
    }

}
