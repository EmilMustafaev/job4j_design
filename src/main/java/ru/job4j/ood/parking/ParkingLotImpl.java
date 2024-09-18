package ru.job4j.ood.parking;

import java.util.List;
import java.util.ArrayList;

public class ParkingLotImpl implements ParkingLot {

    private List<ParkingSpot> carSpots;
    private List<ParkingSpot> truckSpots;

    public ParkingLotImpl(int numCarSpots, int numTruckSpots) {
        carSpots = new ArrayList<>(numCarSpots);
        truckSpots = new ArrayList<>(numTruckSpots);

        for (int i = 0; i < numCarSpots; i++) {
            carSpots.add(new CarSpot());
        }
        for (int i = 0; i < numTruckSpots; i++) {
            truckSpots.add(new TrackSpot());
        }
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean result = false;
        if (vehicle.getSize() == 1) {
            for (ParkingSpot spot : carSpots) {
                if (spot.isFree()) {
                    spot.park(vehicle);
                    result = true;
                    break;
                }
            }
        } else {
            for (ParkingSpot spot : truckSpots) {
                if (spot.isFree()) {
                    spot.park(vehicle);
                    result = true;
                    break;
                }
            }

            if (truckSpots.isEmpty()) {
                for (ParkingSpot spot : carSpots) {
                    if (spot.isFree()) {
                        spot.park(vehicle);
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public void leave(Vehicle vehicle) {
        if (vehicle.getSize() == 1) {
            for (ParkingSpot spot : carSpots) {
                if (!spot.isFree()) {
                    spot.leave();
                    return;
                }
            }
        } else {
            for (ParkingSpot spot : truckSpots) {
                if (!spot.isFree()) {
                    spot.leave();
                    return;
                }
            }
            for (ParkingSpot spot : carSpots) {
                if (!spot.isFree()) {
                    spot.leave();
                    return;
                }
            }
        }
    }

    public List<ParkingSpot> getCarSpots() {
        return carSpots;
    }

    public List<ParkingSpot> getTruckSpots() {
        return truckSpots;
    }
}
