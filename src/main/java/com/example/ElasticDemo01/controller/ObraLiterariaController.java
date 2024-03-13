package com.example.ElasticDemo01.controller;

import com.example.ElasticDemo01.dto.ObraLiterariaDTO;
import com.example.ElasticDemo01.service.ObraLiterariaServiceImpl;
import com.example.ElasticDemo01.service.ObraLiterariaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/book")
@RestController
public class ObraLiterariaController {

    private ObraLiterariaService service;

    public ObraLiterariaController(ObraLiterariaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody ObraLiterariaDTO obraLiterariaDTO){
        return new ResponseEntity<>(service.saveBook(obraLiterariaDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(required = false) String author, @RequestParam(required = false) String title) {
        return new ResponseEntity<>(service.getAll(author, title),HttpStatus.OK);
    }

    @GetMapping("/top-five")
    public ResponseEntity<?> getTopFiveByPages() {
        return new ResponseEntity<>(service.getTopFiveByPages(), HttpStatus.OK);
    }
}
