package com.example.springDataJPA.repository;

import com.example.springDataJPA.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

    //derived query
    List<UserDetails> findByUserName(String user_name);

    //Custom JPQL Query
    @Query("Select u from UserDetails u left join u.userAddress a left join u.userProfession p where u.user_age =:age" )
    List<UserDetails> findUserByAge(@Param("age") String age);
}
