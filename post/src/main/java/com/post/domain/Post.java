package com.post.domain;

import com.post.dto.PostDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "post")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseTimeEntity{
    @Id//PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK 생성전략(Auto_increment를 사용)
    @Column(name = "id", nullable = false)//컬럼 설정 ,null 불가능
    private Long id;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @OneToOne(mappedBy = "post")
    private Member writer;

    public PostDto toDto() {
        return PostDto.builder()
                .comment(comment)
                .writerNickName(writer.getNickName())
                .createDate(createDate)
                .lastModifiedDate(lastModifiedDate)
                .build();
    }

}
