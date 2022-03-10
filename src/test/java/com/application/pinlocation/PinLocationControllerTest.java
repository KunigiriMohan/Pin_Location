/*
package com.application.pinlocation;

import com.application.pinlocation.controller.PinLocationController;
import com.application.pinlocation.dto.UserDTO;
import com.application.pinlocation.model.AuthRequest;
import com.application.pinlocation.model.Details;
import com.application.pinlocation.model.User;
import com.application.pinlocation.repository.UserRepository;
import org.json.JSONException;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PinLocationControllerTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    PinLocationController pinLocationController;



    List<Details> detailsList = new ArrayList<>();
    Details details = new Details(1L,"First API",15.6319f,77.2759f,"Adoni, Andhra Pradesh, India");


    User user = new User(4L,"Mohan","Kunigiri","8179800190","kmohanr9@gmail.com","Adoni","Andhra Pradesh","Kmohanr6@",null);

    //UserDTO userDTO = new UserDTO("Mohan","Kunigiri","8555058332","kmohanr5@gmail.com","Adoni","Andhra Pradesh","Mohank5@");

    AuthRequest authRequest = new AuthRequest("kmohanr5@gmail.com","kmohanr5@");


    @Order(1)
    @Test
    public void registerUser() throws JSONException {
        String result = "{\n" +
                "    \"message\": \"User Registered Successfully \",\n" +
                "    \"data\": {\n" +
                "        \"id\": 4,\n" +
                "        \"firstName\": \"Mohan\",\n" +
                "        \"lastName\": \"Kunigiri\",\n" +
                "        \"mobileNo\": \"8179800190\",\n" +
                "        \"emailAddress\": \"kmohanr9@gmail.com\",\n" +
                "        \"city\": \"Adoni\",\n" +
                "        \"state\": \"Andra Pradesh\",\n" +
                "        \"password\": \"Kmohanr6@\",\n" +
                "        \"detailsList\": null\n" +
                "    },\n" +
                "    \"httpStatus\": \"OK\"\n" +
                "}";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<User> request = new HttpEntity<User>(user,headers);
        */
/*HttpEntity<String> request = new HttpEntity<String>(result,headers);*//*

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/pinlocation/registeruser",request,String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        JSONAssert.assertEquals(result,response.getBody(),false);
    }
}
*/
