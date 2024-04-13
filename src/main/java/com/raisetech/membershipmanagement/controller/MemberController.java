package com.raisetech.membershipmanagement.controller;

import com.raisetech.membershipmanagement.entity.Member;
import com.raisetech.membershipmanagement.exception.BadRequestException;
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

    /* /members
    クエリパラメータの入力がない場合は全件取得
    type,numberどちらかの入力しかない場合BadRequestを返す処理
    type,number両方入力がある場合は学年検索で該当する会員情報を取得
    nameのみ入力がある場合は名前検索で該当する会員情報を取得
    その他の場合はBadRequestを返す処理
    */
    @GetMapping("/members")
    public List<Member> getMembers(@RequestParam(required = false) String name, String type, Integer number) {
        if (name == null) {
            if ((type == null) && (number == null)) {
                return memberService.findAll();
            } else if ((type == null) || (number == null)) {
                throw new BadRequestException("Requested value is invalid");
            } else {
                return memberService.findSameGradeMembers(type, number);
            }
        } else if ((type == null) && (number == null)) {
            return memberService.findMembersByName(name);
        } else {
            throw new BadRequestException("Requested value is invalid");
        }
    }

    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable("id") int id) {
        return memberService.findMember(id);
    }
}
