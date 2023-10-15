package com.example.sb.entity;

import com.example.sb.dto.MemberRequest;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    public static MemberEntity toEntity(MemberRequest memberRequest){
        return MemberEntity.builder()
                .email(memberRequest.getEmail())
                .password(memberRequest.getPassword())
                .role(Role.ADMIN)
                .build();
    }
}
