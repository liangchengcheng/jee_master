package com.lcc.jee.ssm.cms.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.lcc.jee.ssm.cms.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by asus on 2017/3/19.
 */
@Repository("userDao")
public interface UserDao {

    public List<User> getAllUsers(PageBounds pageBounds);

    @Cacheable(value = "username", key = "#username")
    public User getUserByUsername(@Param("username") String username);

    public void addUser(User user);

}
