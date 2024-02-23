package com.elice.boardproject.post.entity;

public class PostPostDto {
    private String title;
    private String seat;
    private int score;
    private String content;

    public String getTitle() {
        return this.title;
    }

    public String getSeat() {
        return this.seat;
    }

    public int getScore() { return this.score; }

    public String getContent() {
        return this.content;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setSeat(final String seat) { this.seat = seat; }

    public void setScore(final int score) { this.score = score; }

    public void setContent(final String content) {
        this.content = content;
    }

    public PostPostDto(final String title, final String seat, final int score, final String content) {
        this.title = title;
        this.seat = seat;
        this.score = score;
        this.content = content;
    }
}