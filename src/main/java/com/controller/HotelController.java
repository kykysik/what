package com.controller;

import com.entity.Apartments;
import com.entity.Hotel;
import com.service.impl.ApartmentsServiceImpl;
import com.service.impl.HotelsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/hotels")
public class HotelController {

    @Autowired
    private HotelsServiceImpl hotelService;
    @Autowired
    private ApartmentsServiceImpl appService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Hotel> hotels() {
        return hotelService.getHotels();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteHotel(@PathVariable(value = "id") Integer id) {
        hotelService.delete(id);
    }

    @RequestMapping(value = "/{hotelId}/{id}", method = RequestMethod.DELETE)
    public void deleteApartments(@PathVariable(value = "id") Integer id,
                                 @PathVariable(value = "hotelId") Integer hotelId) {
        appService.delete(hotelId, id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void createHotel() {
        hotelService.create();
    }

    @RequestMapping(value = "/{hotelId}", method = RequestMethod.POST)
    public void createApartments(@PathVariable(value = "hotelId") Integer hotelId) {
        appService.create(hotelId);
    }

    @RequestMapping(value = "/{idHotel}/{newId}", method = RequestMethod.PUT)
    public void updateHotel(@PathVariable(value = "idHotel") Integer idHotel,
                            @PathVariable(value = "newId") Integer newId) {
        hotelService.update(idHotel, newId);
    }

    @RequestMapping(value = "/{hotelId}/{id}/{status}", method = RequestMethod.PUT)
    public void updateApartments(@PathVariable(value = "hotelId") Integer hotelId,
                                 @PathVariable(value = "id") Integer id,
                                 @PathVariable(value = "status") String  status) {
        appService.update(hotelId, id, status);
    }

    @RequestMapping(value = "/{idHotel}/{id}", method = RequestMethod.GET)
    public Apartments apartments(@PathVariable(value = "idHotel") Integer idHotel,
                                 @PathVariable(value = "id") Integer id) {
        return appService.getAllApartments(idHotel,id);
    }

    @RequestMapping(value = "/apartments", method = RequestMethod.GET)
    public List<Apartments> apartments() {
        return appService.getAllApartments();
    }
}
