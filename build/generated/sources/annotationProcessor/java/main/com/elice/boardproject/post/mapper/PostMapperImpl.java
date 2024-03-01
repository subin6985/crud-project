package com.elice.boardproject.post.mapper;

import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.entity.PostPostDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-01T23:24:57+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post postPostDTOToPost(PostPostDto postPostDto) {
        if ( postPostDto == null ) {
            return null;
        }

        Post post = new Post();

        post.setTitle( postPostDto.getTitle() );
        post.setHall( postPostDto.getHall() );
        post.setSeat( postPostDto.getSeat() );
        post.setScore( postPostDto.getScore() );
        post.setContent( postPostDto.getContent() );

        return post;
    }
}
