package ru.job4j.ood.parking;

public class TrackSpot implements ParkingSpot {

    private boolean free = true;
    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        return false;
    }

    @Override
    public void park(Vehicle vehicle) {

    }

    @Override
    public void leave() {

    }
}
