package com.example.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.backend.dtos.qresponse.CreateQResponseDto;
import com.example.backend.dtos.qresponse.GetQResponseDto;
import com.example.backend.models.QResponseModel;

@Mapper
public interface QResponseMapper {
    QResponseMapper INSTANCE = Mappers.getMapper(QResponseMapper.class);

    public QResponseModel qresponseDtoToModel(CreateQResponseDto createQResponseDto);

    public GetQResponseDto qresponseModelToDto(QResponseModel qresponseModel);

}
