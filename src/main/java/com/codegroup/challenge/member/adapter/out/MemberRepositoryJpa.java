package com.codegroup.challenge.member.adapter.out;

import com.codegroup.challenge.member.domain.Member;
import com.codegroup.challenge.member.domain.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepositoryJpa extends MemberRepository, JpaRepository<Member, UUID> {
}
