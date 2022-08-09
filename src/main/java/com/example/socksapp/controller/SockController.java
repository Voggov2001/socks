package com.example.socksapp.controller;

import com.example.socksapp.enums.Operations;
import com.example.socksapp.model.Sock;
import com.example.socksapp.model.dto.SockRqDto;
import com.example.socksapp.model.dto.SockRsDto;
import com.example.socksapp.service.SockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/socks")
public class SockController {
    private final SockService service;

    @Autowired
    public SockController(SockService service) {
        this.service = service;
    }

    @PostMapping(value = "/income")
    public SockRsDto incomeSock(@RequestBody SockRqDto sock) {
        return service.incomeSocks(sock);
    }

    @DeleteMapping(value = "/outcome")
    public SockRsDto outcomeSock(@RequestBody SockRqDto sock) {
        return service.outcomeSocks(sock);

    }

    @GetMapping
    public Integer getSocksQuantity(@Param(value = "color") String color, @Param(value = "operations") String operations, @Param(value = "cotton") Integer cotton) {
        return service.getQuantity(color, operations, cotton);
    }
}
