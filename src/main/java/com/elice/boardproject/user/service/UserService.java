package com.elice.boardproject.user.service;

import com.elice.boardproject.comment.entity.Comment;
import com.elice.boardproject.user.entity.User;
import com.elice.boardproject.user.repository.UserRepository;
import com.elice.boardproject.global.exception.ExceptionCode;
import com.elice.boardproject.global.exception.ServiceLogicException;
import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.repository.PostRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUsers() {
        return this.userRepository.findAll();
    }

    public User findUser(String userId) {
        Long userIdAsLong = Long.parseLong(userId);
        return (User)this.userRepository.findById(userIdAsLong).orElse(null);
    }

    public User createUser(User user) {
        return (User)this.userRepository.save(user);
    }

    public User updateUser(String userId, User user) {
        user.setId(userId);
        User foundUser = (User)this.userRepository.findById(Long.parseLong(user.getId())).orElse(null);
        Optional.ofNullable(user.getId()).ifPresent((id) -> {
            foundUser.setId(id);
        });
        Optional.ofNullable(user.getPassword()).ifPresent((password) -> {
            foundUser.setPassword(password);
        });
        Optional.ofNullable(user.getNickname()).ifPresent((nickname) -> {
            foundUser.setNickname(nickname);
        });
        Optional.ofNullable(user.getEmail()).ifPresent((email) -> {
            foundUser.setEmail(email);
        });
        Optional.ofNullable(user.getProfileImg()).ifPresent((profileImg) -> {
            foundUser.setProfileImg(profileImg);
        });
        return (User)this.userRepository.save(foundUser);
    }

    public void deleteUser(String userId) {
        User foundUser = (User)this.userRepository.findById(Long.parseLong(userId)).orElse(null);
        foundUser.setStatus(false);
        this.userRepository.delete(foundUser);
    }

    public void saveUserWithValidation(String userId) {
        if(isValidInput(userId)) {
            if(!userRepository.existsById(userId)) {
                User user = new User();
                user.setId(userId);

                userRepository.save(user);
            } else {
                throw new IllegalArgumentException("이미 존재하는 ID입니다.");
            }
        } else {
            throw new IllegalArgumentException("유효하지 않은 ID입니다.");
        }
    }

    public void validateUserId(String userId) {
        if(!userRepository.existsById(userId) || userId.length() < 15) {
            throw  new IllegalArgumentException("유효하지 않은 ID입니다.");
        }
    }

    private boolean isValidInput(String userId) {
        return userId != null && !userId.isEmpty() && userId.length() <= 15;
    }
}
