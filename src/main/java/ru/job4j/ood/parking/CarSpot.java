package ru.job4j.ood.parking;

public class CarSpot implements ParkingSpot {

    private boolean free = true;
    private Vehicle parkedVehicle;
    @Override
    public boolean isFree() {
        return free;
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        return vehicle.getSize() == 1;
    }

    @Override
    public void park(Vehicle vehicle) {
        if (canFit(vehicle)) {
            this.parkedVehicle = vehicle;
            this.free = false;
        }
    }

    @Override
    public void leave() {
        this.parkedVehicle = null;
        this.free = true;
    }
}
