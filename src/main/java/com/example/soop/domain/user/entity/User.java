package com.example.soop.domain.user.entity;

import com.example.soop.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String userID;

    @Column(nullable = false)
    private String userPW;

    @Builder
    public User(String name, String userID, String userPW) {
        this.name = name;
        this.userID = userID;
        this.userPW = userPW;
    }
}


