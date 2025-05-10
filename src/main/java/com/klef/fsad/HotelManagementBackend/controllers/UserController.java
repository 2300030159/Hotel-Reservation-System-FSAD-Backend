package com.klef.fsad.HotelManagementBackend.controllers;
import java.util.*;
import com.klef.fsad.HotelManagementBackend.models.User;
import com.klef.fsad.HotelManagementBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    // Add your endpoints here
    // For example:
     @GetMapping("/all")
     public List<User> getAllUsers() {
         return userService.getAllUsers();
     }
     @PostMapping("/add")
     public User addUser(@RequestBody User user) {
         return userService.saveUser(user);
     }
     @PutMapping("/update")
     public User updateUser(@RequestBody User user) {
            // Assuming the user object contains the ID of the user to be updated
            // You might want to check if the user exists before updating
         System.out.println("Updating user: " + user);
            User existingUser = userService.getUserByEmail(user.getEmail());
            if (existingUser == null) {
                throw new RuntimeException("User not found");
            }
            // Update the user details
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setRole(user.getRole());
            // Save the updated user

         return userService.updateUser(existingUser);
     }
     @DeleteMapping("/delete/{id}")
     public void deleteUser(@PathVariable Long id) {
         userService.deleteUser(id);
     }
     @GetMapping("/find/{id}")
     public User getUserById(@PathVariable Long id) {
         return userService.getUserById(id);
     }
     @GetMapping("/find/email/{email}")
     public User getUserByEmail(@PathVariable String email) {
         return userService.getUserByEmail(email);
     }
     @GetMapping("/find/phone/{phone}")
     public User getUserByPhone(@PathVariable String phone) {
         return userService.getUserByPhone(phone);
     }

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        return userService.login(email, password);
    }

}
