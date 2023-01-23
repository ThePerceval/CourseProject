package ru.vsu.csf.alcomanager.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.vsu.csf.alcomanager.dto.UserDTO;
import ru.vsu.csf.alcomanager.model.User;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper() {
        this.modelMapper = new ModelMapper();
    }

    public UserDTO convertToDto(User user){
        return modelMapper.map(user, UserDTO.class);
    }


}