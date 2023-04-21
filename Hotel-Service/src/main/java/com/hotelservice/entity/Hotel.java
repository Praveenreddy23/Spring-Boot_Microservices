package com.hotelservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel_tbl")
public class Hotel {
    @Id
    private String hotelId;
    private String hotelName;
    private String hotelLocation;


}
