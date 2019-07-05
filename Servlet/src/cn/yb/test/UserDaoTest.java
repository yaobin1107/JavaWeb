package cn.yb.test;

import cn.yb.dao.impl.UserDaoImpl;
import cn.yb.model.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("yb");
        user.setPassword("123");
        UserDaoImpl userDao = new UserDaoImpl();
        User user1 = userDao.login(user);
        System.out.println(user1);
    }
}
