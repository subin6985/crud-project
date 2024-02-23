package com.elice.boardproject.image.mapper;

import com.elice.boardproject.image.entity.Image;
import com.elice.boardproject.image.entity.ImageDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    Image imageDtoToImage(ImageDto imageDto);
}
