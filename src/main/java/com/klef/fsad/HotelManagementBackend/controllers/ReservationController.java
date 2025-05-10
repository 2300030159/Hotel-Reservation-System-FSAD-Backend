package com.klef.fsad.HotelManagementBackend.controllers;

import com.klef.fsad.HotelManagementBackend.models.Reservation;
import com.klef.fsad.HotelManagementBackend.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*") // Optional: to allow access from different domains
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return "Reservation deleted successfully!";
    }

    @PutMapping("/update/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        return reservationService.updateReservation(id, reservationDetails);
    }

    @GetMapping("/customer")
    public List<Reservation> getReservationsByCustomerName(@RequestParam String customerName) {
        return reservationService.getReservationsByCustomerName(customerName);
    }

    @GetMapping("/room")
    public List<Reservation> getReservationsByRoomType(@RequestParam String roomType) {
        return reservationService.getReservationsByRoomType(roomType);
    }

    @GetMapping("/checkin")
    public List<Reservation> getReservationsByCheckInDate(@RequestParam String checkInDate) {
        return reservationService.getReservationsByCheckInDate(checkInDate);
    }

    @GetMapping("/checkout")
    public List<Reservation> getReservationsByCheckOutDate(@RequestParam String checkOutDate) {
        return reservationService.getReservationsByCheckOutDate(checkOutDate);
    }

    @GetMapping("/price")
    public List<Reservation> getReservationsByTotalPrice(@RequestParam String totalPrice) {
        return reservationService.getReservationsByTotalPrice(totalPrice);
    }

    @GetMapping("/daterange")
    public List<Reservation> getReservationsByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return reservationService.getReservationsByDateRange(startDate, endDate);
    }

    @GetMapping("/customer-room")
    public List<Reservation> getReservationsByCustomerNameAndRoomType(@RequestParam String customerName, @RequestParam String roomType) {
        return reservationService.getReservationsByCustomerNameAndRoomType(customerName, roomType);
    }
}
