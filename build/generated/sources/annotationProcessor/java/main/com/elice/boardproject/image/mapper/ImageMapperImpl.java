package com.elice.boardproject.image.mapper;

import com.elice.boardproject.image.entity.Image;
import com.elice.boardproject.image.entity.ImageDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T01:38:20+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public Image imageDtoToImage(ImageDto imageDto) {
        if ( imageDto == null ) {
            return null;
        }

        Image image = new Image();

        image.setImageUrl( imageDto.getImageUrl() );

        return image;
    }
}
