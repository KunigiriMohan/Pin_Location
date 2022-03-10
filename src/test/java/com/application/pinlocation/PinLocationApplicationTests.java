/*
package com.application.pinlocation;

import com.application.pinlocation.dto.UserDTO;
import com.application.pinlocation.model.AuthRequest;
import com.application.pinlocation.model.Details;
import com.application.pinlocation.model.User;
import com.application.pinlocation.repository.DetailsRepository;
import com.application.pinlocation.repository.UserRepository;
import com.application.pinlocation.service.UserService;
import com.application.pinlocation.serviceimplementaion.DetailsServiceImpl;
import com.application.pinlocation.serviceimplementaion.UserServiceImpl;
import com.application.pinlocation.utility.JwtUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PinLocationApplicationTests {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userService;

	@Mock
	JwtUtil jwtUtil;

	@InjectMocks
	DetailsServiceImpl detailsService;

	@Mock
	DetailsRepository detailsRepository;



	List<Details> detailsList = new ArrayList<>();
	Details details = new Details(1L,"First API",15.6319f,77.2759f,"Adoni, Andhra Pradesh, India");


	User user = new User(1L,"Mohan","Kunigiri","8555058332","kmohanr5@gmail.com","Adoni","Andhra Pradesh","Mohank5@",detailsList);

	//UserDTO userDTO = new UserDTO("Mohan","Kunigiri","8555058332","kmohanr5@gmail.com","Adoni","Andhra Pradesh","Mohank5@");

	AuthRequest authRequest = new AuthRequest("kmohanr5@gmail.com","kmohanr5@");
	@Test
	void contextLoads() {
	}

	@Test
	public void registerUser(){
		detailsList.add(details);
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		User user1 = userService.registerUser(userDTO);
		assertNotNull(user1);
	}

	*/
/*@Test
	public void loginUser(){
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn(user);
		Mockito.when(jwtUtil.generateToken(Mockito.anyString())).thenReturn("token");
		String token = userService.loginUser(authRequest);
		assertEquals("token",token);
	}*//*


	@Test
	public void getUserById(){
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
		User user1 = userService.getUserById(Mockito.anyLong());
		assertEquals(user,user1);
	}

	@Test
	public void saveUpdateUser(){
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn((user));
		User user1 = userService.saveUpdatedUser(user);
		assertEquals(user,user1);
	}

	@Test
	public void saveDetails(){
		Mockito.when(detailsRepository.save(Mockito.any(Details.class))).thenReturn(details);
		Details details1 = detailsService.saveDetails(details);
		assertEquals(details,details1);
	}

	@Test
	public void getDetailsById(){
		Mockito.when(detailsRepository.getById(Mockito.anyLong())).thenReturn((details));
		Details details1 = detailsService.getDetails(Mockito.anyLong());
		assertEquals(details,details1);
	}

	@Test
	public void deleteDetailsById(){
		Mockito.when(detailsRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(details));
		detailsService.deleteDetailsById(1L);
		verify(detailsRepository,times(1)).deleteById(1L);
	}

}
*/
