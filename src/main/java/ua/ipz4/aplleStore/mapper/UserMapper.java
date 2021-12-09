package ua.ipz4.aplleStore.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ua.ipz4.aplleStore.dto.UserDto;
import ua.ipz4.aplleStore.model.Card;
import ua.ipz4.aplleStore.model.Role;
import ua.ipz4.aplleStore.model.UserModel;

@Component
public class UserMapper {

    public UserModel dtoToEntity(UserDto userDto){
        UserModel userModel = new UserModel();
        Card card = new Card();
        userModel.setCard(card);
        userModel.setId(userDto.getId());
        userModel.setLogin(userDto.getLogin());
        userModel.setPassword(userDto.getPassword());
        userModel.setRole(Role.ROLE_USER);
        userModel.setFullName(userDto.getFullName());
        return userModel;
    };

    public UserDto entityToDto(UserModel userModel){
        UserDto userDto = new UserDto();
        userDto.setId(userModel.getId());
        userDto.setLogin(userModel.getLogin());
        userDto.setFullName(userModel.getFullName());
        return userDto;

    };
}
