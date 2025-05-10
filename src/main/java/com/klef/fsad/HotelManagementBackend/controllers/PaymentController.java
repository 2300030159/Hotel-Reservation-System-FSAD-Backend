package com.klef.fsad.HotelManagementBackend.controllers;

import com.klef.fsad.HotelManagementBackend.models.Payment;
import com.klef.fsad.HotelManagementBackend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://hotel-reservation-system-fsad.vercel.app"
})
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create new payment
    @PostMapping("/add")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    // Get all payments
    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get payment by ID
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    // Delete payment by ID
    @DeleteMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Payment deleted successfully!";
    }

    // Update payment by ID
    @PutMapping("/update/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        return paymentService.updatePayment(id, payment);
    }

    // Get payments by reservation ID
    @GetMapping("/reservation/{reservationId}")
    public List<Payment> getPaymentsByReservationId(@PathVariable Long reservationId) {
        return paymentService.getPaymentsByReservationId(reservationId);
    }

    // Get payments by status (Paid / Pending / Failed)
    @GetMapping("/status/{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable String status) {
        return paymentService.getPaymentsByStatus(status);
    }

    // Get payments by customer name
    @GetMapping("/customer/{customerName}")
    public List<Payment> getPaymentsByCustomerName(@PathVariable String customerName) {
        return paymentService.getPaymentsByCustomerName(customerName);
    }

    // Get payments by payment method (Credit Card / UPI / Cash)
    @GetMapping("/method/{paymentMethod}")
    public List<Payment> getPaymentsByPaymentMethod(@PathVariable String paymentMethod) {
        return paymentService.getPaymentsByPaymentMethod(paymentMethod);
    }

    // Get payments by date range (startDate, endDate)
    @GetMapping("/dateRange")
    public List<Payment> getPaymentsByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return paymentService.getPaymentsByDateRange(startDate, endDate);
    }
}
