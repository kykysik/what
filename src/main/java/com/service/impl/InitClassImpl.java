package com.service.impl;

import com.entity.Apartments;
import com.entity.Hotel;
import com.service.InitClass;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitClassImpl implements InitClass {

    @Bean
    public List<Hotel> getHotels() {
        return hotels;
    }

    private List<Hotel> hotels = new ArrayList<Hotel>();
    private List<Apartments> apartments;

    @PostConstruct
    public void init() {

        for(int i = 1; i < 6; i++) {
            apartments = getApartments();
            Hotel hotel = new Hotel(i,apartments);

            for (Apartments apartment : apartments) {
                apartment.setHotelId(hotel.getHotelId());
            }
            hotels.add(hotel);
        }
    }

    @Bean
    public List<Apartments> getApartments() {
        List<Apartments> apartments = new ArrayList<Apartments>();
        String status[] = {"Single", "Standard", "Superior", "Triple", "Quad",
                "Single", "Single", "Studio", "Standard", "Single"};

        for(int i = 0; i < 10; i++) {
            apartments.add(new Apartments(i+1, status[i]));
        }
        return this.apartments = apartments;
    }
}
