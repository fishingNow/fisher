package com.homework.mapper;

import com.homework.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


    User login(@Param("email") String email, @Param("password") String password);


}
