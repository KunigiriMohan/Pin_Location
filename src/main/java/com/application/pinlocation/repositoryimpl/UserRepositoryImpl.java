package com.application.pinlocation.repositoryimpl;

import com.application.pinlocation.exception.UserAlreadyPresent;
import com.application.pinlocation.model.Details;
import com.application.pinlocation.model.AuthRequest;
import com.application.pinlocation.model.User;
import com.application.pinlocation.repository.UserEntityManger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;

@Repository
public class UserRepositoryImpl implements UserEntityManger {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Object getUserDetailsById(Long userid) {
        /*String query = "select new com.application.pinlocation.model.User(u.id,u.firstName,u.lastName,u.mobileNo,u.emailAddress,u.city,u.state,u.password,u.detailsList) from User u, Details d  where u.id=:userid";
        Query query1 = entityManager.createQuery(query).setParameter("userid",userid);*/
        String query = "select u from User u where u.id=:userid";
        Query query1 = entityManager.createQuery(query).setParameter("userid",userid);
        return query1.getSingleResult();
    }

    @Override
    @Transactional
    public User registerUser(User user) {
        Object userObject = null;
        try{
            String query = "select new com.application.pinlocation.model.User(u.id,u.firstName,u.lastName,u.mobileNo,u.emailAddress,u.city,u.state,u.password) from User u  where u.emailAddress=:email or u.mobileNo=:mobileNumber";
            Query query1 = entityManager.createQuery(query).setParameter("email",user.getEmailAddress()).setParameter("mobileNumber",user.getMobileNo());
            userObject = query1.getSingleResult();
        }
        catch(Exception exception){

        }finally {
            if(userObject == null){
                entityManager.persist(user);
                return user;
            }
            else{
                throw new UserAlreadyPresent("User Already present registered with another email or mobile number");
            }
        }
    }

    @Override
    public Details saveDetails(Details details) {
        entityManager.persist(details);
        return details;
    }

    /*@Override
    public Object userLogin(AuthRequest authRequest) {
        String query =" select user from user_list where email_address=:email and password=:password";
        Query query1 = entityManager.createNativeQuery(query,User.class).setParameter("email", authRequest.getEmail()).setParameter("password", authRequest.getPassword());
        Object user = query1.getSingleResult();
        return user;
    }*/

    @Override
    @Transactional
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getUserByEmail(String email) {
        String query = "select new com.application.pinlocation.model.User(u.id,u.firstName,u.lastName,u.mobileNo,u.emailAddress,u.city,u.state,u.password) from User u where u.emailAddress=:email";
        Query query1 = entityManager.createQuery(query).setParameter("email",email);
        return (User) query1.getSingleResult();
    }
}
