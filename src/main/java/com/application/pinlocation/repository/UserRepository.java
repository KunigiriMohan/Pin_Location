package com.application.pinlocation.repository;

import com.application.pinlocation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select user from User user where user.emailAddress=:name or user.password=:pass")
    //@Query(value = "select * from user_list where email_address=:email and password=:password",nativeQuery = true)
    public User getUserDetails(@Param("name") String userName, @Param("pass") String passWord);

    @Query("select user from User user where user.mobileNo=:userMobile")
    public User getUserDetails(@Param("userMobile") String mobileNumber);

    @Query("select user from User user where user.emailAddress=:email")
    User findByUserName(@Param("email") String emailAddress);
}
