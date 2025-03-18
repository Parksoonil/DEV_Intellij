package com.example.sb_test.service;

import com.example.sb_test.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    List<MemberDTO> getAllMembers();
    MemberDTO getMemberById(Long id);
    MemberDTO getMemberByName(String name);
}
