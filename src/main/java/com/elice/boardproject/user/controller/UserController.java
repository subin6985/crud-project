package com.elice.boardproject.user.controller;

import com.elice.boardproject.user.entity.User;
import com.elice.boardproject.user.entity.UserDto;
import com.elice.boardproject.user.mapper.UserMapper;
import com.elice.boardproject.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@AllArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping({"/{userId}"})
    public String getUserDetail(@PathVariable String userId, Model model) {
        User user = this.userService.findUser(userId);
        model.addAttribute("user", user);
        return "user/user";
    }

    @PostMapping({"/create"})
    public String createUser(@ModelAttribute UserDto userDto) {
        String userId = userDto.getId();
        userService.saveUserWithValidation(userId);
        return "/posts";
    }

    @GetMapping({"/{userId}/edit"})
    public String editUser(@PathVariable String userId, Model model) {
        userService.validateUserId(userId);
        User user = this.userService.findUser(userId);
        model.addAttribute("user", user);
        return "user/editUser";
    }

    @PostMapping({"/{userId}/edit"})
    public String editUser(@PathVariable String userId, @ModelAttribute UserDto userDto, RedirectAttributes redirectAttributes) {
        String newUserId = userDto.getId();
        userService.validateUserId(newUserId);
        User user = this.userMapper.userDtoToUser(userDto);
        User updatedUser = this.userService.updateUser(userId, user);
        redirectAttributes.addAttribute("userId", updatedUser.getId());
        redirectAttributes.addFlashAttribute("message", "회원정보가 수정되었습니다.");
        return "redirect:/users/{userId}";
    }

    @DeleteMapping({"/{userId}"})
    public String deleteUser(@PathVariable String userId, RedirectAttributes redirectAttributes) {
        this.userService.deleteUser(userId);
        redirectAttributes.addFlashAttribute("message", "과목이 제거되었습니다.");
        return "/posts";
    }
}
