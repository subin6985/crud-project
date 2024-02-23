package com.elice.boardproject.comment.controller;

import com.elice.boardproject.comment.entity.Comment;
import com.elice.boardproject.comment.entity.CommentDto;
import com.elice.boardproject.comment.mapper.CommentMapper;
import com.elice.boardproject.comment.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/comments"})
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @PostMapping
    public String createComment(@ModelAttribute CommentDto commentDto, @RequestParam Long postId, RedirectAttributes redirectAttributes) {
        Comment comment = this.commentMapper.commentDtoToComment(commentDto);
        this.commentService.createComment(postId, comment);
        redirectAttributes.addAttribute("postId", postId);
        return "redirect:/posts/{postId}";
    }

    @PostMapping({"/{commentId}/edit"})
    public String updateComment(@PathVariable Long commentId, @ModelAttribute CommentDto commentDto, RedirectAttributes redirectAttributes) {
        Comment comment = this.commentMapper.commentDtoToComment(commentDto);
        Comment updatedComment = this.commentService.updateComment(commentId, comment);
        redirectAttributes.addAttribute("postId", updatedComment.getPost().getId());
        return "redirect:/posts/{postId}";
    }

    @DeleteMapping({"/{commentId}"})
    public String deleteComment(@PathVariable Long commentId) {
        this.commentService.deleteComment(commentId);
        return "redirect:/posts";
    }

    public CommentController(final CommentService commentService, final CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }
}
