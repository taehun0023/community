package com.example.community.entitiy;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor 
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 8)
    private String memberId;

    @Column(nullable = false)
    private String memberPw;

    @Column(nullable = false, length = 4)
    private String memberName;

    @CreationTimestamp // DB에 INSERT 시 자동 시간 설정
    private LocalDateTime member_indate;
}