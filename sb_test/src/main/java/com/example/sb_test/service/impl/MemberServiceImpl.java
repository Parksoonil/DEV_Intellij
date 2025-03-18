package com.example.sb_test.service.impl;

import com.example.sb_test.dto.MemberDTO;
import com.example.sb_test.mapper.MemberMapper;
import com.example.sb_test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public List<MemberDTO> getAllMembers() {
        return memberMapper.getAllMembers();
    }

    @Override
    public MemberDTO getMemberById(Long id) {
        return memberMapper.getMemberById(id);
    }

    @Override
    public MemberDTO getMemberByName(String name) {
        return memberMapper.getMemberByName(name);
    }
}
