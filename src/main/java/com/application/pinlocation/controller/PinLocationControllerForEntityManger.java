package com.application.pinlocation.controller;

import com.application.pinlocation.dto.ResponseDTO;
import com.application.pinlocation.dto.UserDTO;
import com.application.pinlocation.model.*;
import com.application.pinlocation.service.DetailsServiceEM;
import com.application.pinlocation.service.UserServiceforEntityManager;
import com.application.pinlocation.utility.MapUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class PinLocationControllerForEntityManger {

    @Autowired
    UserServiceforEntityManager userServiceforEntityManager;

    @Autowired
    DetailsServiceEM detailsService;

    @GetMapping("/getuserbyId")
    public ResponseEntity<ResponseDTO> getUserById(@RequestParam Long userId){
        Object user = userServiceforEntityManager.getUserbyId(userId);
        ResponseDTO responseDTO = new ResponseDTO("User Details ", user, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/getallusers")
    public ResponseEntity<ResponseDTO> getallUsers(){
        List<User> userList = userServiceforEntityManager.getAllUser();
        ResponseDTO responseDTO = new ResponseDTO("User Details ", userList, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/registeruser")
    public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody UserDTO userDTO){
        User user = userServiceforEntityManager.registerUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User registered successfully ", user, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/loginuser")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody AuthRequest authRequest){
        String token = userServiceforEntityManager.userLogin(authRequest);
        ResponseDTO responseDTO = new ResponseDTO("User login sucessfull ", token, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping(path = "/addnotetopinlocation" )
    public ResponseEntity<Object> addNotestoPinnedLocation(@RequestParam String address,@RequestParam String key,@RequestParam String notes,@RequestParam Long userId){
        PinLocationDetails pinLocationDetails = MapUtility.addNotes(address, key);
        Location location = pinLocationDetails.getResults().get(0).getGeometry().getLocation();
        Details details = new Details(notes,location.getLat(),location.getLng(), pinLocationDetails.getResults().get(0).getFormatted_address());
        Details details1=detailsService.saveDetails(details);
        User user = (User) userServiceforEntityManager.getUserbyId(userId);
        user.detailsList.add(details1);
        userServiceforEntityManager.updateUser(user);
        ResponseDTO responseDTO = new ResponseDTO("Location Pinned Successfully ",user, HttpStatus.OK);
        return new ResponseEntity<Object>(responseDTO,HttpStatus.OK);
    }

    @PutMapping(path = "/updatepinlocation" )
    public ResponseEntity<Object> updatePinnedLocationDetails(@RequestParam String notes,@RequestParam Long userId,@RequestParam Long detailsId){
        Details details = detailsService.getDetails(detailsId);
        details.setNotes(notes);
        Details details1=detailsService.saveDetails(details);
        User user = (User) userServiceforEntityManager.getUserbyId(userId);
        ResponseDTO responseDTO = new ResponseDTO("Details of Pinned Location Updated Successfully",details1, HttpStatus.OK);
        return new ResponseEntity<Object>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/deletepinlocation")
    public ResponseEntity<ResponseDTO> deletePinnedLocation(@RequestParam Long userId, @RequestParam Long detailsId){
        User user= (User) userServiceforEntityManager.getUserbyId(userId);
        user.getDetailsList().remove(detailsId);
        detailsService.deleteDetailsById(detailsId);
        ResponseDTO responseDTO = new ResponseDTO("Pinned Location Deleted Sucessfully","Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
