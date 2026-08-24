package com.likelion.springsession.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Request DTO는 Jackson이 JSON을 객체로 바꿀 때
// 기본 생성자로 객체를 만든 뒤 Setter로 값을 채운다.
// 그래서 @NoArgsConstructor + @Setter가 함께 필요하다.
@Getter
@Setter
@NoArgsConstructor
public class PostCreateRequest {

    @NotBlank(message = "제목은 필수입니다.")
    @Size(max = 100, message = "제목은 100자 이하로 작성해주세요.")
    private String title;

    @NotBlank(message = "본문은 필수입니다.")
    @Size(max = 2000, message = "본문은 2000자 이하로 작성해주세요.")
    private String content;
}
