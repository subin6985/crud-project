package com.elice.boardproject.user.mapper;

import com.elice.boardproject.user.entity.User;
import com.elice.boardproject.user.entity.UserDto;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {
    User userDtoToUser(UserDto userDto);
}
