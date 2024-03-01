package com.elice.boardproject.board.mapper;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.board.entity.BoardPostDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-01T23:24:56+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BoardMapperImpl implements BoardMapper {

    @Override
    public Board boardPostDtoToBoard(BoardPostDto boardPostDto) {
        if ( boardPostDto == null ) {
            return null;
        }

        Board.BoardBuilder board = Board.builder();

        board.name( boardPostDto.getName() );
        board.description( boardPostDto.getDescription() );

        return board.build();
    }
}
