package com.service.impl;

import com.entity.Apartments;
import com.entity.Hotel;
import com.service.ApartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentsServiceImpl implements ApartmentsService {

    @Autowired
    private List<Apartments> apartments;

    @Autowired
    private List<Hotel> hotels;


    public List<Apartments> getAllApartments() {
        return apartments;
    }

    public Apartments getAllApartments(int idHotel, int id) {
        return hotels.get(idHotel-1).getApartments().get(id-1);
    }

    public void delete(int hotelId, int id) {
        hotels.get(hotelId-1).getApartments().remove(id-1);
    }

    public void update(int hotelId, int id, String status) {
        hotels.get(hotelId-1).getApartments().get(id-1).setStatus(status);
    }

    public void create(int hotelId) {

        Apartments app = new Apartments(apartments.size()+1, "post");
        app.setHotelId(hotelId);
        hotels.get(hotelId-1).getApartments().add(app);
        hotels.get(hotelId-1).setApartments(hotels.get(hotelId-1).getApartments());
    }
}
