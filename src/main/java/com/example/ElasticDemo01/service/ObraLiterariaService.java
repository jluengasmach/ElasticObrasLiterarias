package com.example.ElasticDemo01.service;

import com.example.ElasticDemo01.dto.ObraLiterariaDTO;
import com.example.ElasticDemo01.dto.ResponseDto;

import java.util.List;

public interface ObraLiterariaService {

    ResponseDto saveBook(ObraLiterariaDTO bookDTO);

    List<ObraLiterariaDTO> getAll();
}
