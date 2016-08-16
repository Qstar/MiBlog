package com.qstar.miblog.client.service;

import com.qstar.miblog.client.domain.User;

import java.util.List;

public interface RelationService {

    boolean follow(long from, long to);

    boolean unfollow(long from, long to);

    List<User> getFollowings(long id);

    List<User> getFollowers(long id);

    List<User> withFollowings(long... ids);
}
