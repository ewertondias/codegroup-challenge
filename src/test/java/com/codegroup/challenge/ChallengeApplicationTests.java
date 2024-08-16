package com.codegroup.challenge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ChallengeApplicationTests {

	@Test
	@DisplayName("Challenge")
	void contextLoads() {
		assertTrue(Boolean.TRUE);
	}

}

