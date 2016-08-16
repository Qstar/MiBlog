package com.qstar.miblog.core.dao;

import com.qstar.miblog.client.domain.User;
import com.qstar.miblog.core.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOTest extends TestBase {

    @Autowired
    private UserDAO dao;

    @Test
    public void testRegister() throws Exception {
        User user = new User();
        user.setEmail("zhujifang3@163.com");
        user.setNickname("fq");
        user.setPassword("123");
        long id = dao.register(user);
        System.out.println(id);
    }

    @Test
    public void testLogin() {
        System.out.println(dao.login("zhujifang666@13.com", "123"));
    }

    @Test
    public void getUser() {
//        dao.newUserList(50);
//        long userId = dao.getUserId("zhujifang666@163.com");
//        System.out.println(userId);
//
        User user = dao.getUser(1);
        System.out.println(user);
    }


}