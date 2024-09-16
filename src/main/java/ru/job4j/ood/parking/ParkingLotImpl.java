package ru.job4j.ood.parking;

import java.util.List;
import java.util.ArrayList;

public class ParkingLotImpl implements ParkingLot {

    private List<ParkingSpot> carSpots;
    private List<ParkingSpot> truckSpots;

    public ParkingLotImpl(int numCarSpots, int numTruckSpots) {
        carSpots = new ArrayList<>(numCarSpots);
        truckSpots = new ArrayList<>(numTruckSpots);
    }

    @Override
    public boolean park(Vehicle vehicle) {
        return false;
    }

    @Override
    public void leave(Vehicle vehicle) {

    }

    public List<ParkingSpot> getCarSpots() {
        return carSpots;
    }

    public List<ParkingSpot> getTruckSpots() {
        return truckSpots;
    }
}
