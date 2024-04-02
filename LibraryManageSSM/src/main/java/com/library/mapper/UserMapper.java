package com.library.mapper;

import com.library.entity.Account;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where username = #{username}")
    public Account findUserByUsername(String username);

}
