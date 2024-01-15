package com.zerobase.board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Member {
    @Id
    private String email;
    private String password;
    private String name;
    private String phone;
    private LocalDateTime signUpDate;

}
