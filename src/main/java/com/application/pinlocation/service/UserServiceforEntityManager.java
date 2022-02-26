package com.application.pinlocation.service;

import com.application.pinlocation.dto.UserDTO;
import com.application.pinlocation.model.Details;
import com.application.pinlocation.model.AuthRequest;
import com.application.pinlocation.model.User;

import java.util.List;

public interface UserServiceforEntityManager {
    List<User> getAllUser();
    Object getUserbyId(Long id);
    User registerUser(UserDTO userDTO);
    Details saveDetails(Details details);
    String  userLogin(AuthRequest authRequest);
    public User updateUser(User user);
}
