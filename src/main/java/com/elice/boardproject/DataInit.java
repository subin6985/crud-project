package com.elice.boardproject;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.board.repository.BoardRepository;
import com.elice.boardproject.comment.entity.Comment;
import com.elice.boardproject.comment.repository.CommentRepository;
import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.repository.PostRepository;
import com.elice.boardproject.user.entity.User;
import com.elice.boardproject.user.repository.UserRepository;
import com.elice.boardproject.image.entity.Image;
import com.elice.boardproject.image.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@AllArgsConstructor
public class DataInit {
    private static final Logger log = LoggerFactory.getLogger(DataInit.class);
    private final BoardRepository boardRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;

    @EventListener({ApplicationReadyEvent.class})
    public void init() {
        log.info("init stub data");
        this.boardRepository.create(new Board("공연 후기 게시판", "사용자들이 관람한 공연의 후기를 남기는 게시판입니다."));
        Board board = (Board)this.boardRepository.findById(1L).orElseThrow(() -> {
            return new RuntimeException();
        });
        Board board2 = (Board)this.boardRepository.findById(2L).orElseThrow(() -> {
            return new RuntimeException();
        });
        User user1 = new User("elice", "1234", "엘리스", "email@elice.com", "src/main/resources/static/hellobit.png");
        this.userRepository.save(user1);
        this.postRepository.save(new Post(board, user1, "240108 마리 퀴리", "2층 B구역 2열 중앙", 5, "재밌었다. 라듐 조심!"));
        Post post = (Post)this.postRepository.findById(1L).orElseThrow(() -> {
            return new RuntimeException();
        });
        Post post2 = (Post)this.postRepository.findById(12L).orElseThrow(() -> {
            return new RuntimeException();
        });
        this.commentRepository.save(new Comment(post, user1, "우와 재밌었겠어요~"));
    }
}
