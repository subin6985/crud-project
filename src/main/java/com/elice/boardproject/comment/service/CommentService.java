package com.elice.boardproject.comment.service;

import com.elice.boardproject.comment.entity.Comment;
import com.elice.boardproject.comment.repository.CommentRepository;
import com.elice.boardproject.global.exception.ExceptionCode;
import com.elice.boardproject.global.exception.ServiceLogicException;
import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.repository.PostRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private static final Logger log = LoggerFactory.getLogger(CommentService.class);
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> findComments() {
        return this.commentRepository.findAll();
    }

    public Comment findComment(Long commentId) {
        return this.commentRepository.findById(commentId).orElseThrow(() -> new ServiceLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }

    public List<Comment> findCommentsByPostId(Long postId) {
        return this.commentRepository.findByPostId(postId);
    }

    public Comment createComment(Long postId, Comment comment) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ServiceLogicException(ExceptionCode.POST_NOT_FOUND));
        log.info(post.getTitle());
        comment.setPost(post);
        return this.commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, Comment comment) {
        comment.setId(commentId);
        Comment foundComment = this.commentRepository.findById(comment.getId()).orElseThrow(() -> new ServiceLogicException(ExceptionCode.COMMENT_NOT_FOUND));
        Optional.ofNullable(comment.getContent()).ifPresent((content) -> {
            foundComment.setContent(content);
        });
        return this.commentRepository.save(foundComment);
    }

    public void deleteComment(Long commentId) {
        Comment foundComment = this.commentRepository.findById(commentId).orElseThrow(() -> new ServiceLogicException(ExceptionCode.COMMENT_NOT_FOUND));
        this.commentRepository.delete(foundComment);
    }

    public void deleteCommentByPostId(Long postId) {
        List<Comment> comments = this.commentRepository.findByPostId(postId);
        for(Comment comment: comments) {
            this.commentRepository.delete(comment);
        }
    }
}
