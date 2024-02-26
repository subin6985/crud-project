package com.elice.boardproject.board.mapper;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.board.entity.BoardPostDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class BoardMapperImpl implements BoardMapper {
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
