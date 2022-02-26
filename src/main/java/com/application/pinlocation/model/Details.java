package com.application.pinlocation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "details")
@Audited
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String notes;

    public Float latitude;

    public Float longitude;

    public String address;

    /*@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User user;*/

    public Details(String notes, Float latitude , Float longitude,String address){
        this.notes = notes;
        this.latitude= latitude;
        this.longitude = longitude;
        this.address = address;

    }

}
