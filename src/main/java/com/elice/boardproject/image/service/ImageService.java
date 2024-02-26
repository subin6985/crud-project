package com.elice.boardproject.image.service;

import com.elice.boardproject.image.entity.Image;
import com.elice.boardproject.image.repository.ImageRepository;
import com.elice.boardproject.global.exception.ExceptionCode;
import com.elice.boardproject.global.exception.ServiceLogicException;
import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.repository.PostRepository;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private static final Logger log = LoggerFactory.getLogger(ImageService.class);
    private ImageRepository imageRepository;

    private PostRepository postRepository;

    public ImageService(ImageRepository imageRepository, PostRepository postRepository) {
        this.imageRepository = imageRepository;
        this.postRepository = postRepository;
    }

    public List<Image> findImages() {
        return this.imageRepository.findAll();
    }

    public Image findImage(Long imageId) {
        return (Image)this.imageRepository.findById(imageId).orElse(null);
    }

    public List<Image> findImagesByPostId(Long postId) {
        return this.imageRepository.findByPostId(postId);
    }

    public Image createImage(Long postId, Image image) {
        Post post = (Post)this.postRepository.findById(postId).orElseThrow(() -> {
            return new ServiceLogicException(ExceptionCode.POST_NOT_FOUND);
        });
        log.info(post.getTitle());
        image.setPost(post);
        return (Image)this.imageRepository.save(image);
    }

    public Image updateImage(Long imageId, Image image) {
        image.setId(imageId);
        Image foundImage = (Image)this.imageRepository.findById(image.getId()).orElse(null);
        Optional.ofNullable(image.isThumbnail()).ifPresent((thumbnail) -> {
            foundImage.setThumbnail(thumbnail);
        });
        Optional.ofNullable(image.getImageUrl()).ifPresent((imageUrl) -> {
            foundImage.setImageUrl(imageUrl);
        });
        return (Image)this.imageRepository.save(foundImage);
    }

    public void deleteImage(Long imageId) {
        Image foundImage = (Image)this.imageRepository.findById(imageId).orElse(null);
        this.imageRepository.delete(foundImage);
    }
}
