package com.application.pinlocation.model;

import com.application.pinlocation.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_list")
@Audited
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String mobileNo;

    private String emailAddress;

    private String city;

    private String state;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @Audited
    @JoinColumn(name = "userid",referencedColumnName = "id")
    public List<Details> detailsList;

    public User(UserDTO userDTO){
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.mobileNo = userDTO.getMobileNo();
        this.emailAddress = userDTO.getEmailAddress();
        this.city = userDTO.getCity();
        this.state = userDTO.getState();
        this.password = userDTO.getPassword();
    }
}
