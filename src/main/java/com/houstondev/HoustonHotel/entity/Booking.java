package com.houstondev.HoustonHotel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "check in date is required")
    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Future(message = "check out date must be in the future")
    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @Min(value = 1, message = "Number of adults must not be less then 1")
    @Column(name = "num_of_adults")
    private int numOfAdults;

    @Min(value = 0, message = "Number of children must not be less then 0")
    @Column(name = "num_of_children")
    private int numOfChildren;

    private int totalNumOfGuests;

    @Column(name = "booking_confirmation_code")
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public void calculateTotalNumberOfGuests() {
        this.totalNumOfGuests = this.numOfAdults + this.numOfChildren;
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumberOfGuests();
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumberOfGuests();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numOfAdults=" + numOfAdults +
                ", numOfChildren=" + numOfChildren +
                ", totalNumOfGuests=" + totalNumOfGuests +
                ", bookingConfirmationCode='" + bookingConfirmationCode + '\'' +
                ", id=" + id +
                '}';
    }
}
