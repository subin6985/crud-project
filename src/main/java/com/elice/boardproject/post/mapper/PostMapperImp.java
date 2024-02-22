package com.elice.boardproject.post.mapper;

import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.entity.PostPostDto;
import org.springframework.stereotype.Component;

@Component
public class PostMapperImp implements PostMapper {
    public PostMapperImp() {
    }

    public Post postPostDTOToPost(PostPostDto postPostDto) {
        if (postPostDto == null) {
            return null;
        } else {
            Post post = new Post();
            post.setTitle(postPostDto.getTitle());
            post.setSeat(postPostDto.getSeat());
            post.setScore(postPostDto.getScore());
            post.setContent(postPostDto.getContent());
            return post;
        }
    }
}
