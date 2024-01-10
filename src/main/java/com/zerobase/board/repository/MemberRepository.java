package com.zerobase.board.repository;

import com.zerobase.board.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    Member getOneByPhone(String phone);

    Member getOneByEmail(String email);
}
