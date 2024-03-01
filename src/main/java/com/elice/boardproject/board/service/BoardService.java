package com.elice.boardproject.board.service;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.board.repository.BoardRepository;
import com.elice.boardproject.comment.service.CommentService;
import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.repository.PostRepository;
import com.elice.boardproject.global.exception.ExceptionCode;
import com.elice.boardproject.global.exception.ServiceLogicException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final PostRepository postRepository;
    private final CommentService commentService;
    private Board foundBoard;

    public BoardService(BoardRepository boardRepository, PostRepository postRepository, CommentService commentService) {
        this.boardRepository = boardRepository;
        this.postRepository = postRepository;
        this.commentService = commentService;
    }

    public List<Board> findBoards() {
        return this.boardRepository.findAll();
    }

    public Board findBoardById(Long id) {
        return this.boardRepository.findById(id).orElseThrow(() -> new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND));
    }

    public Board createBoard(Board board) {
        return this.boardRepository.create(board);
    }

    public Board updateBoard(Board board) {
        this.foundBoard = this.boardRepository.findById(board.getId()).orElseThrow(() -> new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND));
        Optional.ofNullable(board.getName()).ifPresent((name) -> {
            this.foundBoard = this.foundBoard.toBuilder().name(name).build();
        });
        this.foundBoard = this.foundBoard.toBuilder().description(board.getDescription()).build();
        return this.boardRepository.update(this.foundBoard);
    }

    public void deleteBoard(Long id) {
        this.foundBoard = this.boardRepository.findById(id).orElseThrow(() -> new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND));
        List<Post> posts = this.postRepository.findAllByBoard(foundBoard);
        for(Post post: posts) {
            this.commentService.deleteCommentByPostId(post.getId());
            this.postRepository.delete(post);
        }
        this.boardRepository.delete(this.foundBoard);
    }
}
