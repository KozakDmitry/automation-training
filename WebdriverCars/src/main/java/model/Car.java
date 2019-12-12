package model;

import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;

public class Car {
    private String PickUpPlace;
    private String DropOffPlace;
    private String pickUpDate;
    private String dropOffDate;

    public Car(String PickUpPlace,
                          String DropOffPlace,
                          String pickUpDate,
                          String dropOffDate) {
        this.PickUpPlace = PickUpPlace;
        this.DropOffPlace = DropOffPlace;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;

    }
    public Car() {
    }



    public Car setPickUpPlace(String placeFrom) {
        this.PickUpPlace = placeFrom;
        return this;
    }

    public String getPickUpPlace() {
        return PickUpPlace;
    }
    public String getDropOffPlace() {
        return DropOffPlace;
    }
    public String getpickUpDate() {
        return pickUpDate;
    }
    public String getdropOffDate() {
        return dropOffDate;
    }

    public Car setDropOffPlace(String DropOffPlace) {
        this.DropOffPlace = DropOffPlace;
        return this;
    }


    public Car setpickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
        return this;
    }

    public Car setdropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car that = (Car) o;
        return Objects.equals(PickUpPlace, that.PickUpPlace) &&
                Objects.equals(DropOffPlace, that.DropOffPlace) &&
                Objects.equals(pickUpDate, that.pickUpDate)&&
                Objects.equals(dropOffDate, that.dropOffDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PickUpPlace, DropOffPlace, pickUpDate, dropOffDate);
    }

    @Override
    public String toString() {
        return "HotelReservation{" +
                "placeFrom='" + PickUpPlace + '\'' +
                "placeTo='" + DropOffPlace + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }
}
