package com.hotelservice.service;

import com.hotelservice.entity.Hotel;
import com.hotelservice.exception.HotelNotFoundException;
import com.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        hotel.setHotelId(randomId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException("Hotel with given id not found!!"+id));
    }
}
