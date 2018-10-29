package com.service.impl;

import com.entity.Apartments;
import com.entity.Hotel;
import com.service.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelsServiceImpl implements HotelsService {

    @Autowired
    private List<Hotel> hotels;
    @Autowired
    private List<Apartments> apartments;


    public Hotel getHotels(int id) {
       return hotels.get(id-1);
    }

    public List<Hotel> getHotels() {
       return hotels;
    }

    public void delete(int hotelId) {
        hotels.remove(hotelId-1);
    }

    public void update(int hotelId, int newId) {
        hotels.get(hotelId-1).setHotelId(newId);
    }

    public void create() {

        int i = getHotels().size()-1;

        Hotel hotel = new Hotel(hotels.get(i).getHotelId()+1, apartments);
        for (Apartments apartment : apartments) {
            apartment.setHotelId(hotel.getHotelId());
        }
        hotels.add(hotel);
    }

}
