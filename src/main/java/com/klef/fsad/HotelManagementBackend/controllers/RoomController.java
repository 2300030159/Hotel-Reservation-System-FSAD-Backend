package com.klef.fsad.HotelManagementBackend.controllers;

import com.klef.fsad.HotelManagementBackend.models.Room;
import com.klef.fsad.HotelManagementBackend.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*") // optional: allow requests from different origins
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/add")
    public String addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
        return "Room added successfully!";
    }

    @PutMapping("/update")
    public String updateRoom(@RequestBody Room room) {
        roomService.updateRoom(room);
        return "Room updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return "Room deleted successfully!";
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @GetMapping("/all")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    @GetMapping("/booked")
    public List<Room> getBookedRooms() {
        return roomService.getBookedRooms();
    }

    @GetMapping("/type/{roomType}")
    public List<Room> getRoomsByType(@PathVariable String roomType) {
        return roomService.getRoomsByType(roomType);
    }

    @GetMapping("/price")
    public List<Room> getRoomsByPriceRange(@RequestParam String minPrice, @RequestParam String maxPrice) {
        return roomService.getRoomsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/bed/{bedType}")
    public List<Room> getRoomsByBedType(@PathVariable String bedType) {
        return roomService.getRoomsByBedType(bedType);
    }

    @GetMapping("/availability/{availability}")
    public List<Room> getRoomsByAvailability(@PathVariable String availability) {
        return roomService.getRoomsByAvailability(availability);
    }

    @GetMapping("/number/{roomNumber}")
    public List<Room> getRoomsByRoomNumber(@PathVariable String roomNumber) {
        return roomService.getRoomsByRoomNumber(roomNumber);
    }

    @GetMapping("/location/{location}")

    public List<Room> getRoomsByLocation(@PathVariable String location) {
        return roomService.getRoomsByLocation(location);
    }
}
