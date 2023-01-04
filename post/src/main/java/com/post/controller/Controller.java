package com.post.controller;

import com.post.dto.PostDto;
import com.post.service.service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final service service;

    @PostMapping("/post/{member_id}")
    public ResponseEntity<PostDto> save(@PathVariable("member_id") String member_id, @RequestBody PostDto request) {
        PostDto postDto1 = service.savePost(member_id, request);
        return ResponseEntity.ok(postDto1);
    }
}
