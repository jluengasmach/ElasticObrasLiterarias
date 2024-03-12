package com.example.ElasticDemo01.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obras-literarias")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiteraria {
    @Id
    String id;
    String nombre;
    String autor;
    Integer cantidadPaginas;
    String editorial;
    @Field(type = FieldType.Date)
    LocalDate fechaPublicacion;
}
