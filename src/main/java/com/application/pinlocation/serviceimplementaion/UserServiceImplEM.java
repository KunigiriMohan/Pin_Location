package com.application.pinlocation.serviceimplementaion;

import com.application.pinlocation.dto.UserDTO;
import com.application.pinlocation.exception.UserNotFoundException;
import com.application.pinlocation.model.AuthRequest;
import com.application.pinlocation.model.User;
import com.application.pinlocation.repository.UserEntityManger;
import com.application.pinlocation.service.UserServiceEM;
import com.application.pinlocation.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImplEM implements UserServiceEM {

    @Autowired
    UserEntityManger userEntityManger;

    @Autowired
    JwtUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public Object getUserbyId(Long id){
        try {
            return userEntityManger.getUserDetailsById(id);
        }
        catch (Exception exception){
            System.out.println(exception);
            throw new UserNotFoundException("User with this id not Found");
        }
    }

    @Override
    public User registerUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return userEntityManger.registerUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userEntityManger.updateUser(user);
    }

    @Override
    public String userLogin(AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new UserNotFoundException("inavalid username/password");
        }
        return jwtTokenUtil.generateToken(authRequest.getEmail());
    }

}
