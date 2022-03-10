package com.application.pinlocation.serviceimplementaion;

import com.application.pinlocation.dto.UserDTO;
import com.application.pinlocation.exception.UserAlreadyPresent;
import com.application.pinlocation.exception.UserNotFoundException;
import com.application.pinlocation.model.AuthRequest;
import com.application.pinlocation.model.User;
import com.application.pinlocation.repository.UserRepository;
import com.application.pinlocation.service.UserService;
import com.application.pinlocation.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service("userimplementation")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public User registerUser(UserDTO userDTO) {
        User user = new User(userDTO);
       if(userRepository.findAll().size()==0){
           return userRepository.save(user);
       }
       else {
           User userDetails = userRepository.getUserDetails(user.getMobileNo());
           if (userDetails == null){
               return userRepository.save(user);
           }
           else {
               throw new UserAlreadyPresent("User already Registered Login with your Credentials.");
           }
       }
    }

    @Override
    public String loginUser(AuthRequest authRequest) {
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
    public User getUserById(Long userId) {
        try{
            return userRepository.findById(userId).get();
        }
        catch (Exception exception){
            throw new UserNotFoundException("User Not found");
        }
    }

    @Override
    public User saveUpdatedUser(User user) {
        return userRepository.save(user);
    }
}
