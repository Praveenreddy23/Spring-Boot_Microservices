package com.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private double rate;
    private String feedback;

    private Hotel hotel;

}
