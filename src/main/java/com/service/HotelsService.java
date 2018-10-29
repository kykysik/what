package com.service;

import com.entity.Hotel;

import java.util.List;

public interface HotelsService {

     Hotel getHotels(int id);

     List<Hotel> getHotels();

     void delete(int hotelId);

     void update(int hotelId, int newId);

     void create();

}
