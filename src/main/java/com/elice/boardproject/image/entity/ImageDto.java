package com.elice.boardproject.image.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class ImageDto {
    private boolean thumnail;

    private String imageUrl;
}
