package com.raisetech.membershipmanagement.service;

import com.raisetech.membershipmanagement.dao.MemberMapper;
import com.raisetech.membershipmanagement.entity.Member;
import com.raisetech.membershipmanagement.exception.MemberNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<Member> findAll() {
        List<Member> allMembers = this.memberMapper.findAll();
        return allMembers;
    }

    public Member findMember(int id) {
        Optional<Member> member = this.memberMapper.findById(id);
        return member.orElseThrow(() -> new MemberNotFoundException("member not found"));
    }

    public List<Member> findSameGradeMember(String type, int number) {
        List<Member> sameGradeMembers = this.memberMapper.findByGrade(type, number);
        return sameGradeMembers;
    }

    public List<Integer> findId(String name) {
        List<Integer> ids = this.memberMapper.findByName(name);
        return ids;
    }
}
