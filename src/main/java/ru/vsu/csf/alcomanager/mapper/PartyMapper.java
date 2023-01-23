package ru.vsu.csf.alcomanager.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.vsu.csf.alcomanager.dto.PartyDTO;
import ru.vsu.csf.alcomanager.model.Party;

@Component
public class PartyMapper {
    private final ModelMapper modelMapper;

    public PartyMapper() {
        this.modelMapper = new ModelMapper();
    }

    public PartyDTO convertToDto(Party party){
        return modelMapper.map(party, PartyDTO.class);
    }


}
