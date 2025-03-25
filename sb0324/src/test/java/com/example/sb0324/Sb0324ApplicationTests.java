package com.example.sb0324;

import com.example.sb0324.entity.MyUserEntity;
import com.example.sb0324.repository.MyUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Sb0324ApplicationTests {

    @Autowired
    private MyUserRepository myUserRepository;

    @PersistenceUnit
    private EntityManagerFactory factory;

    @Test
    void test1() {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        MyUserEntity myUserEntity = MyUserEntity.builder()
                .name("홍길동").email("hong@korea.com").build();
        em.persist(myUserEntity);
        myUserEntity.setName("김길동");
        em.getTransaction().commit();
        em.close();
    }

    @Test
    void test2() {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        MyUserEntity myUser = em.find(MyUserEntity.class, 1L);
        System.out.println(myUser);
        myUser.setName("신길동");
        em.getTransaction().commit();
        em.close();
    }

    @Test
    void test3() {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
//        MyUserEntity myUser = em.find(MyUserEntity.class, 2L);
        MyUserEntity myUser = new MyUserEntity();
        myUser.setId(2L);
        myUser.setEmail("chul@korea.com");
        myUser.setName("홍길청");
        em.merge(myUser);

        em.getTransaction().commit();
        em.close();
    }

    @Test
    void test4() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<MyUserEntity> query = em.createQuery("select m from MyUserEntity m", MyUserEntity.class);
        List<MyUserEntity> list = query.getResultList();
        for (MyUserEntity myUserEntity : list) {
            System.out.println(myUserEntity);
        }
        em.close();
    }
    @Test
    void test5() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<MyUserEntity> query = em.createQuery("select m from MyUserEntity m where m.name = :name", MyUserEntity.class);
        query.setParameter("name", "신길동");
        List<MyUserEntity> list = query.getResultList();
        for (MyUserEntity myUserEntity : list) {
            System.out.println(myUserEntity);
        }
        em.close();
    }

    @Test
    void test6() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<MyUserEntity> query = em.createQuery("select m from MyUserEntity m where m.name like :name", MyUserEntity.class);
        query.setParameter("name", "%홍%");
        List<MyUserEntity> list = query.getResultList();
        for (MyUserEntity myUserEntity : list) {
            System.out.println(myUserEntity);
        }
        em.close();
    }

    @Test
    void test7() {
        List<MyUserEntity> list = myUserRepository.findByName("신길동");
        System.out.println(list);
    }
}
