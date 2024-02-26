package com.elice.boardproject.post.controller;

import com.elice.boardproject.board.service.BoardService;
import com.elice.boardproject.comment.entity.Comment;
import com.elice.boardproject.comment.service.CommentService;
import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.entity.PostPostDto;
import com.elice.boardproject.post.mapper.PostMapper;
import com.elice.boardproject.post.service.PostService;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@AllArgsConstructor
@Controller
@RequestMapping({"/posts"})
public class PostController {
    private final PostService postService;
    private final BoardService boardService;
    private final PostMapper postMapper;
    private final CommentService commentService;

    @GetMapping({"/{postId}"})
    public String getPostDetail(@PathVariable Long postId, Model model) {
        Post post = this.postService.findPost(postId);
        model.addAttribute("post", post);
        List<Comment> comments = this.commentService.findCommentsByPostId(postId);
        model.addAttribute("comments", comments);
        return "post/post";
    }

    @GetMapping({"/create"})
    public String createPost(@RequestParam Long boardId, Model model) {
        model.addAttribute("boardId", boardId);
        return "post/createPost";
    }

    @PostMapping({"/create"})
    public String createPostPost(@ModelAttribute PostPostDto postPostDto, @RequestParam Long boardId) {
        Post post = this.postMapper.postPostDTOToPost(postPostDto);
        Post createdPost = this.postService.createPost(post, boardId);
        return "redirect:/boards/" + createdPost.getBoard().getId();
    }

    @GetMapping({"/{postId}/edit"})
    public String editPost(@PathVariable Long postId, Model model) {
        Post post = this.postService.findPost(postId);
        model.addAttribute("post", post);
        return "post/editPost";
    }

    @PostMapping({"/{postId}/edit"})
    public String editPost(@PathVariable Long postId, @ModelAttribute PostPostDto postPostDto, RedirectAttributes redirectAttributes) {
        Post post = this.postMapper.postPostDTOToPost(postPostDto);
        Post updatedPost = this.postService.updatePost(post, postId);
        redirectAttributes.addAttribute("postId", updatedPost.getId());
        redirectAttributes.addFlashAttribute("message", "게시글이 수정되었습니다.");
        return "redirect:/posts/{postId}";
    }

    @DeleteMapping({"/{postId}"})
    public String deletePost(@PathVariable Long postId, RedirectAttributes redirectAttributes) {
        this.postService.deletePost(postId);
        redirectAttributes.addFlashAttribute("message", "과목이 제거되었습니다.");
        return "redirect:/posts";
    }
}
