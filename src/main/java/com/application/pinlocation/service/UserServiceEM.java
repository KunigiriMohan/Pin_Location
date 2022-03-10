package com.application.pinlocation.service;

import com.application.pinlocation.dto.UserDTO;
import com.application.pinlocation.model.AuthRequest;
import com.application.pinlocation.model.User;

public interface UserServiceEM {
    Object getUserbyId(Long id);
    User registerUser(UserDTO userDTO);
    String  userLogin(AuthRequest authRequest);
    User updateUser(User user);
}
