package com.example.ElasticDemo01.repository;

import com.example.ElasticDemo01.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;

public interface  ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findAll();
}
