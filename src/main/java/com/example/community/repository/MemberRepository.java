package com.example.community.repository;

import org.apache.el.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.community.entitiy.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByMemberId(String memberId);

    Optional<Member> findByMemberId(String memberId);
}