package com.post.dto;

import com.post.domain.Member;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {


    private String writerNickName;
    @NotBlank
    private String comment;

    private LocalDateTime createDate;

    private LocalDateTime lastModifiedDate;

}
