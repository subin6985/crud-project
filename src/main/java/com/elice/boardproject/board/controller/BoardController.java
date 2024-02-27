package com.elice.boardproject.board.controller;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.board.entity.BoardPostDto;
import com.elice.boardproject.board.mapper.BoardMapper;
import com.elice.boardproject.board.service.BoardService;
import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.service.PostService;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
@RequestMapping({"/boards"})
public class BoardController {
    private final BoardService boardService;
    private final PostService postService;
    private final BoardMapper boardMapper;

    @GetMapping
    public String getBoards(Model model) {
        List<Board> boards = this.boardService.findBoards();
        model.addAttribute("boards", boards);
        return "board/boards";
    }

    // 내가 작성한 글 목록
    /*@GetMapping({"/{boardId}/1"})
    public String getBoardByUser(@PathVariable Long boardId, @RequestParam String userId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        Board board = this.boardService.findBoardById(boardId);
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Post> postPage = this.postService.findPostsByBoardAndUserId(board, userId, pageRequest);
        model.addAttribute("board", board);
        model.addAttribute("userId", userId);
        model.addAttribute("postPage", postPage);
        return "board/board";
    }*/

    // 전체 글 목록
    @GetMapping({"/{boardId}"})
    public String getBoard(@PathVariable Long boardId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(required = false) String keyword, Model model) {
        Board board = this.boardService.findBoardById(boardId);
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Post> postPage = this.postService.findPostsByBoardAndKeyword(board, keyword, pageRequest);
        model.addAttribute("board", board);
        model.addAttribute("keyword", keyword);
        model.addAttribute("postPage", postPage);
        return "board/board";
    }

    @GetMapping({"/create"})
    public String createBoard(Model model) {
        return "board/createBoard";
    }

    @PostMapping({"/create"})
    public String createBoardPost(@ModelAttribute BoardPostDto boardPostDto) {
        Board board = this.boardMapper.boardPostDtoToBoard(boardPostDto);
        this.boardService.createBoard(board);
        return "redirect:/boards";
    }

    @GetMapping({"/{boardId}/edit"})
    public String editBoard(@PathVariable Long boardId, Model model) {
        Board board = this.boardService.findBoardById(boardId);
        model.addAttribute("board", board);
        return "board/editBoard";
    }

    @PostMapping({"/{boardId}/edit"})
    public String editBoardPost(@PathVariable Long boardId, @ModelAttribute BoardPostDto boardPostDto) {
        Board board = this.boardMapper.boardPostDtoToBoard(boardPostDto).toBuilder().id(boardId).build();
        this.boardService.updateBoard(board);
        return "redirect:/boards";
    }

    @DeleteMapping({"/{boardId}/delete"})
    public String deleteBoard(@PathVariable Long boardId) {
        this.boardService.deleteBoard(boardId);
        return "redirect:/boards";
    }
}
