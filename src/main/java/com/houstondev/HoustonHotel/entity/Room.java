package com.houstondev.HoustonHotel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "@room_type")
    private String roomType;

    @Column(name = "@room_price")
    private BigDecimal roomPrice;

    @Column(name = "@room_photo_url")
    private String roomPhotoUrl;

    @Column(name = "@room_description")
    private String roomDescription;

    @Column(name = "@bookings")
    private List<Booking> bookings = new ArrayList<>();

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomType='" + roomType + '\'' +
                ", roomPrice=" + roomPrice +
                ", roomPhotoUrl='" + roomPhotoUrl + '\'' +
                ", roomDescription='" + roomDescription + '\'' +
                '}';
    }
}
