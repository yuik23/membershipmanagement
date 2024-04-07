package com.raisetech.membershipmanagement.controller;

import com.raisetech.membershipmanagement.entity.Member;
import com.raisetech.membershipmanagement.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        List<Member> allMembers = memberService.findAll();
        return allMembers;
    }

    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable("id") int id) {
        return memberService.findMember(id);
    }

    @GetMapping("/members/{type}/{number}")
    public List<Member> getSameGradeMember(@PathVariable("type") String type, @PathVariable("number") int number) {
        return memberService.findSameGradeMember(type, number);
    }

    @GetMapping("/ids")
    public List<Integer> getIds(@RequestParam String name) {
        List<Integer> ids = memberService.findId(name);
        return ids;
    }
}
