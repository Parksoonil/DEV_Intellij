package com.example.sb0320;

import com.example.sb0320.entity.MyUser;
import com.example.sb0320.repository.MyUserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb0320Application {

    private final MyUserRepository myUserRepository;

    public Sb0320Application(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Sb0320Application.class, args);
    }

    @PostConstruct
    public void init() {
        MyUser myUser = MyUser.builder()
                .email("admin1@example.com")
                .name("admin1")
                .build();
        myUserRepository.save(myUser);
        myUser = MyUser.builder()
                .email("admin2@example.com")
                .name("admin2")
                .build();
        myUserRepository.save(myUser);
        myUser = MyUser.builder()
                .email("admin3@example.com")
                .name("admin3")
                .build();
        myUserRepository.save(myUser);
    }
}
