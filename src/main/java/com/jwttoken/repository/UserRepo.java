package com.jwttoken.repository;

import com.jwttoken.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<UserDetails, Integer> {
    UserDetails findByUserName(String userName);
}
