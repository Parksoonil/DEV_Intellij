package com.example.sb0320;

import com.example.sb0320.entity.MyUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sb0320ApplicationTests {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Test
    void contextLoads() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        MyUser myUser = MyUser.builder()
                .name("홍길동")
                .email("hong@korea.com")
                .build();
        em.persist(myUser);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    void contextRead() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        MyUser myUser = em.find(MyUser.class, 1L);
        System.out.println(myUser);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    void contextUpdate() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        MyUser myUser = MyUser.builder()
                .id(1L)
                .name("홍길동")
                .email("hong@korea.com")
                .build();
        em.merge(myUser);
        em.getTransaction().commit();
        em.close();
    }
}
