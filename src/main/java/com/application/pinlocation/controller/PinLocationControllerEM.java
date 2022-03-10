package com.application.pinlocation.controller;

import com.application.pinlocation.dto.ResponseDTO;
import com.application.pinlocation.dto.UserDTO;
import com.application.pinlocation.model.*;
import com.application.pinlocation.service.DetailsServiceEM;
import com.application.pinlocation.service.UserServiceEM;
import com.application.pinlocation.utility.MapUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class PinLocationControllerEM {

    /**
     * Autowiring UserServiceforEntityManager for injecting dependent Object
     */
    @Autowired
    UserServiceEM userServiceEM;

    /**
     * Autowiring Detailssevice for injecting dependent Object
     */
    @Autowired
    DetailsServiceEM detailsService;


    /**
     * API to get user details by Id
     * @param userId
     * @return : ResponseEntity with User Details
     */
    @GetMapping("/getuserbyId")
    public ResponseEntity<ResponseDTO> getUserById(@RequestParam Long userId){
        Object user = userServiceEM.getUserbyId(userId);
        ResponseDTO responseDTO = new ResponseDTO("User Details ", user, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API to register User in Database
     * @param userDTO
     * @return : ResponseEntity of saved User Deatails
     */
    @PostMapping("/registeruser")
    public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody UserDTO userDTO){
        User user = userServiceEM.registerUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User registered successfully ", user, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API to Login and Generating Token
     * @param authRequest
     * @return : ResponseEntity of ResponseDTO with Token Generated
     */
    @PostMapping("/loginuser")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody AuthRequest authRequest){
        String token = userServiceEM.userLogin(authRequest);
        ResponseDTO responseDTO = new ResponseDTO("User login sucessfull ", token, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API to add Notes to Pinned Location
     * @param address
     * @param key
     * @param notes
     * @param userId
     * @return : ResponseEntity of Pinned Location Details along with user in which notes stored
     */
    @PostMapping(path = "/addnotetopinlocation" )
    public ResponseEntity<Object> addNotestoPinnedLocation(@RequestParam String address,@RequestParam String key,@RequestParam String notes,@RequestParam Long userId){
        PinLocationDetails pinLocationDetails = MapUtility.addNotes(address, key);
        Location location = pinLocationDetails.getResults().get(0).getGeometry().getLocation();
        Details details = new Details(notes,location.getLat(),location.getLng(), pinLocationDetails.getResults().get(0).getFormatted_address());
        Details details1=detailsService.saveDetails(details);
        User user = (User) userServiceEM.getUserbyId(userId);
        user.detailsList.add(details1);
        userServiceEM.updateUser(user);
        ResponseDTO responseDTO = new ResponseDTO("Location Pinned Successfully ",user, HttpStatus.OK);
        return new ResponseEntity<Object>(responseDTO,HttpStatus.OK);
    }

    /**
     * API to update Pinned Location Notes
     * @param notes
     * @param userId
     * @param detailsId
     * @return : updated Note on Pinned Location Details
     */
    @PutMapping(path = "/updatepinlocation" )
    public ResponseEntity<Object> updatePinnedLocationDetails(@RequestParam String notes,@RequestParam Long userId,@RequestParam Long detailsId){
        Details details = detailsService.getDetails(detailsId);
        details.setNotes(notes);
        Details details1=detailsService.saveDetails(details);
        User user = (User) userServiceEM.getUserbyId(userId);
        ResponseDTO responseDTO = new ResponseDTO("Details of Pinned Location Updated Successfully",details1, HttpStatus.OK);
        return new ResponseEntity<Object>(responseDTO,HttpStatus.OK);
    }

    /**
     * API to delete Pinned Location and Notes
     * @param userId
     * @param detailsId
     * @return : ResponseEntity with Deleted Succesfull message
     */
    @DeleteMapping("/deletepinlocation")
    public ResponseEntity<ResponseDTO> deletePinnedLocation(@RequestParam Long userId, @RequestParam Long detailsId){
        User user= (User) userServiceEM.getUserbyId(userId);
        user.getDetailsList().remove(detailsId);
        detailsService.deleteDetailsById(detailsId);
        ResponseDTO responseDTO = new ResponseDTO("Pinned Location Deleted Sucessfully","Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
