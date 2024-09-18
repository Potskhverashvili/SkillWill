package com.example.GroupWork5.Service;

import com.example.GroupWork5.DTO.userDto.UserRequest;
import com.example.GroupWork5.DTO.userDto.UserResponse;
import com.example.GroupWork5.mappers.UserMapper;
import com.example.GroupWork5.model.UserEntity;
import com.example.GroupWork5.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ----------------- Create User ---------------
    public UserResponse createUser(UserRequest userRequest){
        UserEntity userEntity = UserMapper.mapRequestToEntity(userRequest);
        UserEntity save = userRepository.save(userEntity);
        return UserMapper.mapEntityToResponse(save);
    }

    // ----------------- View User -------------------
    public UserResponse viewUser(Long id){
        return UserMapper.mapEntityToResponse(findById(id));
    }

    // ----------------- Find by Id ------------------
    public UserEntity findById(Long id){
        Optional<UserEntity> byId = userRepository.findById(id);
        return byId.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"/user/view/ - User not found"));
    }
}
