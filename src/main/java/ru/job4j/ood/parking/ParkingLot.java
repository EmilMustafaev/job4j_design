package ru.job4j.ood.parking;

/*
Интерфейс парковки
 */
public interface ParkingLot {
    boolean park(Vehicle vehicle);
    void leave(Vehicle vehicle);
}
