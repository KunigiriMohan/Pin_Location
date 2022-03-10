package com.application.pinlocation.serviceimplementaion;

import com.application.pinlocation.model.Details;
import com.application.pinlocation.repository.DetailsRepositoryEM;
import com.application.pinlocation.service.DetailsServiceEM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImplEM implements DetailsServiceEM {

    @Autowired
    DetailsRepositoryEM detailsRepositoryEM;

    @Override
    public Details saveDetails(Details details) {
        return detailsRepositoryEM.saveDetails(details);
    }

    @Override
    public Details getDetails(Long addressId) {
        return detailsRepositoryEM.getDetailsById(addressId);
    }

    @Override
    public void deleteDetailsById(Long id) {
        detailsRepositoryEM.deleteDetailsByid(id);
    }
}
