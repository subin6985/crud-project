package com.elice.boardproject.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class BoardPostDto {
    private String name;
    private String description;
}
