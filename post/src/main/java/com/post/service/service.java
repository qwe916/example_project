package com.post.service;

import com.post.domain.Member;
import com.post.domain.Post;
import com.post.dto.PostDto;
import com.post.repository.MemberRepository;
import com.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class service {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Transactional
    public PostDto savePost(String member_id, PostDto postDto) {
        Member member = memberRepository.findByMemberId(member_id);
        log.info(member.getName());
        Post post = Post.builder()
                .writer(member)
                .comment(postDto.getComment())
                .build();
        return postRepository.save(post).toDto();
    }
}
