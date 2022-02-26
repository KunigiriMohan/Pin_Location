package com.application.pinlocation.repositoryimpl;

import com.application.pinlocation.exception.UserAlreadyPresent;
import com.application.pinlocation.model.Details;
import com.application.pinlocation.model.AuthRequest;
import com.application.pinlocation.model.User;
import com.application.pinlocation.repository.UserEntityManger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserEntityManger {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUserDetails() {
        String query = "select * from user_list";
        Query query1 = entityManager.createNativeQuery(query,User.class);
        return query1.getResultList();
    }

    @Override
    public Object getUserDetailsById(Long userid) {
        String query = "select * from user_list where id=:userid";
        Query query1 = entityManager.createNativeQuery(query,User.class).setParameter("userid",userid);
        return query1.getSingleResult();
    }

    @Override
    public User registerUser(User user) {
        Object email = null;
        try{
            String query = "select * from user_list where email_address=:email";
            Query query1 = entityManager.createNativeQuery(query,User.class).setParameter("email",user.getEmailAddress());
            email = query1.getSingleResult();
        }
        catch(Exception exception){

        }finally {
            if(email == null){
                entityManager.persist(user);
                return user;
            }
            else{
                throw new UserAlreadyPresent("User Already present registered with another email");
            }
        }
    }

    @Override
    public Details saveDetails(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    public Object userLogin(AuthRequest authRequest) {
        String query ="select user from user_list where email_address=:email and password=:password";
        Query query1 = entityManager.createNativeQuery(query,User.class).setParameter("email", authRequest.getEmail()).setParameter("password", authRequest.getPassword());
        Object user = query1.getSingleResult();
        return user;
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return entityManager.merge(user);
    }
}
