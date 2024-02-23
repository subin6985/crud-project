package com.elice.boardproject.user.entity;

public class UserDto {
    private String id;
    private String password;
    private String nickname;
    private String email;
    private String profileImg;

    public String getId() { return this.id; }

    public String getPassword() { return this.password; }

    public String getNickname() { return this.nickname; }

    public String getEmail() { return this.email; }

    public String getProfileImg() { return this.profileImg; }

    public void setId(String id) { this.id = id; }

    public void setPassword(String password) { this.password = password; }

    public void setNickname(String nickname) { this.nickname = nickname; }

    public void setEmail(String email) { this.email = email; }

    public void setProfileImg(String profileImg) { this.profileImg = profileImg; }

    public UserDto(String id, String password, String nickname, String email, String profileImg) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.profileImg = profileImg;
    }
}
