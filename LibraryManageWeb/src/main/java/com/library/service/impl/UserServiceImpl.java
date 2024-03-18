package com.library.service.impl;

import com.library.dao.UserMapper;
import com.library.entity.User;
import com.library.service.UserService;
import com.library.utils.MybatisUtil;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(username, password);
            if (user == null) return false;
            session.setAttribute("user", user);
            return true;
        }
    }
}
