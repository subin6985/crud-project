package com.elice.boardproject.image.mapper;

import com.elice.boardproject.image.entity.Image;
import com.elice.boardproject.image.entity.ImageDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class ImageMapperImpl implements ImageMapper {
    public Image imageDtoToImage(ImageDto imageDto) {
        if (imageDto == null) {
            return null;
        } else {
            Image image = new Image();
            image.setThumbnail(imageDto.isThumnail());
            image.setImageUrl(imageDto.getImageUrl());
            return image;
        }
    }
}
