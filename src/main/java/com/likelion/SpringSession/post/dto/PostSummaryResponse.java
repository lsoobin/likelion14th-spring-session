package com.likelion.SpringSession.post.dto;

import java.time.LocalDateTime;

public class PostSummaryResponse {

    private final Long id;
    private final String title;
    private final LocalDateTime createdAt;   // content 필드는 포함하지 않는다 (목록용)

    public PostSummaryResponse(Long id, String title, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
