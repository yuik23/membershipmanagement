package com.raisetech.membershipmanagement.dao;

import com.raisetech.membershipmanagement.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    @Select("SELECT * FROM members")
    List<Member> findAll();

    @Select("SELECT * FROM members WHERE school_name LIKE CONCAT('%',#{type},'%') AND grade=#{number}")
    List<Member> findByGrade(String type, Integer number);

    @Select("SELECT * FROM members WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Member> findByName(String name);

    @Select("SELECT * FROM members WHERE id = #{id}")
    Optional<Member> findById(int id);
}
