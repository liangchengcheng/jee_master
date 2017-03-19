package com.lcc.jee.ssm.cms.service;

import com.lcc.jee.ssm.cms.model.User;

import java.util.List;

/**
 * Created by asus on 2017/3/19.
 */
public interface UserService {
    List<User> getAllUsers();

    User getUserByUsername(String username);

    void addUser(User user);

    List<User> getUsersByPage(int pageSize, int currentPage);
}
