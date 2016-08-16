package com.qstar.miblog.core.dao;

import com.qstar.miblog.client.domain.MiBlog;
import com.qstar.miblog.core.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MiBlogDAOTest extends TestBase {

    @Autowired
    private MiBlogDAO dao;

    @Test
    public void testInsertPost() throws Exception {
        MiBlog blog = new MiBlog();
        blog.setAuthor(1L);
        blog.setContent("1号用户发布的第3条微博");
        dao.publish(blog);
    }

    @Test
    public void get() {
        List<Long> myBlog = dao.getBlogFlow(1);
        for (Long blog : myBlog) {
            MiBlog blog1 = dao.getBlog(blog);
            System.out.println(blog1);
        }
    }

    @Test
    public void del() {
        dao.unpublish(3, 3);
        dao.unpublish(3, 4);
        dao.unpublish(3, 4);
    }
}