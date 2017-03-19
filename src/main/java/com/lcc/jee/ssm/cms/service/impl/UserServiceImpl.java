package com.lcc.jee.ssm.cms.service.impl;

import com.lcc.jee.ssm.cms.dao.UserDao;
import com.lcc.jee.ssm.cms.model.User;
import com.lcc.jee.ssm.cms.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2017/3/19.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public List<User> getAllUsers() {
        return null;
    }

    public User getUserByUsername(String username) {
        return null;
    }

    public void addUser(User user) {

    }

    public List<User> getUsersByPage(int pageSize, int currentPage) {
        return null;
    }
}
