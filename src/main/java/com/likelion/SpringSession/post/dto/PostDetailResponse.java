package com.likelion.SpringSession.post.dto;

import java.time.LocalDateTime;

public class PostDetailResponse {

    private final Long id;
    private final String title;
    private final String content;   // 상세 화면에는 본문이 필요하므로 포함한다
    private final LocalDateTime createdAt;

    public PostDetailResponse(Long id, String title, String content, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
