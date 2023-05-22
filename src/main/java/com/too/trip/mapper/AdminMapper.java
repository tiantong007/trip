package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.too.trip.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 根据账号和密码查找用户
     * @param account 账号
     * @param password 密码
     * @return 查找到的用户实体
     */
    @Select("""
            select * from t_admin where account = #{account} and password = #{password}
            """)
    Admin isExistsByActAndPsd(@Param("account") String account, @Param("password") String password);
}
