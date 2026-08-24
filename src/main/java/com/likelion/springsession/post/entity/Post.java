package com.likelion.springsession.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Getter
// JPA가 DB의 row를 Post 객체로 만들 때 사용하는 매개변수 없는 생성자.
// 아무 데서나 new Post()로 빈 객체를 만들지 못하도록 protected로 열어둔다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 2000)
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // 게시글을 새로 만들 때만 사용하는 생성자. Lombok이 대신 만들어줄 수 없는,
    // createdAt = now() 라는 우리만의 로직이 들어 있어서 직접 작성한다.
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    // Setter 대신 "무엇을 바꾸는지"가 드러나는 메서드로만 상태를 바꾼다
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
