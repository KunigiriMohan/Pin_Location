package com.application.pinlocation.repositoryimpl;

import com.application.pinlocation.exception.PinDetailsNotFoundException;
import com.application.pinlocation.model.Details;
import com.application.pinlocation.model.User;
import com.application.pinlocation.repository.DetailsRepositoryEM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class DetailsRepositoryImpl implements DetailsRepositoryEM {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public Details saveDetails(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    public Details getDetailsById(Long id) {
        try{
            String query = "select new com.application.pinlocation.model.Details(d.id,d.notes,d.latitude,d.longitude,d.address) from Details d where d.id=:id";
            Query query1 = entityManager.createQuery(query).setParameter("id",id);
            return (Details) query1.getSingleResult();
        }catch(Exception exception){
            System.out.println(exception);
            throw new PinDetailsNotFoundException("Pin Location with this id not found");
        }
    }

    @Override
    public void deleteDetailsByid(Long id) {
        try{
            String query = "delete from details where id=:id";
            Query query1 = entityManager.createNativeQuery(query).setParameter("id",id);
            query1.getFlushMode();
        }catch(Exception exception){
            System.out.println(exception);
            throw new PinDetailsNotFoundException("Pin Location with this id not found");
        }
    }
}
