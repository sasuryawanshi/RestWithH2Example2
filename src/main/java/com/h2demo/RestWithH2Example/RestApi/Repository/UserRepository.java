package com.h2demo.RestWithH2Example.RestApi.Repository;


import com.h2demo.RestWithH2Example.RestApi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {
    User findByUserId(int id);
}
