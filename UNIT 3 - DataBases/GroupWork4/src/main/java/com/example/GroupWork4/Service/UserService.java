package com.example.GroupWork4.Service;

import com.example.GroupWork4.model.Users;
import com.example.GroupWork4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    private final UserRepository usersRepository;

    public UserService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    // ---------- Register Users ------------
    /*public Integer registerUser(String userName, String firstName, String lastName, LocalDate birthdate) {
        return usersRepository.registerUser(userName, firstName, lastName, birthdate);
    }
*/


    public Integer registerUser(Users user){
        return usersRepository.registerUser(user.getUserName(), user.getFirstName(), user.getLastName(), user.getBirthdate());
    }
    // ---------- Update Users ---------------

    // ---------- Find All Users ---------
    public List<Users> findAllUser(){
        return usersRepository.findAll();
    }
}
