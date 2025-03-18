package com.example.sb_test.mapper;


import com.example.sb_test.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDTO> getAllMembers();

    @Select("SELECT * FROM member where id=#{id}")
    MemberDTO getMemberById(Long id);

    @Select("SELECT * FROM member where name=#{name}")
    MemberDTO getMemberByName(String name);
}

