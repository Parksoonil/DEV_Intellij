package com.example.sb0320.repository;

import com.example.sb0320.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByName(String name);
    List<MyUser> findMyUserByOrderByIdAsc();
}
