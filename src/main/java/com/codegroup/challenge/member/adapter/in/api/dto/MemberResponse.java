package com.codegroup.challenge.member.adapter.in.api.dto;

import java.util.Objects;
import java.util.UUID;

public class MemberResponse {

    private final UUID id;
    private final String name;

    public MemberResponse(MemberResponseBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static MemberResponseBuilder builder() {
        return new MemberResponseBuilder();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberResponse that = (MemberResponse) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MemberResponse{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

}
