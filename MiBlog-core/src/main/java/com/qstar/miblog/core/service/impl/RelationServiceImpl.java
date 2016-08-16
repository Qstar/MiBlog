package com.qstar.miblog.core.service.impl;

import com.qstar.miblog.client.domain.User;
import com.qstar.miblog.client.service.RelationService;
import com.qstar.miblog.core.dao.RelationDAO;
import com.qstar.miblog.core.dao.UserDAO;
import com.qstar.miblog.client.domain.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationDAO rDAO;

    @Autowired
    private UserDAO uDAO;

    @Override
    public boolean follow(long from, long to) {
        return rDAO.follow(new Relation(from, to));
    }

    @Override
    public boolean unfollow(long from, long to) {
        return rDAO.unfollow(new Relation(from, to));
    }

    @Override
    public List<User> getFollowings(long id) {
        List<Long> ids = rDAO.getFollowings(id);
        return idToUser(ids);
    }

    @Override
    public List<User> getFollowers(long id) {
        List<Long> ids = rDAO.getFollowers(id);
        return idToUser(ids);
    }

    @Override
    public List<User> withFollowings(long... ids) {
        return idToUser(rDAO.withFollowings(ids));
    }

    private List<User> idToUser(List<Long> ids) {
        List<User> users = new ArrayList<>();
        for (Long id : ids) {
            users.add(uDAO.getUser(id));
        }
        return users;
    }
}
