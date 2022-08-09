package com.example.socksapp.service;

import com.example.socksapp.enums.Operations;
import com.example.socksapp.mapper.SockMapper;
import com.example.socksapp.model.Sock;
import com.example.socksapp.model.dto.SockRqDto;
import com.example.socksapp.model.dto.SockRsDto;
import com.example.socksapp.repository.SocksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.socksapp.enums.Operations.*;

@Service
@RequiredArgsConstructor
public class SockService {
    private final SocksRepository socksRepository;
    private final SockMapper sockMapper;

    @Transactional
    public SockRsDto incomeSocks(SockRqDto sock) {
        var found = socksRepository.findByColorAndCotton(sock.getColor(), sock.getCotton());
        if (found.isPresent()) {
            socksRepository.updateEntity(found.get().getId(), found.get().getQuantity() + sock.getQuantity());
            return sockMapper.mapToDto(found.get());
        } else {
            Sock save = socksRepository.save(sockMapper.mapToEntity(sock));
            return sockMapper.mapToDto(save);
        }
    }

    @Transactional
    public SockRsDto outcomeSocks(SockRqDto sock) {
        var found = socksRepository.findByColorAndCotton(sock.getColor(), sock.getCotton());
        if (found.isPresent()) {
            socksRepository.updateEntity(found.get().getId(), found.get().getQuantity() - sock.getQuantity());
            return sockMapper.mapToDto(found.get());
        } else {
            throw new RuntimeException("Таких носков нет");
        }

    }

    @Transactional
    public Integer getQuantity(String color, String operations, Integer cotton) {
        var oper = Operations.valueOf(operations);
        System.out.println(oper);
        var socks = switch (oper) {
            case equal -> socksRepository.findByColorAndCottonEquals(color, cotton);
            case lessThan -> socksRepository.findByColorAndCottonLessThan(color, cotton);
            case moreThan -> socksRepository.findByColorAndCottonGreaterThan(color, cotton);
        };
        System.out.println(socks);
        Integer quantitySocks = 0;
        for (var i : socks) {
            quantitySocks += i.getQuantity();
        }
        return quantitySocks;
    }
}
