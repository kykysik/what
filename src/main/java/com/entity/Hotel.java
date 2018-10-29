package com.entity;

import java.util.List;

public class Hotel {

    private int hotelId;
    private List<Apartments> apartments;

    public Hotel(int hotelId, List<Apartments> apartments) {
        this.hotelId = hotelId;
        this.apartments = apartments;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public List<Apartments> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartments> apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", apartments=" + apartments +
                '}';
    }
}
