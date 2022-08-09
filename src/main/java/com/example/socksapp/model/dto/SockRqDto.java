package com.example.socksapp.model.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SockRqDto {
    private String color;
    private Integer cotton;
    private Integer quantity;
}
