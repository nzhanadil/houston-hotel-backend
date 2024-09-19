package com.houstondev.HoustonHotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.houstondev.HoustonHotel.entity.Booking;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {

    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private String photoUrl;
    private String roomDescription;
    private List<BookingDTO> bookings;

}
