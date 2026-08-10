package com.likelion.SpringSession.post.controller;

import com.likelion.SpringSession.post.dto.PostCreateRequest;
import com.likelion.SpringSession.post.dto.PostDetailResponse;
import com.likelion.SpringSession.post.dto.PostSummaryResponse;
import com.likelion.SpringSession.post.dto.PostUpdateRequest;
import com.likelion.SpringSession.post.service.PostService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostSummaryResponse> getPosts() {
        return postService.getPostSummaries();
    }

    @GetMapping("/{postId}")
    public PostDetailResponse getPost(@PathVariable("postId") Long postId) {
        return postService.getPost(postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDetailResponse createPost(@Valid @RequestBody PostCreateRequest request) {
        return postService.createPost(request);
    }

    @PutMapping("/{postId}")
    public PostDetailResponse updatePost(
            @PathVariable("postId") Long postId,
            @Valid @RequestBody PostUpdateRequest request
    ) {
        return postService.updatePost(postId, request);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
    }
}
