package com.zerobase.board.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String text;
    private String tag;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
    private boolean authority;
    private int views;

    @ManyToOne
    @JoinColumn(name = "email")
    private Member member;
}
