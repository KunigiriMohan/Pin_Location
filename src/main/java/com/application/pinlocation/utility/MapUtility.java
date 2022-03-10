package com.application.pinlocation.utility;

import com.application.pinlocation.model.PinLocationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

@Component
public class MapUtility {

    public  static PinLocationDetails addNotes(String address, String key){
        //https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=YOUR_API_KEY
        PinLocationDetails data = new RestTemplate().getForObject("https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key="+key, PinLocationDetails.class);
        return data;
    }
}
