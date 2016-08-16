package com.qstar.miblog.core.dao;

import com.qstar.miblog.client.domain.Relation;

import java.util.List;

public interface RelationDAO {

    boolean follow(Relation relation);

    boolean unfollow(Relation relation);

    // 获取已关注的人列表
    List<Long> getFollowings(long id);

    // 获取关注我的人列表
    List<Long> getFollowers(long id);

    // 共同关注
    List<Long> withFollowings(long... ids);
}
