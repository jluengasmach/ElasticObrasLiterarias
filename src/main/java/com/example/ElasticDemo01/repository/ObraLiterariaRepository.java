package com.example.ElasticDemo01.repository;

import com.example.ElasticDemo01.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;

public interface  ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findAll();

    @Query("{\"bool\": {\"must\": [{\"match\": {\"autor.keyword\": \"?0\"}}]}}")
    List<ObraLiteraria> findByAuthor(String author);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"nombre.keyword\": \"?0\"}}]}}")
    List<ObraLiteraria> findByTitle(String title);

    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();
}
