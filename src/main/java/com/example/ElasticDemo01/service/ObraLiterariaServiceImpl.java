package com.example.ElasticDemo01.service;

import com.example.ElasticDemo01.dto.ObraLiterariaDTO;
import com.example.ElasticDemo01.dto.ResponseDto;
import com.example.ElasticDemo01.entity.ObraLiteraria;
import com.example.ElasticDemo01.repository.ObraLiterariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.ElasticDemo01.util.MapperClass.dtoToEntity;

@Service
public class ObraLiterariaServiceImpl implements ObraLiterariaService {

    ObraLiterariaRepository repository;

    public ObraLiterariaServiceImpl(ObraLiterariaRepository repository){
        this.repository = repository;
    }
    @Override
    public ResponseDto saveBook(ObraLiterariaDTO obraLiterariaDTO) {
        ObraLiteraria obraLiteraria = dtoToEntity(obraLiterariaDTO);
        repository.save(obraLiteraria);
        return new ResponseDto("It's all fine");
    }

    @Override
    public List<ObraLiterariaDTO> getAll() {
        ModelMapper mapper = new ModelMapper();
        List<ObraLiteraria> obrasLiterarias = repository.findAll();

        return obrasLiterarias.stream().map(e -> mapper.map(e, ObraLiterariaDTO.class)).toList();
    }
}
