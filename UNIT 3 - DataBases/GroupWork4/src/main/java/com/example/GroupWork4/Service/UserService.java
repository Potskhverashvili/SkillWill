package com.example.GroupWork4.Service;

import com.example.GroupWork4.model.Users;
import com.example.GroupWork4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository usersRepository;

    public UserService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // ---------- Register Users ------------
    public void registerUser(Users user) {
        usersRepository.registerUser(
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate());
    }


    // ---------- Update Users ---------------
    public Users updateUser(Users user) {
        List<Users> users = usersRepository.findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("No Users Found");
        }
      return usersRepository.updateUser(
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate());
    }


    // ---------- Find All Users ---------
    public List<Users> findAllUser() {
        List<Users> users = usersRepository.findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("No Users Found");
        }
        return users;
    }
}
