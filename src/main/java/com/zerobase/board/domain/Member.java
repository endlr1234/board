package com.zerobase.board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Member {
    @Id
    String email;
    String password;
    String name;
    String phone;
    LocalDateTime signUpDate;
}
