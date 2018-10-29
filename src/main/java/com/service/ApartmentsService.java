package com.service;

import com.entity.Apartments;


public interface ApartmentsService {


    Apartments getAllApartments(int idHotel, int id);

    void delete(int hotelId, int id);

    void update(int hotelId, int id, String status);

    void create(int hotelId);
}
