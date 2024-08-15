package com.codegroup.challenge.member.adapter.out;

import com.codegroup.challenge.member.domain.Member;
import com.codegroup.challenge.member.domain.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberRepositoryJpa extends MemberRepository, JpaRepository<Member, UUID> {


}
