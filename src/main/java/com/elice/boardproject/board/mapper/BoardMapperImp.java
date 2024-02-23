package com.elice.boardproject.board.mapper;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.board.entity.BoardPostDto;
import org.springframework.stereotype.Component;

@Component
public class BoardMapperImp implements BoardMapper {
    public BoardMapperImp() {
    }

    public Board boardPostDtoToBoard(BoardPostDto boardPostDto) {
        if (boardPostDto == null) {
            return null;
        } else {
            Board.BoardBuilder board = Board.builder();
            board.name(boardPostDto.getName());
            board.description(boardPostDto.getDescription());
            return board.build();
        }
    }
}
