package com.klef.fsad.HotelManagementBackend.services;

import com.klef.fsad.HotelManagementBackend.models.Reservation;
import com.klef.fsad.HotelManagementBackend.repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if (reservation != null) {
            reservation.setCustomerName(reservationDetails.getCustomerName());
            reservation.setRoomType(reservationDetails.getRoomType());
            reservation.setCheckInDate(reservationDetails.getCheckInDate());
            reservation.setCheckOutDate(reservationDetails.getCheckOutDate());
            reservation.setTotalPrice(reservationDetails.getTotalPrice());
            return reservationRepository.save(reservation);
        }
        return null;
    }

    public List<Reservation> getReservationsByCustomerName(String customerName) {
        return reservationRepository.findByCustomerName(customerName);
    }

    public List<Reservation> getReservationsByRoomType(String roomType) {
        return reservationRepository.findByRoomType(roomType);
    }

    public List<Reservation> getReservationsByCheckInDate(String checkInDate) {
        return reservationRepository.findByCheckInDate(checkInDate);
    }

    public List<Reservation> getReservationsByCheckOutDate(String checkOutDate) {
        return reservationRepository.findByCheckOutDate(checkOutDate);
    }

    public List<Reservation> getReservationsByTotalPrice(String totalPrice) {
        return reservationRepository.findByTotalPrice(totalPrice);
    }

    public List<Reservation> getReservationsByDateRange(String startDate, String endDate) {
        return reservationRepository.findByCheckInDateBetween(startDate, endDate);
    }

    public List<Reservation> getReservationsByCustomerNameAndRoomType(String customerName, String roomType) {
        return reservationRepository.findByCustomerNameAndRoomType(customerName, roomType);
    }
}
