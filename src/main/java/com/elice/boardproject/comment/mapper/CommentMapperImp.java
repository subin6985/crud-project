package com.elice.boardproject.comment.mapper;

import com.elice.boardproject.comment.entity.Comment;
import com.elice.boardproject.comment.entity.CommentDto;
import org.springframework.stereotype.Component;

@Component
public class CommentMapperImp implements CommentMapper {
    public CommentMapperImp() {
    }

    public Comment commentDtoToComment(CommentDto commentDto) {
        if (commentDto == null) {
            return null;
        } else {
            Comment comment = new Comment();
            comment.setContent(commentDto.getContent());
            return comment;
        }
    }
}
