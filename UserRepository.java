package com.gl.mobileRechargeApplication.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.mobileRechargeApplication.bean.MyUsers;

@Repository
public interface UserRepository extends JpaRepository<MyUsers, String> {
Optional<MyUsers> findUserByUserName(String username);
}
