package com.codegroup.challenge.member.adapter.in.api;

import com.codegroup.challenge.member.util.MemberTestFactory;
import com.codegroup.challenge.util.CreateServicesIT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.codegroup.challenge.member.util.MemberTestFactory.memberRequest;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes for Member - Add Member Api")
class MemberRestControllerTest extends CreateServicesIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Must add members")
    void mustAddMembers() throws Exception {
        var request = List.of(memberRequest());
        var member = MemberTestFactory.member();

        when(memberRepository.saveAll(any())).thenReturn(List.of(member));

        mockMvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.length()", is(1)));
    }

}
