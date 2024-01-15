package com.zerobase.board.controller;

import com.zerobase.board.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
//회원가입
    @PostMapping("/create/member")
    void createMember(HttpServletRequest request){
        memberService.createMember(request.getParameter("email"),request.getParameter("password"),request.getParameter("name"), request.getParameter("phone"));
    }
//핸드폰 번호로 이메일 찾기
    @GetMapping("/find/email")
    String findEmail(HttpServletRequest request){
        return memberService.findEmail(request.getParameter("name"), request.getParameter("phone"));
    }
// 비밀번호 변경
    @PutMapping("/change/password")
    void changePassword(HttpServletRequest request){
        memberService.changePassword(request.getParameter("name"), request.getParameter("email"), request.getParameter("phone"), request.getParameter("password"));

    }
//핸드폰번호 변경
    @PutMapping("/change/phone")
    void changePhone(HttpServletRequest request){
        memberService.changePassword(request.getParameter("name"), request.getParameter("email"), request.getParameter("phone"), request.getParameter("password"));
    }
// 회원 삭제
    @DeleteMapping("/delete/member")
    void deleteMember(HttpServletRequest request){
        memberService.deleteMember(request.getParameter("email"), request.getParameter("password"));
    }
}
