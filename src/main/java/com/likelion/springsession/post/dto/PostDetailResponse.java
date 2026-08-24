package com.likelion.springsession.post.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 필드가 전부 final이라 값은 생성 시점에 한 번만 채워지고 이후 바뀌지 않는다.
// @RequiredArgsConstructor가 final 필드를 전부 받는 생성자를 만들어준다.
@Getter
@RequiredArgsConstructor
public class PostDetailResponse {

    private final Long id;
    private final String title;
    private final String content;   // 상세 화면에는 본문이 필요하므로 포함한다
    private final LocalDateTime createdAt;
}
