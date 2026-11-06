package org.example.stockinvestment.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.stockinvestment.entity.userDTO;

@Mapper
public interface loginMapper {
    userDTO findByUser(@Param("email")String email, @Param("password")String password);
}
