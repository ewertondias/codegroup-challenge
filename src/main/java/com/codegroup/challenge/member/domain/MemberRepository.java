package com.codegroup.challenge.member.domain;

import com.codegroup.challenge.member.domain.enums.MemberPositionEnum;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberRepository {

    Member save(Member member);

    List<Member> findAll();

    Optional<Member> findById(UUID id);

    List<Member> findAllByPosition(MemberPositionEnum position);

    <S extends Member> List<S> saveAll(Iterable<S> entities);

}
