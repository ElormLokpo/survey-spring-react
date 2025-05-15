package com.example.backend.dtos.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ErrorResponseDto extends ResponseDto {
    public String details;
}
