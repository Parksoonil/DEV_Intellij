package com.example.sb0324.repository;

import com.example.sb0324.entity.MyUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyUserRepository extends JpaRepository<MyUserEntity, Long> {
    @Query("select m from MyUserEntity m where m.name = :name")
    List<MyUserEntity> findByName2(@Param("name") String name);

    @Query(value = "select * from my_user where name = :name", nativeQuery = true)
    List<MyUserEntity> findByName3(@Param("name") String name);

}
