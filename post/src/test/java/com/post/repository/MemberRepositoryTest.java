package com.post.repository;

import com.post.PostApplication;
import com.post.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest extends PostApplication {
    @Autowired
    MemberRepository memberRepository;

    @Test
    void findByMemberId() {
        String memberId = "qwe916";
        Member byMemberId = memberRepository.findByMemberId(memberId);

        Assertions.assertThat(byMemberId.getName()).isEqualTo("전홍영");
    }

}