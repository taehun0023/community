package com.example.community.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.community.dto.MemberDto;
import com.example.community.entitiy.Member;
import com.example.community.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void save(MemberDto dto) {
        if (memberRepository.existsByMemberId(dto.getMemberId())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        String encodedPw = passwordEncoder.encode(dto.getMemberPw());
        Member member = dto.toEntity(encodedPw);

        memberRepository.save(member);
    }
}
