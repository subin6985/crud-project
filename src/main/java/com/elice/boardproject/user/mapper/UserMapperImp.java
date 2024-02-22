package com.elice.boardproject.user.mapper;

import com.elice.boardproject.user.entity.User;
import com.elice.boardproject.user.entity.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImp implements UserMapper {
    public UserMapperImp() {
    }

    public User userDtoToUser(UserDto userDto) {
        if(userDto == null) {
            return null;
        } else {
            User user = new User();
            user.setId(userDto.getId());
            return user;
        }
    }
}
