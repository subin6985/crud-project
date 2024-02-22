package com.elice.boardproject.comment.entity;

public class CommentDto {
    private String content;

    public String getContent() {
        return this.content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public CommentDto(final String content) {
        this.content = content;
    }
}
