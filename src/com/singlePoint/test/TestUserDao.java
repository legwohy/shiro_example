package com.singlePoint.test;

import com.singlePoint.dao.UserDao;
import com.singlePoint.pojo.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 2018/4/20.
 */
public class TestUserDao {
    UserDao userDao = new UserDao();
    @Test public void test(){
        System.out.println(userDao.findMemberSessionByUserId(4));
       Assert.assertTrue(userDao.findMemberSessionByUserId(4) != null);
    }

}
