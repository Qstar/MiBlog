package com.qstar.miblog.core.service.impl;

import com.qstar.miblog.client.domain.MiBlog;
import com.qstar.miblog.client.service.MiBlogService;
import com.qstar.miblog.core.dao.MiBlogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MiBlogServiceImpl implements MiBlogService {

    @Autowired
    private MiBlogDAO miBlogDAO;

    @Override
    public long publish(long author, String content) {
        return miBlogDAO.publish(new MiBlog(author, content, null));
    }

    @Override
    public boolean unpublish(long uid, long id) {
        return miBlogDAO.unpublish(uid, id);
    }

    @Override
    public List<MiBlog> getMyBlog(long uid) {
        List<Long> ids = miBlogDAO.getMyBlog(uid);
        return idToBlog(ids);
    }

    @Override
    public List<MiBlog> getFollowingBlog(long uid) {
        List<Long> ids = miBlogDAO.getFollowingBlog(uid);
        return idToBlog(ids);
    }

    @Override
    public List<MiBlog> getBlogFlow(long uid) {
        List<Long> ids = miBlogDAO.getBlogFlow(uid);
        return idToBlog(ids);
    }

    private List<MiBlog> idToBlog(List<Long> ids) {
        List<MiBlog> blogs = new ArrayList<>();
        for (Long id : ids) {
            blogs.add(miBlogDAO.getBlog(id));
        }
        return blogs;
    }
}
