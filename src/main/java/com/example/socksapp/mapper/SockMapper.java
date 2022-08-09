package com.example.socksapp.mapper;

import com.example.socksapp.model.Sock;
import com.example.socksapp.model.dto.SockRqDto;
import com.example.socksapp.model.dto.SockRsDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SockMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public Sock mapToEntity(SockRqDto rqDto) {
        return modelMapper.map(rqDto, Sock.class);
    }

    public SockRsDto mapToDto(Sock sock) {
        return modelMapper.map(sock, SockRsDto.class);
    }
}
