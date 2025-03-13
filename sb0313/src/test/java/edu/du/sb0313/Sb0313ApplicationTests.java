package edu.du.sb0313;

import edu.du.sb0313.dao.UserDao;
import edu.du.sb0313.dto.Users;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sb0313ApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    void usersOutput() {
        for(Users user : userDao.getAllUsers()) {
            System.out.println(user);
        }
    }
    @Test
    void usersCount() {
        System.out.println(userDao.count());
    }
    @Test
    void users_테이블_입력() {
        Users users = new Users();
        users.setUsername("이순신");
        users.setPassword("123456");
        users.setEmail("lee@krea.com");
        userDao.addUser(users);
    }

    @Test
    void users_getUserByUsername() {
        System.out.println(userDao.getUserByUsername("김철수"));
    }

}
