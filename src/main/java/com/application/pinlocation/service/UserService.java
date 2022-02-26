package com.application.pinlocation.service;

import com.application.pinlocation.dto.UserDTO;
import com.application.pinlocation.model.AuthRequest;
import com.application.pinlocation.model.User;

public interface UserService {
    User registerUser(UserDTO userDTO);
    String loginUser(AuthRequest authRequest);
    User getUserById(Long userId);
    User saveUpdatedUser(User user);


}
