//sb ques library management system
package com.example.sp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sp.Repos.UserRepository;
import com.example.sp.entity.User;
import exception.UserNotFoundException;  // Corrected import

@Service
public class UserService { 

    @Autowired
    private UserRepository userRepository;  

    public User updateUser(Long id, User user) {  
        try {
            return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        } catch (Exception e) {
            e.printStackTrace();  // Log the error
            throw e;  // Re-throw the exception for better debugging
        }
    }

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	

//	public User addUser(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
