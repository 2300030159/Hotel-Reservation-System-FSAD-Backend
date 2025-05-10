package com.klef.fsad.HotelManagementBackend.services;

import com.klef.fsad.HotelManagementBackend.models.Payment;
import com.klef.fsad.HotelManagementBackend.repositories.PaymentRepo;
import com.klef.fsad.HotelManagementBackend.repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ReservationRepo reservationRepo;

    public Payment createPayment(Payment payment) {
        // You can add validations here if needed, like checking if reservation exists
        return paymentRepo.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepo.findById(id).orElse(null);
    }

    public void deletePayment(Long id) {
        paymentRepo.deleteById(id);
    }

    public Payment updatePayment(Long id, Payment paymentDetails) {
        Payment payment = paymentRepo.findById(id).orElse(null);
        if (payment != null) {
            payment.setAmount(paymentDetails.getAmount());
            payment.setPaymentDate(paymentDetails.getPaymentDate());
            payment.setPaymentMethod(paymentDetails.getPaymentMethod());
            payment.setStatus(paymentDetails.getStatus());
            payment.setReservationId(paymentDetails.getReservationId());
            return paymentRepo.save(payment);
        }
        return null;
    }

    public List<Payment> getPaymentsByReservationId(Long reservationId) {
        return paymentRepo.findByReservationId(reservationId);
    }

    public List<Payment> getPaymentsByStatus(String status) {
        return paymentRepo.findByStatus(status);
    }

    public List<Payment> getPaymentsByCustomerName(String customerName) {
        return paymentRepo.findByCustomerName(customerName);
    }

    public List<Payment> getPaymentsByPaymentMethod(String paymentMethod) {
        return paymentRepo.findByPaymentMethod(paymentMethod);
    }

    public List<Payment> getPaymentsByDateRange(String startDate, String endDate) {
        return paymentRepo.findByPaymentDateBetween(startDate, endDate);
    }
}
