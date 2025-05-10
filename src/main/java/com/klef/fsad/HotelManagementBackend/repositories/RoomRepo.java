package com.klef.fsad.HotelManagementBackend.repositories;

import com.klef.fsad.HotelManagementBackend.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room,Long> {
    List<Room> findByRoomType(String roomType);
    List<Room> findByRoomNumber(String roomNumber);
    List<Room> findByBedType(String bedType);
    List<Room> findByPriceBetween(String minPrice, String maxPrice);
    List<Room> findByAvailability(String availability);
    List<Room> findByLocation(String location);
}
