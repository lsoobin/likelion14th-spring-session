package com.likelion.springsession.post.service;

import com.likelion.springsession.post.dto.PostCreateRequest;
import com.likelion.springsession.post.dto.PostDetailResponse;
import com.likelion.springsession.post.dto.PostSummaryResponse;
import com.likelion.springsession.post.dto.PostUpdateRequest;
import com.likelion.springsession.post.entity.Post;
import com.likelion.springsession.post.repository.PostRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    private final PostRepository postRepository;

    // 직접 new 하지 않고 생성자로 주입받는다
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostSummaryResponse> getPostSummaries() {
        List<Post> posts = postRepository.findAll();                 // ① Entity 목록 조회
        List<PostSummaryResponse> responses = new ArrayList<>();
        for (Post post : posts) {                                    // ② 하나씩 DTO로 변환
            PostSummaryResponse response = new PostSummaryResponse(
                    post.getId(),
                    post.getTitle(),
                    post.getCreatedAt()                              //    content는 담지 않는다
            );
            responses.add(response);
        }
        return responses;                                            // ③ 변환한 DTO 목록 반환
    }

    public List<PostDetailResponse> getPostDetails() {
        List<Post> posts = postRepository.findAll();
        List<PostDetailResponse> responses = new ArrayList<>();
        for (Post post : posts) {
            responses.add(toDetailResponse(post));
        }
        return responses;
    }

    public PostDetailResponse getPost(Long postId) {
        Post post = findPostById(postId);
        return toDetailResponse(post);
    }

    public PostDetailResponse createPost(PostCreateRequest request) {
        Post post = new Post(request.getTitle(), request.getContent());
        Post savedPost = postRepository.save(post);
        return toDetailResponse(savedPost);
    }

    // 메서드 전체가 하나의 트랜잭션 = 하나의 영속성 컨텍스트로 묶인다.
    // findPostById로 조회한 post는 영속 상태이므로, update()로 필드만 바꿔도
    // 트랜잭션이 끝날 때 변경을 감지해(dirty checking) 자동으로 UPDATE 쿼리가 나간다.
    // → save()를 다시 호출할 필요가 없다.
    @Transactional
    public PostDetailResponse updatePost(Long postId, PostUpdateRequest request) {
        Post post = findPostById(postId);
        post.update(request.getTitle(), request.getContent());
        return toDetailResponse(post);
    }

    // delete()도 쓰기 작업이므로 트랜잭션 범위 안에서 실행되어야 한다.
    @Transactional
    public void deletePost(Long postId) {
        Post post = findPostById(postId);
        postRepository.delete(post);
    }

    // 예외처리는 이번 세션에서 다루지 않는다. 지금은 기본 예외만 던지고,
    // "게시글이 없을 때 404로 응답하기"는 다음 세션(예외처리)에서 정리한다.
    private Post findPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow();
    }

    private PostDetailResponse toDetailResponse(Post post) {
        return new PostDetailResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt()
        );
    }
}
