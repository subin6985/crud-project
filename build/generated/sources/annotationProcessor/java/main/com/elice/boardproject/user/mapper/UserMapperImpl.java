package com.elice.boardproject.user.mapper;

import com.elice.boardproject.user.entity.User;
import com.elice.boardproject.user.entity.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-27T23:08:38+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setPassword( userDto.getPassword() );
        user.setNickname( userDto.getNickname() );
        user.setEmail( userDto.getEmail() );
        user.setProfileImg( userDto.getProfileImg() );

        return user;
    }
}
