package com.capgemini.pocelasticsearch.controller;

import com.capgemini.pocelasticsearch.database.documents.LivreDocument;
import com.capgemini.pocelasticsearch.service.LivreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/livres")
public class LivreController {

    private final LivreService service;

    @PostMapping
    public void save(@RequestBody final LivreDocument livre) {
        service.save(livre);
    }

    @GetMapping("/{id}")
    public LivreDocument findById(@PathVariable final String id) {
        return service.findById(id);
    }

    @GetMapping
    public Page <LivreDocument> findAll(@PageableDefault final Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("/authorName")
    public Page <LivreDocument> findAll(@PathVariable final String authorName){
        return service.findByAuthor(authorName);
    }

}
