package com.qstar.miblog.core.service.impl;

import com.qstar.miblog.client.service.UserService;
import com.qstar.miblog.core.dao.UserDAO;
import com.qstar.miblog.client.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    @Override
    public long register(String email, String nickname, String password) {
        return dao.register(new User(null, email, nickname, password, null));
    }

    @Override
    public boolean login(String email, String password) {
        return dao.login(email, password);
    }

    @Override
    public List<User> newUserList(int limit) {
        List<Long> ids = dao.newUserList(limit);
        List<User> users = new ArrayList<>(ids.size());
        for (Long id : ids) {
            users.add(dao.getUser(id));
        }
        return users;
    }
}
