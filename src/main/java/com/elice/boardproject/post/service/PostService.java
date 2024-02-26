package com.elice.boardproject.post.service;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.board.service.BoardService;
import com.elice.boardproject.global.exception.ExceptionCode;
import com.elice.boardproject.global.exception.ServiceLogicException;
import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.entity.PostPostDto;
import com.elice.boardproject.post.repository.PostRepository;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final BoardService boardService;

    public Page<Post> findPostsByBoardAndKeyword(Board board, String keyword, PageRequest pageRequest) {
        return keyword != null && !keyword.isEmpty() ? this.postRepository.findAllByBoardAndTitleContaining(board, keyword, pageRequest) : this.postRepository.findAllByBoardOrderByCreatedAtDesc(board, pageRequest);
    }

    // 사용자가 작성한 글만 보여줌
    public Page<Post> findPostsByBoardAndUserId(Board board, String userId, PageRequest pageRequest) {
        return userId != null && !userId.isEmpty() ? this.postRepository.findAllByBoardAndUserId(board, userId, pageRequest) : this.postRepository.findAllByBoardOrderByCreatedAtDesc(board, pageRequest);
    }

    public Post findPost(Long postId) {
        return (Post)this.postRepository.findById(postId).orElseThrow(() -> {
            return new ServiceLogicException(ExceptionCode.POST_NOT_FOUND);
        });
    }

    public Post createPost(Post post, Long boardId) {
        Board boardToCreate = this.boardService.findBoardById(boardId);
        post.setBoard(boardToCreate);
        Post savedPost = (Post)this.postRepository.save(post);
        return savedPost;
    }

    public Post updatePost(Post post, Long postId) {
        post.setId(postId);
        Post foundPost = (Post)this.postRepository.findById(post.getId()).orElseThrow(() -> {
            return new ServiceLogicException(ExceptionCode.POST_NOT_FOUND);
        });
        Optional.ofNullable(post.getTitle()).ifPresent((title) -> {
            foundPost.setTitle(title);
        });
        Optional.ofNullable(post.getSeat()).ifPresent((seat) -> {
            foundPost.setSeat(seat);
        });
        Optional.ofNullable(post.getScore()).ifPresent((score) -> {
            foundPost.setScore(score);
        });
        Optional.ofNullable(post.getContent()).ifPresent((content) -> {
            foundPost.setContent(content);
        });
        return (Post)this.postRepository.save(foundPost);
    }

    public void deletePost(Long id) {
        Post foundPost = (Post)this.postRepository.findById(id).orElseThrow(() -> {
            return new ServiceLogicException(ExceptionCode.POST_NOT_FOUND);
        });
        this.postRepository.delete(foundPost);
    }
}
