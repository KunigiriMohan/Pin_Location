package com.application.pinlocation.model;

import com.application.pinlocation.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_list")
@Audited
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    public Collection<Details> detailsList;

    public User(UserDTO userDTO){
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.mobileNo = userDTO.getMobileNo();
        this.emailAddress = userDTO.getEmailAddress();
        this.city = userDTO.getCity();
        this.state = userDTO.getState();
        this.password = userDTO.getPassword();
    }

    public User(Long id, String firstName, String lastName, String mobileNo, String emailAddress, String city, String state, String password ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.emailAddress = emailAddress;
        this.city = city;
        this.state = state;
        this.password = password;
    }


    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
