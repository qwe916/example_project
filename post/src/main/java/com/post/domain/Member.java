package com.post.domain;

import com.post.dto.MemberDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends  BaseTimeEntity{

    @Id//PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK 생성전략(Auto_increment를 사용)
    @Column(name = "id", nullable = false)//컬럼 설정 ,null 불가능
    private Long id;

    @Column(updatable = false, unique = true, nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String memberPassword;

    @Column(name = "name", nullable = false, length = 150)//컬럼 설정 ,null 불가능, 최대 길이 150
    private String name;


    @Column(name = "nick_name", nullable = false, length = 100)
    private String nickName;

    @OneToOne
    private Post post;


    public MemberDto toDto() {
        return MemberDto.builder()
                .memberId(memberId)
                .name(name)
                .nickName(nickName)
                .createDate(createDate)
                .build();
    }

}
