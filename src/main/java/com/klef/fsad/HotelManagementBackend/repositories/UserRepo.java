package com.klef.fsad.HotelManagementBackend.repositories;

import com.klef.fsad.HotelManagementBackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User findByEmail(String email);
    User findByPhoneNumber(String phone);
    User findByUsername(String username);

}
