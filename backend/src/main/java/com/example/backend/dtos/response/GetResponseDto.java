package com.example.backend.dtos.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class GetResponseDto extends ResponseDto {
    public int totalPages;
    public int pageNumber;
    public int pageSize;
}
