package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query(value="Select * from user_entity WHERE user_name=?",nativeQuery = true)
    UserEntity getCurrentUser(String user_name);

}
