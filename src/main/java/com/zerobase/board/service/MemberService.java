package com.zerobase.board.service;

import com.zerobase.board.domain.Member;
import com.zerobase.board.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//회원가입
    public void createMember(String email, String password, String name, String phone){
        Member member = new Member();
        LocalDateTime now = LocalDateTime.now();
        now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        member.setEmail(email);
        member.setPassword(password);
        member.setName(name);
        member.setPhone(phone);
        member.setSignUpDate(now);
        memberRepository.save(member);
    }
//이메일 찾기
    public String findEmail(String name, String phone){
        Member member = memberRepository.getOneByPhone(phone);
        if(member.getName().equals(name) && member.getPhone().equals(phone)){
            return memberRepository.getOneByPhone(phone).getEmail();
        } else {
            return "Wrong information!";
        }
    }
//비밀번호 변경
    public void changePassword(String name, String email, String phone, String password){
        Member member = memberRepository.getOneByEmail(email);

        if(member.getName().equals(name) && member.getEmail().equals(email) && member.getPhone().equals(phone)){
            member.setPassword(password);
            memberRepository.save(member);
            System.out.println("Password changed!");
        } else {
            System.out.println("Wrong information!");
        }
    }
//휴대폰 번호 변경
    public void changePhone(String name, String email, String phone, String password){
        Member member = memberRepository.getOneByEmail(email);

        if(member.getName().equals(name) && member.getEmail().equals(email) && member.getPhone().equals(password)){
            member.setPassword(phone);
            memberRepository.save(member);
            System.out.println("Phonenumber changed!");
        } else {
            System.out.println("Wrong information!");
        }
    }
//회원 삭제
    public void deleteMember(String email, String password){
        Member member = memberRepository.getOneByEmail(email);

        if(member.getEmail().equals(email) && member.getPassword().equals(password)){
            memberRepository.deleteByEmail(email);
        } else {
            System.out.println("Failed to delete!");
        }
    }
}