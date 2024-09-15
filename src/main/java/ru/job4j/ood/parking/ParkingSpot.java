package ru.job4j.ood.parking;

/*
Интерфейс парковочного места
 */
public interface ParkingSpot {
    boolean isFree();
    boolean canFit(Vehicle vehicle);
    void park(Vehicle vehicle);
    void leave();
}
