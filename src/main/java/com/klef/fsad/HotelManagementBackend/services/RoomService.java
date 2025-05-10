package com.klef.fsad.HotelManagementBackend.services;
import java.util.List;
import com.klef.fsad.HotelManagementBackend.models.Room;
import com.klef.fsad.HotelManagementBackend.repositories.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepo roomRepo;

    public void addRoom(Room room) {
        roomRepo.save(room);
    }
    public void updateRoom(Room room) {
        if (room.getId() == null) {
            throw new IllegalArgumentException("Room ID cannot be null for update");
        }
        Room existingRoom = roomRepo.findById(room.getId()).orElseThrow(() -> new IllegalArgumentException("Room not found"));
        existingRoom.setRoomType(room.getRoomType());
        existingRoom.setRoomNumber(room.getRoomNumber());
        existingRoom.setBedType(room.getBedType());
        existingRoom.setPrice(room.getPrice());
        existingRoom.setAvailability(room.getAvailability());
        // Save the updated room
        roomRepo.save(existingRoom);
    }
    public void deleteRoom(Long id) {
        roomRepo.deleteById(id);
    }
    public Room getRoomById(Long id) {
        return roomRepo.findById(id).orElse(null);
    }
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }
    public List<Room> getAvailableRooms() {
        return roomRepo.findByAvailability("available");
    }
    public List<Room> getBookedRooms() {
        return roomRepo.findByAvailability("booked");
    }
    public List<Room> getRoomsByType(String roomType) {
        // Capitalize the first letter of roomType
        roomType = roomType.substring(0, 1).toUpperCase() + roomType.substring(1).toLowerCase();
        return roomRepo.findByRoomType(roomType);
    }
    public List<Room> getRoomsByPriceRange(String minPrice, String maxPrice) {
        return roomRepo.findByPriceBetween(minPrice, maxPrice);
    }
    public List<Room> getRoomsByBedType(String bedType) {
        return roomRepo.findByBedType(bedType);
    }
    public List<Room> getRoomsByAvailability(String availability) {
        return roomRepo.findByAvailability(availability);
    }
    public List<Room> getRoomsByRoomNumber(String roomNumber) {
        return roomRepo.findByRoomNumber(roomNumber);
    }

    public List<Room> getRoomsByLocation(String location) {
        return roomRepo.findByLocation(location);
    }
}
