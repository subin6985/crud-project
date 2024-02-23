package com.elice.boardproject.board.service;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.board.repository.BoardRepository;
import com.elice.boardproject.global.exception.ExceptionCode;
import com.elice.boardproject.global.exception.ServiceLogicException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private Board foundBoard;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> findBoards() {
        return this.boardRepository.findAll();
    }

    public Board findBoardById(Long id) {
        return (Board)this.boardRepository.findById(id).orElseThrow(() -> {
            return new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND);
        });
    }

    public Board createBoard(Board board) {
        return this.boardRepository.create(board);
    }

    public Board updateBoard(Board board) {
        this.foundBoard = (Board)this.boardRepository.findById(board.getId()).orElseThrow(() -> {
            return new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND);
        });
        Optional.ofNullable(board.getName()).ifPresent((name) -> {
            this.foundBoard = this.foundBoard.toBuilder().name(name).build();
        });
        this.foundBoard = this.foundBoard.toBuilder().description(board.getDescription()).build();
        return this.boardRepository.update(this.foundBoard);
    }

    public void deleteBoard(Long id) {
        this.foundBoard = (Board)this.boardRepository.findById(id).orElseThrow(() -> {
            return new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND);
        });
        this.boardRepository.delete(this.foundBoard);
    }
}
