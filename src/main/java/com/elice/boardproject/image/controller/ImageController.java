package com.elice.boardproject.image.controller;

import com.elice.boardproject.image.entity.Image;
import com.elice.boardproject.image.entity.ImageDto;
import com.elice.boardproject.image.mapper.ImageMapper;
import com.elice.boardproject.image.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping({"/images"})
public class ImageController {
    private final ImageService imageService;
    private final ImageMapper imageMapper;

    @PostMapping
    public String createImage(@ModelAttribute ImageDto imageDto, @RequestParam Long postId, RedirectAttributes redirectAttributes) {
        Image image = this.imageMapper.imageDtoToImage(imageDto);
        this.imageService.createImage(postId, image);
        redirectAttributes.addAttribute("postId", postId);
        return "redirect:/posts/{postId}";
    }

    @PostMapping({"/{imageId}/edit"})
    public String updateImage(@PathVariable Long imageId, @ModelAttribute ImageDto imageDto, RedirectAttributes redirectAttributes) {
        Image image = this.imageMapper.imageDtoToImage(imageDto);
        Image updatedImage = this.imageService.updateImage(imageId, image);
        redirectAttributes.addAttribute("postId", updatedImage.getPost().getId());
        return "redirect:/posts/{postId}";
    }

    @DeleteMapping({"/{imageId}"})
    public String deleteImage(@PathVariable Long imageId) {
        this.imageService.deleteImage(imageId);
        return "redirect:/posts";
    }
}
