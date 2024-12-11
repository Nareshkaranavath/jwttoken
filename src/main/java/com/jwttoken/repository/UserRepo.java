package com.jwttoken.repository;

import com.jwttoken.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<CustomUser, Integer> {
    CustomUser findByUserName(String userName);
}
