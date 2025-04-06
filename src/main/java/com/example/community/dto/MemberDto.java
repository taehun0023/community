package com.example.community.dto;

import com.example.community.entitiy.Member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor // ✅ 기본 생성자 추가
@AllArgsConstructor // ✅ builder와 함께 사용 시 추천
public class MemberDto {

    @NotBlank(message = "아이디는 필수입니다.")
    @Size(min = 3, max = 8, message = "아이디는 3~8자 사이여야 합니다.")
    private String memberId;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Size(min = 3, max = 8, message = "비밀번호는 3~8자 사이여야 합니다.")
    private String memberPw;

    @NotBlank(message = "이름은 필수입니다.")
    @Size(min = 2, max = 4, message = "이름은 2~4자 사이여야 합니다.")
    private String memberName;

    private String member_indate; // 출력용 (등록일), 저장 시 사용 X

    // DTO → Entity 변환 (비밀번호는 암호화된 값으로 주입)
    public Member toEntity(String encodedPassword) {
        return Member.builder()
                .memberId(memberId)
                .memberPw(encodedPassword)
                .memberName(memberName)
                .build();
    }

}