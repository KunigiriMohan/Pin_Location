package com.application.pinlocation.repository;

import com.application.pinlocation.model.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DetailsRepository extends JpaRepository<Details,Long> {
    /*@Transactional
    @Modifying
    @Query("delete from Details details where details.userid=:userid")
    void deleteBooksByUserIDinCart(@Param("userid") Long iD);*/
}
