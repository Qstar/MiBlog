package com.qstar.miblog.client.service;

import com.qstar.miblog.client.domain.User;

import java.util.List;

public interface UserService {

    long register(String email, String nickname, String password);

    boolean login(String email, String password);

    List<User> newUserList(int limit);
}
