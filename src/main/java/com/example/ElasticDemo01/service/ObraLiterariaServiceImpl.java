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
    public List<ObraLiterariaDTO> getAll(String author, String title) {
        List<ObraLiteraria> obrasLiterarias;
        ModelMapper mapper = new ModelMapper();

        if (author != null) {
            obrasLiterarias = getByAuthor(author);
        } else if (title != null) {
            obrasLiterarias = repository.findByTitle(title);
        } else {
            obrasLiterarias = repository.findAll();
        }
        return obrasLiterarias.stream().map(e -> mapper.map(e, ObraLiterariaDTO.class)).toList();
    }

    @Override
    public List<ObraLiterariaDTO> getTopFiveByPages() {
        List<ObraLiteraria> obrasLiterarias = repository.findTop5ByOrderByCantidadPaginasDesc();
        return obrasLiterarias.stream().map(e -> new ModelMapper().map(e, ObraLiterariaDTO.class)).toList();
    }

    private List<ObraLiteraria> getByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    private List<ObraLiteraria> getByTitle(String title) {
        return repository.findByTitle(title);
    }

}
