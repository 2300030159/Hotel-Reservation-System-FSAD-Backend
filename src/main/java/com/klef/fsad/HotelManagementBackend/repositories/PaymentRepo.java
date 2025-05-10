package com.klef.fsad.HotelManagementBackend.repositories;

import com.klef.fsad.HotelManagementBackend.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
    List<Payment> findByReservationId(Long reservationId);
    List<Payment> findByStatus(String status);
    List<Payment> findByCustomerName(String customerName);
    List<Payment> findByPaymentMethod(String paymentMethod);
    List<Payment> findByPaymentDateBetween(String startDate, String endDate);
}
