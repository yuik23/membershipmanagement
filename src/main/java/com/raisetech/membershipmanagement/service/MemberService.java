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

    public List<Member> findSameGradeMembers(String type, Integer number) {
        List<Member> sameGradeMembers = this.memberMapper.findByGrade(type, number);
        return sameGradeMembers;
    }

    public List<Member> findMembersByName(String name) {
        List<Member> members = this.memberMapper.findByName(name);
        return members;
    }

    public Member findMember(int id) {
        Optional<Member> member = this.memberMapper.findById(id);
        return member.orElseThrow(() -> new MemberNotFoundException("member not found"));
    }

}
