package com.application.pinlocation.repository;


import com.application.pinlocation.model.Details;
import com.application.pinlocation.model.AuthRequest;
import com.application.pinlocation.model.User;

import java.util.List;

public interface UserEntityManger {
    List<User> getAllUserDetails();
    Object getUserDetailsById(Long id);
    User registerUser(User user);
    Details saveDetails(Details details);
    Object userLogin(AuthRequest authRequest);
    User updateUser(User user);

}
