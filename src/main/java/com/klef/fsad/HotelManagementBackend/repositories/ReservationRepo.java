package com.klef.fsad.HotelManagementBackend.repositories;

import com.klef.fsad.HotelManagementBackend.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Long> {
    List<Reservation> findByCustomerName(String customerName);
    List<Reservation> findByRoomType(String roomType);
    List<Reservation> findByCheckInDate(String checkInDate);
    List<Reservation> findByCheckOutDate(String checkOutDate);
    List<Reservation> findByTotalPrice(String totalPrice);
    List<Reservation> findByCheckInDateBetween(String startDate, String endDate);
   List<Reservation> findByCustomerNameAndRoomType(String customerName, String roomType);
    List<Reservation> findByCustomerNameAndCheckInDate(String customerName, String checkInDate);
    List<Reservation> findByCustomerNameAndCheckOutDate(String customerName, String checkOutDate);
    List<Reservation> findByCustomerNameAndTotalPrice(String customerName, String totalPrice);
    List<Reservation> findByRoomTypeAndCheckInDate(String roomType, String checkInDate);
    List<Reservation> findByRoomTypeAndCheckOutDate(String roomType, String checkOutDate);
    List<Reservation> findByRoomTypeAndTotalPrice(String roomType, String totalPrice);
}
