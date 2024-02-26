package com.elice.boardproject;

import com.elice.boardproject.board.repository.BoardRepository;
import com.elice.boardproject.comment.repository.CommentRepository;
import com.elice.boardproject.post.repository.PostRepository;
import com.elice.boardproject.user.repository.UserRepository;
import com.elice.boardproject.image.repository.ImageRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BoardprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardprojectApplication.class, args);
	}

	@Bean
	@Profile("local")
	public DataInit stubDataInit(BoardRepository boardRepository, PostRepository postRepository, CommentRepository commentRepository, UserRepository userRepository, ImageRepository imageRepository) {
		return new DataInit(boardRepository, postRepository, commentRepository, userRepository, imageRepository);
	}

}
