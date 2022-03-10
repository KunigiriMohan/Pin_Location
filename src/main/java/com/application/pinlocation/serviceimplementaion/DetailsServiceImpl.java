package com.application.pinlocation.serviceimplementaion;

import com.application.pinlocation.exception.PinDetailsNotFoundException;
import com.application.pinlocation.model.Details;
import com.application.pinlocation.repository.DetailsRepository;
import com.application.pinlocation.repository.UserRepository;
import com.application.pinlocation.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    DetailsRepository detailsRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Details saveDetails(Details details) {
        return detailsRepository.save(details);
    }

    @Override
    public Details getDetails(Long addressID) {
        try{
            return detailsRepository.getById(addressID);
        }catch (Exception exception){
            throw new PinDetailsNotFoundException("Pin with this id Not Found");
        }
    }

    @Override
    @Transactional
    public void deleteDetailsById(Long id) {
        try{
            detailsRepository.deleteById(id);
        }catch (Exception exception){
            throw new PinDetailsNotFoundException("Pin with this id Not Found");
        }
    }

}
