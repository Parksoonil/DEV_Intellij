package com.example.sb0320.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "myuser")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    private LocalDateTime createdAt;

    @PrePersist
    protected void prePersist() {createdAt = LocalDateTime.now();}
}
