package com.hotelservice.exception;

public class HotelNotFoundException extends RuntimeException{
    public HotelNotFoundException(String message){
        super(message);
    }
    public HotelNotFoundException(){
        super("Hotel Not Available!!!");
    }
}
