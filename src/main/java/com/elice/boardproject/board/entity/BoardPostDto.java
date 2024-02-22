package com.elice.boardproject.board.entity;

public class BoardPostDto {
    private String name;
    private String description;

    public static BoardPostDtoBuilder builder() {
        return new BoardPostDtoBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public BoardPostDto(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public static class BoardPostDtoBuilder {
        private String name;
        private String description;

        BoardPostDtoBuilder() {
        }

        public BoardPostDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public BoardPostDtoBuilder description(final String description) {
            this.description = description;
            return this;
        }

        public BoardPostDto build() {
            return new BoardPostDto(this.name, this.description);
        }

        public String toString() {
            return "BoardPostDto.BoardPostDtoBuilder(name=" + this.name + ", description=" + this.description + ")";
        }
    }
}
