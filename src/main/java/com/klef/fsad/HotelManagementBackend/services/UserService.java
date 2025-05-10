package com.klef.fsad.HotelManagementBackend.services;

import com.klef.fsad.HotelManagementBackend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.fsad.HotelManagementBackend.models.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User findByPhone(String phone) {
        return userRepository.findByPhoneNumber(phone);
    }
    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserByPhone(String phone) {
        return userRepository.findByPhoneNumber(phone);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; // or throw an exception
    }
}
