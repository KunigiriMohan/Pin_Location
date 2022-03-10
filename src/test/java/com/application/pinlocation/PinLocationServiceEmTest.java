//package com.application.pinlocation;
//
//import com.application.pinlocation.dto.UserDTO;
//import com.application.pinlocation.model.AuthRequest;
//import com.application.pinlocation.model.Details;
//import com.application.pinlocation.model.User;
//import com.application.pinlocation.repository.DetailsRepositoryEM;
//import com.application.pinlocation.repository.UserEntityManger;
//import com.application.pinlocation.serviceimplementaion.DetailServiceImplEM;
//import com.application.pinlocation.serviceimplementaion.UserServiceImplEM;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//public class PinLocationServiceEmTest {
//
//    @Mock
//    DetailsRepositoryEM detailsRepositoryEM;
//
//    @Mock
//    UserEntityManger userEntityManger;
//
//    @InjectMocks
//    DetailServiceImplEM detailServiceImplEM;
//
//    @InjectMocks
//    UserServiceImplEM userServiceImplEM;
//
//
//    List<Details> detailsList = new ArrayList<>();
//    Details details = new Details(1L,"First API",15.6319f,77.2759f,"Adoni, Andhra Pradesh, India");
//
//
//    User user = new User(1L,"Mohan","Kunigiri","8555058332","kmohanr5@gmail.com","Adoni","Andhra Pradesh","Mohank5@",detailsList);
//
//    UserDTO userDTO = new UserDTO("Mohan","Kunigiri","8555058332","kmohanr5@gmail.com","Adoni","Andhra Pradesh","Mohank5@");
//
//    AuthRequest authRequest = new AuthRequest("kmohanr5@gmail.com","kmohanr5@");
//
//    @Test
//    public void registerUser(){
//        Mockito.when(userEntityManger.registerUser(Mockito.any(User.class))).thenReturn(user);
//        User user1 = userServiceImplEM.registerUser(userDTO);
//        assertEquals(user,user1);
//    }
//
//    @Test
//    public void getUserById(){
//        Mockito.when(userEntityManger.getUserDetailsById(Mockito.anyLong())).thenReturn(user);
//        User user1 = (User) userServiceImplEM.getUserbyId(Mockito.anyLong());
//        assertEquals(user,user1);
//    }
//
//    @Test
//    public void updateUser(){
//        Mockito.when(userEntityManger.updateUser(Mockito.any(User.class))).thenReturn(user);
//        User user1 = userServiceImplEM.updateUser(user);
//        assertEquals(user,user1);
//    }
//
//    @Test
//    public void saveDetails(){
//        Mockito.when(detailsRepositoryEM.saveDetails(Mockito.any(Details.class))).thenReturn(details);
//        Details details1 = detailServiceImplEM.saveDetails(details);
//        assertEquals(details,details1);
//    }
//
//    @Test
//    public void getDetailsById(){
//        Mockito.when(detailsRepositoryEM.getDetailsById(Mockito.anyLong())).thenReturn((details));
//        Details details1 = detailServiceImplEM.getDetails(Mockito.anyLong());
//        assertEquals(details,details1);
//    }
//
//    @Test
//    public void deleteDetailsById(){
//        detailServiceImplEM.deleteDetailsById(Mockito.anyLong());
//        verify(detailsRepositoryEM,times(1)).deleteDetailsByid(Mockito.anyLong());
//    }
//}
