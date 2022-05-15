package com.shf.mymp.mapper;
import java.util.List;
import com.shf.mymp.enums.SexEnum;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shf.mymp.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据id查询用户信息为map的集合
     * @param id
     * @return
     */
    Map<String,Object> selectMapById(@Param("id") Long id);

    /**
     * 通过年龄查询用户信息并分页
     * @param page  Mybatis-plus提供的分页对象，必须位于第一个参数的位置
     * @param age
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page,@Param("age") Integer age);

    int insertSelective(User user);

    int deleteByIdAndName(@Param("id") Long id, @Param("name") String name);

    int updateAgeAndSexById(@Param("age") Integer age, @Param("sex") SexEnum sex, @Param("id") Long id);

    List<User> selectAgeAndSexByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

    List<User> selectAllOrderByAgeDesc();
}
