package ru.job4j.ood.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ParkingLotImplTest {

    @Test
    void whenCarSizeIsCorrect() {
        Vehicle car = new Car();
        assertEquals(1, car.getSize());
    }

    @Test
    void whenTruckSizeIsCorrect() {
        Vehicle track = new Track(2);
        assertEquals(2, track.getSize());
    }

    @Test
    void whenParkCarThenTrue() {
        ParkingLot parkingLot = new ParkingLotImpl(1, 0);
        Vehicle car = new Car();
        assertTrue(parkingLot.park(car));
    }

    @Test
    void whenParkTrackThenTrue() {
        ParkingLot parkingLot = new ParkingLotImpl(0, 1);
        Vehicle track = new Track(3);
        assertTrue(parkingLot.park(track));
    }

    @Test
    void whenParkTrackForCarSpotThenTrue() {
        ParkingLot parkingLot = new ParkingLotImpl(3, 0);
        Vehicle track = new Track(3);
        assertTrue(parkingLot.park(track));
    }

    @Test
    void whenLeaveCarSuccessfully() {
        ParkingLot lot = new ParkingLotImpl(1, 0);
        Vehicle car = new Car();
        lot.park(car);
        lot.leave(car);
        assertTrue((((ParkingLotImpl) lot).getCarSpots().get(0)).isFree());
    }
}