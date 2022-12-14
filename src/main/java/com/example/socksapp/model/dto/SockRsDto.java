package com.example.socksapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SockRsDto {
    @NotNull
    private Long id;
    private String color;
    private Integer cotton;
    private Integer quantity;
}
