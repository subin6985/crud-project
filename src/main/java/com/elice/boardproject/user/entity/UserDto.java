package com.elice.boardproject.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String id;
    private String password;
    private String nickname;
    private String email;
    private String profileImg;
}
