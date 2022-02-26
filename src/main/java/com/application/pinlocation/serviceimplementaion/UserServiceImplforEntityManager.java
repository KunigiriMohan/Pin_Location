package com.application.pinlocation.serviceimplementaion;

import com.application.pinlocation.dto.UserDTO;
import com.application.pinlocation.exception.UserNotFoundException;
import com.application.pinlocation.model.Details;
import com.application.pinlocation.model.AuthRequest;
import com.application.pinlocation.model.User;
import com.application.pinlocation.repository.UserEntityManger;
import com.application.pinlocation.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImplforEntityManager implements com.application.pinlocation.service.UserServiceforEntityManager {

    @Autowired
    UserEntityManger userEntityManger;

    @Autowired
    JwtUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public List<User> getAllUser() {
        try {
            return userEntityManger.getAllUserDetails();
        }
        catch (Exception exception){
            throw new UserNotFoundException("User not registered");
        }
    }

    @Override
    public Object getUserbyId(Long id){
        try {
            return userEntityManger.getUserDetailsById(id);
        }
        catch (Exception exception){
            throw new UserNotFoundException("User not registered");
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
    @Override
    public Details saveDetails(Details details) {
        return userEntityManger.saveDetails(details);
    }
}
